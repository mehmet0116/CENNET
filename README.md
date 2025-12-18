# CENNET - Mete'nin Eğitici Dünyası 🎓

Türkçe eğitici içerikli bir çocuk uygulaması. HTML5 tabanlı interaktif öğrenme deneyimi Android telefonlarda çalışır.

## 📱 Android Uygulaması

Bu proje Android Studio'da derlenebilir ve Android telefonlarda çalışabilir.

### Gereksinimler

- **Android Studio**: Giraffe (2022.3.1) veya daha yeni
- **JDK**: 17 veya daha yeni
- **Android SDK**: API 34 (Android 14)
- **Minimum Android Sürümü**: API 24 (Android 7.0)

### Kurulum Adımları

1. **Projeyi klonlayın:**
   ```bash
   git clone https://github.com/mehmet0116/CENNET.git
   cd CENNET
   ```

2. **Android Studio'yu açın:**
   - Android Studio'yu başlatın
   - "Open" seçeneğine tıklayın
   - CENNET klasörünü seçin

3. **Gradle Sync:**
   - Android Studio otomatik olarak Gradle dosyalarını senkronize edecektir
   - İlk açılışta biraz zaman alabilir

4. **Projeyi Derleyin:**
   - Menüden `Build` > `Make Project` seçin
   - Veya klavyeden `Ctrl+F9` (Windows/Linux) veya `Cmd+F9` (Mac) tuşlarına basın

5. **Uygulamayı Çalıştırın:**
   - **Gerçek Cihazda:**
     - Telefonunuzda Geliştirici Seçeneklerini aktifleştirin
     - USB Hata Ayıklamayı açın
     - Telefonu bilgisayara bağlayın
     - Android Studio'da `Run` > `Run 'app'` seçin
   
   - **Emülatörde:**
     - Android Studio'da `AVD Manager`'ı açın
     - Yeni bir sanal cihaz oluşturun (minimum API 24)
     - Emülatörü başlatın
     - `Run` > `Run 'app'` seçin

### Proje Yapısı

```
CENNET/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/mete/cennet/
│   │   │   │   └── MainActivity.kt
│   │   │   ├── res/
│   │   │   │   ├── layout/
│   │   │   │   ├── values/
│   │   │   │   ├── drawable/
│   │   │   │   └── mipmap-*/
│   │   │   ├── assets/
│   │   │   │   └── index.html
│   │   │   └── AndroidManifest.xml
│   │   └── build.gradle
│   └── proguard-rules.pro
├── gradle/
│   └── wrapper/
├── build.gradle
├── settings.gradle
├── gradle.properties
├── gradlew
├── gradlew.bat
└── index.html (Web versiyonu)
```

### Özellikler

✅ **HTML5 WebView** ile tam özellikli web uygulaması  
✅ **JavaScript Desteği** - Tüm interaktif özellikler çalışır  
✅ **LocalStorage Desteği** - Oyun ilerlemesi kaydedilir  
✅ **Tam Ekran Modu** -몰입edici deneyim  
✅ **Geri Tuşu Desteği** - WebView navigasyonu  
✅ **Hızlandırılmış Rendering** - Donanım ivmesi aktif  

### Öğrenme İçeriği

Uygulama şu konuları kapsar:
- 🔤 Harf öğrenme (Türk alfabesi)
- 🔢 Sayılar ve matematik
- 🎨 Renkler
- 🐾 Hayvanlar
- 🎮 Eğitici oyunlar
- 📚 Hikayeler
- 🎵 Müzik ve sesler
- Ve çok daha fazlası!

### APK Oluşturma

Release APK oluşturmak için:

1. Android Studio'da `Build` > `Generate Signed Bundle / APK` seçin
2. `APK` seçeneğini işaretleyin
3. Keystore oluşturun veya mevcut olanı seçin
4. Build type olarak `release` seçin
5. APK dosyası `app/release/` klasöründe oluşacaktır

### Sorun Giderme

**Gradle sync hatası:**
- Android Studio'yu ve Gradle'ı güncelleyin
- `File` > `Invalidate Caches / Restart` yapın

**Emülatör çalışmıyor:**
- HAXM veya Hypervisor kurulu olduğundan emin olun
- AVD ayarlarında RAM'i azaltmayı deneyin

**WebView boş görünüyor:**
- Uygulamayı tamamen kapatıp yeniden açın
- Cache'i temizleyin (`Settings` > `Apps` > `CENNET` > `Clear Cache`)

### Katkıda Bulunma

1. Fork edin
2. Feature branch oluşturun (`git checkout -b feature/AmazingFeature`)
3. Commit yapın (`git commit -m 'Add some AmazingFeature'`)
4. Push edin (`git push origin feature/AmazingFeature`)
5. Pull Request açın

### Lisans

Bu proje açık kaynak kodludur ve eğitim amaçlıdır.

### İletişim

Proje Sahibi: Mehmet  
GitHub: [@mehmet0116](https://github.com/mehmet0116)

### Teşekkürler

Bu uygulama çocukların eğlenerek öğrenmesi için geliştirilmiştir. 🎉

---

**Not:** Bu uygulama ebeveyn gözetiminde kullanılmalıdır.
