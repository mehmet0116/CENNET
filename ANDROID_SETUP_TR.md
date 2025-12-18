# Android Studio Kurulum Rehberi 📱

Bu rehber, CENNET uygulamasını Android Studio'da derlemeniz için adım adım yönergeler içerir.

## 🔧 Önkoşullar

### 1. Java Development Kit (JDK) Kurulumu

Android Studio, JDK 17 gerektirir.

**Windows için:**
1. [Oracle JDK 17](https://www.oracle.com/java/technologies/downloads/#java17) veya [OpenJDK](https://adoptium.net/) indirin
2. İndirilen dosyayı çalıştırın ve kurulumu tamamlayın
3. Sistem değişkenlerine `JAVA_HOME` ekleyin

**macOS için:**
```bash
brew install openjdk@17
```

**Linux için:**
```bash
sudo apt update
sudo apt install openjdk-17-jdk
```

### 2. Android Studio Kurulumu

1. [Android Studio](https://developer.android.com/studio) resmi sitesinden indirin
2. İndirilen dosyayı çalıştırın
3. Kurulum sihirbazını takip edin:
   - "Standard" kurulumu seçin
   - Android SDK'yı otomatik olarak indirecektir
   - Android Virtual Device (AVD) kurulumunu kabul edin

### 3. Android SDK Kurulumu

Android Studio ilk açılışta SDK'yı otomatik kurar. Manuel kontrol için:

1. Android Studio'yu açın
2. `Tools` > `SDK Manager` seçin
3. Şu bileşenleri kurun:
   - Android SDK Platform 34 (Android 14)
   - Android SDK Build-Tools 34
   - Android Emulator
   - Android SDK Platform-Tools

## 📥 Projeyi İçe Aktarma

### Adım 1: Depoyu Klonlayın

```bash
git clone https://github.com/mehmet0116/CENNET.git
cd CENNET
```

### Adım 2: Android Studio'da Açın

1. Android Studio'yu başlatın
2. Açılış ekranında **"Open"** butonuna tıklayın
3. CENNET klasörünü bulun ve seçin
4. **"OK"** butonuna tıklayın

### Adım 3: Gradle Senkronizasyonu

İlk açılışta Android Studio otomatik olarak:
1. Gradle wrapper'ı indirecek
2. Bağımlılıkları çözümleyecek
3. Projeyi build edecek

Bu işlem internet hızınıza bağlı olarak 5-10 dakika sürebilir.

**Not:** Eğer `local.properties` dosyası yoksa, Android Studio otomatik oluşturacaktır.

## 🔨 Projeyi Derleme

### IDE'den Derleme

1. Menüden `Build` > `Make Project` seçin
2. Veya klavyeden `Ctrl+F9` (Windows/Linux) / `Cmd+F9` (Mac) tuşlarına basın
3. Build işlemi tamamlanana kadar bekleyin

### Komut Satırından Derleme

**Windows:**
```bash
gradlew.bat assembleDebug
```

**Mac/Linux:**
```bash
./gradlew assembleDebug
```

## 📱 Uygulamayı Çalıştırma

### Gerçek Cihazda Çalıştırma

#### Telefon Hazırlığı:

1. **Geliştirici Seçeneklerini Açın:**
   - `Ayarlar` > `Telefon Hakkında` gidin
   - `Yapı Numarası`na 7 kez dokunun
   - "Artık bir geliştiricsiniz" mesajını göreceksiniz

2. **USB Hata Ayıklamayı Etkinleştirin:**
   - `Ayarlar` > `Geliştirici Seçenekleri` gidin
   - `USB Hata Ayıklama` seçeneğini açın

3. **Telefonu Bağlayın:**
   - USB kablosu ile telefonu bilgisayara bağlayın
   - Telefonunuzda "USB hata ayıklamaya izin ver" mesajını onaylayın

#### Uygulamayı Çalıştırma:

1. Android Studio'da üst araç çubuğundan cihazınızı seçin
2. Yeşil "Run" (▶) butonuna tıklayın
3. Veya `Shift+F10` (Windows/Linux) / `Ctrl+R` (Mac) tuşlarına basın

### Emülatörde Çalıştırma

#### AVD (Android Virtual Device) Oluşturma:

1. Android Studio'da `Tools` > `Device Manager` seçin
2. `Create Device` butonuna tıklayın
3. Bir cihaz modeli seçin (örn: Pixel 7)
4. Sistem imajı seçin:
   - **Önerilen:** API 34 (Android 14)
   - **Minimum:** API 24 (Android 7.0)
5. `Download` butonuna tıklayın (ilk kez)
6. AVD yapılandırmasını tamamlayın
7. `Finish` butonuna tıklayın

#### Emülatörü Başlatma:

1. Device Manager'dan oluşturduğunuz AVD'yi seçin
2. Yeşil play (▶) butonuna tıklayın
3. Emülatör başladıktan sonra Android Studio'da "Run" yapın

## 📦 APK Oluşturma

### Debug APK

**IDE'den:**
1. `Build` > `Build Bundle(s) / APK(s)` > `Build APK(s)`
2. İşlem tamamlandığında "locate" linkine tıklayın
3. APK dosyası: `app/build/outputs/apk/debug/app-debug.apk`

**Komut satırından:**
```bash
./gradlew assembleDebug
```

### Release APK (İmzalı)

#### Keystore Oluşturma:

1. `Build` > `Generate Signed Bundle / APK` seçin
2. `APK` seçeneğini işaretleyin, `Next`
3. `Create new...` butonuna tıklayın
4. Keystore bilgilerini doldurun:
   - **Key store path:** Güvenli bir konum seçin
   - **Password:** Güçlü bir şifre belirleyin
   - **Alias:** Bir anahtar takma adı girin
   - **Password:** Anahtar şifresi
   - **Validity:** 25 yıl önerilir
   - **Certificate:** İsim ve organizasyon bilgileri
5. `OK` ve `Next` butonlarına tıklayın
6. `release` build type seçin
7. `Finish` butonuna tıklayın

APK dosyası: `app/release/app-release.apk`

**ÖNEMLİ:** Keystore dosyasını ve şifresini güvenli bir yerde saklayın!

## 🐛 Sorun Giderme

### Gradle Sync Hataları

**Hata: "Failed to sync Gradle project"**

Çözümler:
1. İnternet bağlantınızı kontrol edin
2. `File` > `Invalidate Caches / Restart` seçin
3. `.gradle` klasörünü silin ve projeyi yeniden açın
4. Gradle wrapper sürümünü güncelleyin

### SDK Hataları

**Hata: "SDK location not found"**

Çözüm:
1. `local.properties` dosyası oluşturun
2. İçine şunu ekleyin:
   ```
   sdk.dir=/path/to/your/Android/Sdk
   ```
3. Yolu kendi SDK konumunuzla değiştirin

### Emülatör Sorunları

**Emülatör çok yavaş:**
- HAXM (Intel) veya Hypervisor kurulumunu kontrol edin
- AVD ayarlarında RAM miktarını azaltın (2GB önerilir)
- Grafik ayarını "Hardware" yerine "Software" yapın

**Emülatör başlamıyor:**
- BIOS'ta VT-x/AMD-V etkinleştirildiğinden emin olun
- Antivirus yazılımlarını geçici olarak devre dışı bırakın
- Device Manager'dan AVD'yi silin ve yeniden oluşturun

### Build Hataları

**Hata: "Execution failed for task ':app:compileDebugKotlin'"**

Çözümler:
1. JDK sürümünü kontrol edin (17 olmalı)
2. `Build` > `Clean Project` yapın
3. `Build` > `Rebuild Project` yapın

**Hata: "Unable to resolve dependency"**

Çözüm:
1. İnternet bağlantınızı kontrol edin
2. Gradle sync yeniden yapın
3. Maven deposu erişimini kontrol edin

## 💡 İpuçları

1. **Hızlı Build için:**
   - Gradle daemon'u aktif tutun
   - Build cache kullanın
   - Parallel build etkinleştirin

2. **Geliştirme için:**
   - Hot reload için Instant Run kullanın
   - Logcat'i düzenli kontrol edin
   - Layout Inspector ile UI'ı debug edin

3. **Performans:**
   - Android Studio için yeterli RAM ayırın (min 8GB önerilir)
   - SSD kullanın
   - Gereksiz eklentileri devre dışı bırakın

## 📚 Ek Kaynaklar

- [Android Developer Documentation](https://developer.android.com/docs)
- [Kotlin Documentation](https://kotlinlang.org/docs/home.html)
- [Android Studio User Guide](https://developer.android.com/studio/intro)
- [Gradle Documentation](https://docs.gradle.org/)

## 🆘 Yardım

Sorun yaşıyorsanız:
1. Bu rehberi baştan okuyun
2. GitHub Issues sayfasına bakın
3. Yeni bir issue açın (sorun detaylarıyla birlikte)

---

**Başarılar dileriz! 🎉**
