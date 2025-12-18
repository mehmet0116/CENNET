# Hızlı Başlangıç Rehberi ⚡

CENNET uygulamasını 5 dakikada Android Studio'da çalıştırın!

## 📋 Ön Hazırlık (Sadece İlk Kez)

### 1. Gerekli Yazılımlar

- ✅ **Android Studio** (En son sürüm)
- ✅ **JDK 17** (Android Studio ile birlikte gelir)
- ✅ **Git** (İsteğe bağlı)

### 2. İndirme

Android Studio henüz yoksa:
👉 [developer.android.com/studio](https://developer.android.com/studio)

## 🚀 3 Adımda Başlangıç

### Adım 1️⃣: Projeyi İndirin

**Seçenek A - Git ile:**
```bash
git clone https://github.com/mehmet0116/CENNET.git
```

**Seçenek B - ZIP ile:**
1. GitHub sayfasında yeşil "Code" butonuna tıklayın
2. "Download ZIP" seçin
3. İndirilen dosyayı açın

### Adım 2️⃣: Android Studio'da Açın

1. Android Studio'yu başlatın
2. **"Open"** butonuna tıklayın
3. **CENNET** klasörünü seçin
4. **"OK"** yapın

⏱️ *İlk açılış 5-10 dakika sürebilir (Gradle indiriliyor)*

### Adım 3️⃣: Çalıştırın

**A) Gerçek Telefonla:**
1. Telefonda: `Ayarlar` → `Telefon Hakkında` → `Yapı Numarası`'na 7 kez dokun
2. `Geliştirici Seçenekleri` → `USB Hata Ayıklama` açın
3. Telefonu USB ile bağlayın
4. Android Studio'da yeşil ▶️ butonuna basın

**B) Emülatörle:**
1. Android Studio'da `Device Manager` açın
2. `Create Device` → Pixel 7 seçin → API 34 indirin
3. `Finish` yapın
4. Yeşil ▶️ butonuna basın

## ✨ İşte Bu Kadar!

Uygulama şimdi çalışıyor olmalı! 🎉

## 🆘 Hata Alıyorsanız?

### "Gradle sync failed"
```bash
# Terminalde:
./gradlew clean
```

### "SDK location not found"
- `File` → `Project Structure` → `SDK Location` yolunu kontrol edin

### Emülatör açılmıyor
- `Tools` → `Device Manager` → AVD'yi silin ve yeniden oluşturun

## 📚 Daha Fazla Yardım

- 📖 Detaylı rehber: [ANDROID_SETUP_TR.md](ANDROID_SETUP_TR.md)
- 🤝 Katkıda bulunma: [CONTRIBUTING.md](CONTRIBUTING.md)
- ❓ Sorular için: [GitHub Issues](https://github.com/mehmet0116/CENNET/issues)

## 🎯 Sonraki Adımlar

✅ Uygulamayı keşfedin  
✅ Kodu inceleyin  
✅ Değişiklik yapın  
✅ Katkıda bulunun  

---

**Kolay gelsin! 💻✨**
