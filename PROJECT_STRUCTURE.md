# 📱 Android Proje Yapısı - Özet

Bu belge, CENNET Android projesinin tüm dosyalarını ve yapısını açıklar.

## 📂 Proje Yapısı

```
CENNET/
├── 📄 Dokümantasyon Dosyaları
│   ├── README.md                      # Ana proje açıklaması
│   ├── QUICKSTART.md                  # Hızlı başlangıç rehberi
│   ├── ANDROID_SETUP_TR.md           # Detaylı kurulum rehberi
│   ├── CONTRIBUTING.md                # Katkıda bulunma rehberi
│   └── local.properties.template      # SDK yapılandırma şablonu
│
├── ⚙️ Gradle Yapılandırma Dosyaları
│   ├── build.gradle                   # Proje seviyesi Gradle
│   ├── settings.gradle                # Proje ayarları
│   ├── gradle.properties              # Gradle özellikleri
│   ├── gradlew                        # Gradle wrapper (Unix)
│   ├── gradlew.bat                    # Gradle wrapper (Windows)
│   └── gradle/wrapper/
│       └── gradle-wrapper.properties  # Wrapper yapılandırması
│
├── 🤖 GitHub Actions CI/CD
│   └── .github/workflows/
│       └── android-build.yml          # Otomatik build işlemi
│
├── 📱 Android Uygulama Modülü (app/)
│   ├── build.gradle                   # Uygulama seviyesi Gradle
│   ├── proguard-rules.pro            # ProGuard kuralları
│   │
│   └── src/main/
│       ├── 📋 AndroidManifest.xml     # Uygulama manifest
│       │
│       ├── ☕ Kotlin Kaynak Kodu
│       │   └── java/com/mete/cennet/
│       │       └── MainActivity.kt    # Ana Activity (WebView)
│       │
│       ├── 📦 Assets (HTML Uygulama)
│       │   └── index.html            # Web uygulaması
│       │
│       └── 🎨 Resources
│           ├── drawable/
│           │   └── ic_launcher_foreground.xml  # Launcher ön plan
│           │
│           ├── mipmap-*/             # Launcher ikonları (5 yoğunluk)
│           │   ├── ic_launcher.png
│           │   └── ic_launcher_round.png
│           │
│           ├── mipmap-anydpi-v26/    # Adaptive ikonlar
│           │   ├── ic_launcher.xml
│           │   └── ic_launcher_round.xml
│           │
│           ├── values/
│           │   ├── strings.xml       # Metin kaynakları
│           │   ├── colors.xml        # Renk tanımları
│           │   ├── themes.xml        # Tema tanımları
│           │   └── ic_launcher_background.xml
│           │
│           └── xml/
│               ├── backup_rules.xml          # Yedekleme kuralları
│               └── data_extraction_rules.xml # Veri çıkarma kuralları
│
├── 🌐 Web Versiyonu
│   └── index.html                    # Orijinal web uygulaması
│
└── 🚫 .gitignore                     # Git ignore kuralları
```

## 📋 Dosya Açıklamaları

### Kök Dizin Dosyaları

| Dosya | Boyut | Açıklama |
|-------|-------|----------|
| `README.md` | 4.2KB | Proje hakkında genel bilgi ve kurulum talimatları |
| `QUICKSTART.md` | 2.2KB | 5 dakikada başlangıç rehberi |
| `ANDROID_SETUP_TR.md` | 6.9KB | Detaylı Android Studio kurulum rehberi |
| `CONTRIBUTING.md` | 6.2KB | Projeye katkıda bulunma rehberi |
| `build.gradle` | 359B | Proje seviyesi Gradle yapılandırması |
| `settings.gradle` | 324B | Gradle proje ayarları |
| `gradle.properties` | 1.4KB | Gradle özellikleri ve JVM ayarları |
| `gradlew` | 8.4KB | Gradle wrapper script (Unix/Linux/Mac) |
| `gradlew.bat` | 2.8KB | Gradle wrapper script (Windows) |
| `.gitignore` | 1.5KB | Git versiyon kontrol ignore kuralları |

### Uygulama Modülü (app/)

| Dosya | Boyut | Açıklama |
|-------|-------|----------|
| `app/build.gradle` | 1.3KB | Uygulama yapılandırması ve bağımlılıklar |
| `app/proguard-rules.pro` | 1.3KB | Kod gizleme ve optimizasyon kuralları |
| `AndroidManifest.xml` | 1.2KB | Uygulama izinleri ve component tanımları |
| `MainActivity.kt` | 3.9KB | Ana Activity - WebView implementasyonu |

### Resource Dosyaları

| Dosya | Açıklama |
|-------|----------|
| `strings.xml` | Uygulama metinleri (Türkçe) |
| `colors.xml` | Renk tanımları |
| `themes.xml` | Material Design tema |
| `ic_launcher_background.xml` | Launcher ikon arkaplan rengi |
| `ic_launcher_foreground.xml` | Launcher ikon ön plan (SVG) |
| `backup_rules.xml` | Bulut yedekleme kuralları |
| `data_extraction_rules.xml` | Android 12+ veri aktarım kuralları |

### Launcher İkonları

5 farklı ekran yoğunluğu için ikonlar:
- `mdpi` (48x48px)
- `hdpi` (72x72px)
- `xhdpi` (96x96px)
- `xxhdpi` (144x144px)
- `xxxhdpi` (192x192px)

Her biri için:
- `ic_launcher.png` - Kare ikon
- `ic_launcher_round.png` - Yuvarlak ikon

## 🔧 Önemli Yapılandırmalar

### Gradle Bağımlılıkları

```gradle
// AndroidX Core
androidx.core:core-ktx:1.12.0
androidx.appcompat:appcompat:1.6.1

// Material Design
com.google.android.material:material:1.11.0

// Layout
androidx.constraintlayout:constraintlayout:2.1.4

// WebView
androidx.webkit:webkit:1.9.0
```

### Android Yapılandırması

```gradle
compileSdk: 34 (Android 14)
minSdk: 24 (Android 7.0)
targetSdk: 34 (Android 14)
```

### Uygulama İzinleri

```xml
android.permission.INTERNET
android.permission.ACCESS_NETWORK_STATE
```

## 🎯 Özellikler

### MainActivity Özellikleri

✅ WebView ile tam HTML5 desteği  
✅ JavaScript etkin  
✅ LocalStorage desteği  
✅ Tam ekran immersive mod  
✅ Geri tuşu navigasyonu  
✅ Donanım ivmesi  
✅ Medya otomatik oynatma  
✅ Ekran yönlendirme desteği  

### WebView Ayarları

```kotlin
javaScriptEnabled = true
domStorageEnabled = true
databaseEnabled = true
allowFileAccess = true
setSupportZoom(true)
loadWithOverviewMode = true
useWideViewPort = true
mediaPlaybackRequiresUserGesture = false
```

## 📊 Proje İstatistikleri

- **Toplam Dosya Sayısı**: ~50
- **Toplam Kod Satırı**: ~300 (Kotlin) + 8450 (HTML/JS)
- **Dokümantasyon**: ~17 KB (4 dosya)
- **Minimum Android API**: 24 (Android 7.0)
- **Hedef Android API**: 34 (Android 14)
- **Launcher İkonları**: 10 PNG + 4 XML
- **Gradle Plugins**: Android Application + Kotlin

## 🚀 Build Komutları

### Debug Build
```bash
./gradlew assembleDebug
```
Çıktı: `app/build/outputs/apk/debug/app-debug.apk`

### Release Build
```bash
./gradlew assembleRelease
```
Çıktı: `app/build/outputs/apk/release/app-release.apk`

### Clean Build
```bash
./gradlew clean build
```

### Install to Device
```bash
./gradlew installDebug
```

## 📝 Notlar

1. **index.html**: Assets klasöründe WebView tarafından yüklenir
2. **Çoklu DPI**: Her ekran yoğunluğu için optimum ikon boyutu
3. **Adaptive Icons**: Android 8.0+ için adaptive launcher ikonları
4. **ProGuard**: Release build'lerde kod küçültme aktif
5. **CI/CD**: GitHub Actions ile otomatik build ve test

## 🔄 Güncelleme Geçmişi

- **v1.0**: İlk Android Studio projesi oluşturuldu
- Tam WebView implementasyonu
- Material Design 3 teması
- Kapsamlı dokümantasyon
- CI/CD pipeline

## 📞 Destek

Sorularınız için:
- 📖 Dokümantasyon dosyalarına bakın
- 🐛 GitHub Issues kullanın
- 💬 Discussions'ta soru sorun

---

**Son Güncelleme**: Aralık 2024  
**Proje Versiyonu**: 1.0  
**Android Grade Plugin**: 8.2.0  
**Kotlin Versiyonu**: 1.9.20
