# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

# R8 configuration
-keep class com.mete.cennet.** { *; }
-keep class * extends android.webkit.WebChromeClient { *; }
-keep class * extends android.webkit.WebViewClient { *; }

# WebView JavaScript interface
-keepclassmembers class * {
    @android.webkit.JavascriptInterface <methods>;
}

# Keep - Applications. Keep all application classes, along with their 'main'
# method.
-keepclasseswithmembers public class * {
    public static void main(java.lang.String[]);
}

# Keep - Native methods. Keep all native class/method pairs.
-keepclasseswithmembernames class * {
    native <methods>;
}

# Keep - Enum classes. Keep the special static methods that are required in
# enumeration classes.
-keepclassmembers enum * {
    public static **[] values();
    public static ** valueOf(java.lang.String);
}

# Keep - Keep generic signature. Keep attributes that are required for
# reflection.
-keepattributes Signature,InnerClasses,EnclosingMethod

# Keep - Keep runtime annotations.
-keepattributes RuntimeVisibleAnnotations,AnnotationDefault

# For using Kotlin
-keep class kotlin.** { *; }
-keep class kotlin.Metadata { *; }
-dontwarn kotlin.**

# For using Kotlin coroutines
-keep class kotlinx.coroutines.** { *; }
-dontwarn kotlinx.coroutines.**

# AndroidX
-keep class androidx.** { *; }
-dontwarn androidx.**

# Material Components
-keep class com.google.android.material.** { *; }
-dontwarn com.google.android.material.**

# WebKit
-keep class androidx.webkit.** { *; }
-dontwarn androidx.webkit.**