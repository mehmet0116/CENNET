package com.mete.cennet

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout

class MainActivity : AppCompatActivity() {

    private lateinit var webView: WebView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private val BASE_URL = "file:///android_asset/index.html"

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // WebView ve SwipeRefreshLayout'ı başlat
        webView = findViewById(R.id.webView)
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout)

        setupWebView()
        setupSwipeRefresh()
        
        // İnternet bağlantısını kontrol et
        if (isNetworkAvailable()) {
            loadWebContent()
        } else {
            showNoInternetError()
        }
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun setupWebView() {
        webView.apply {
            // WebView ayarları
            settings.apply {
                javaScriptEnabled = true
                domStorageEnabled = true
                databaseEnabled = true
                allowFileAccess = true
                allowContentAccess = true
                loadWithOverviewMode = true
                useWideViewPort = true
                builtInZoomControls = true
                displayZoomControls = false
                setSupportZoom(true)
                defaultTextEncodingName = "utf-8"
                loadsImagesAutomatically = true
                mixedContentMode = 0 // MIXED_CONTENT_ALWAYS_ALLOW
                
                // Cache optimizasyonu
                cacheMode = android.webkit.WebSettings.LOAD_DEFAULT
                setAppCacheEnabled(true)
                setAppCachePath(cacheDir?.absolutePath)
                
                // Performans optimizasyonları
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    safeBrowsingEnabled = true
                }
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    mixedContentMode = android.webkit.WebSettings.MIXED_CONTENT_COMPATIBILITY_MODE
                }
            }

            webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                    // Tüm linkler WebView içinde açılsın
                    return false
                }

                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    swipeRefreshLayout.isRefreshing = false
                    
                    // Sayfa yüklendiğinde JavaScript çalıştır
                    view?.evaluateJavascript("""
                        if (typeof onAndroidLoad === 'function') {
                            onAndroidLoad();
                        }
                    """.trimIndent(), null)
                }

                override fun onReceivedError(
                    view: WebView?,
                    request: WebResourceRequest?,
                    error: WebResourceError?
                ) {
                    super.onReceivedError(view, request, error)
                    swipeRefreshLayout.isRefreshing = false
                    
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                        showError("Yükleme hatası: ${error?.description}")
                    }
                }
            }

            webChromeClient = WebChromeClient()
        }
    }

    private fun setupSwipeRefresh() {
        swipeRefreshLayout.apply {
            setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light
            )
            
            setOnRefreshListener {
                if (isNetworkAvailable()) {
                    webView.reload()
                } else {
                    isRefreshing = false
                    showNoInternetError()
                }
            }
        }
    }

    private fun loadWebContent() {
        try {
            webView.loadUrl(BASE_URL)
        } catch (e: Exception) {
            showError("İçerik yüklenirken hata: ${e.message}")
        }
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val network = connectivityManager.activeNetwork
            val capabilities = connectivityManager.getNetworkCapabilities(network)
            capabilities != null && (capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) ||
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET))
        } else {
            @Suppress("DEPRECATION")
            val networkInfo = connectivityManager.activeNetworkInfo
            networkInfo != null && networkInfo.isConnected
        }
    }

    private fun showNoInternetError() {
        webView.loadDataWithBaseURL(
            null,
            """
            <!DOCTYPE html>
            <html>
            <head>
                <meta charset="utf-8">
                <meta name="viewport" content="width=device-width, initial-scale=1">
                <style>
                    body {
                        font-family: Arial, sans-serif;
                        display: flex;
                        justify-content: center;
                        align-items: center;
                        height: 100vh;
                        margin: 0;
                        background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
                        color: white;
                        text-align: center;
                        padding: 20px;
                    }
                    .container {
                        max-width: 400px;
                    }
                    h1 {
                        font-size: 24px;
                        margin-bottom: 20px;
                    }
                    p {
                        font-size: 16px;
                        margin-bottom: 30px;
                        line-height: 1.5;
                    }
                    .icon {
                        font-size: 64px;
                        margin-bottom: 20px;
                    }
                    button {
                        background: white;
                        color: #667eea;
                        border: none;
                        padding: 12px 24px;
                        font-size: 16px;
                        border-radius: 25px;
                        cursor: pointer;
                        font-weight: bold;
                        transition: transform 0.3s;
                    }
                    button:hover {
                        transform: scale(1.05);
                    }
                </style>
            </head>
            <body>
                <div class="container">
                    <div class="icon">📶</div>
                    <h1>İnternet Bağlantısı Yok</h1>
                    <p>Lütfen internet bağlantınızı kontrol edin ve tekrar deneyin.</p>
                    <button onclick="location.reload()">Tekrar Dene</button>
                </div>
            </body>
            </html>
            """.trimIndent(),
            "text/html",
            "UTF-8",
            null
        )
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack()
        } else {
            super.onBackPressed()
        }
    }

    override fun onResume() {
        super.onResume()
        webView.onResume()
    }

    override fun onPause() {
        super.onPause()
        webView.onPause()
    }

    override fun onDestroy() {
        webView.destroy()
        super.onDestroy()
    }
}