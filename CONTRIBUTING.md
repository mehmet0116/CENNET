# Katkıda Bulunma Rehberi 🤝

CENNET projesine katkıda bulunmak istediğiniz için teşekkür ederiz! Bu rehber, projeye nasıl katkıda bulunabileceğinizi açıklar.

## 🌟 Katkı Türleri

Aşağıdaki şekillerde katkıda bulunabilirsiniz:

- 🐛 Hata bildirimleri (Bug reports)
- 💡 Yeni özellik önerileri
- 📝 Dokümantasyon iyileştirmeleri
- 🎨 Tasarım ve UI iyileştirmeleri
- 🔧 Kod iyileştirmeleri
- 🌍 Çeviri ve yerelleştirme
- 📱 Test ve geri bildirim

## 🚀 Başlarken

### 1. Depoyu Fork Edin

1. GitHub'da projenin sağ üst köşesindeki "Fork" butonuna tıklayın
2. Kendi hesabınıza bir kopya oluşturun

### 2. Yerel Kopyanızı Oluşturun

```bash
git clone https://github.com/KULLANICI_ADINIZ/CENNET.git
cd CENNET
```

### 3. Upstream Ekleyin

```bash
git remote add upstream https://github.com/mehmet0116/CENNET.git
```

### 4. Geliştirme Ortamını Kurun

- Android Studio'yu yükleyin (bkz. ANDROID_SETUP_TR.md)
- Projeyi Android Studio'da açın
- Gradle sync işlemini bekleyin

## 📋 Geliştirme Süreci

### Branch Oluşturma

Her özellik veya düzeltme için yeni bir branch oluşturun:

```bash
git checkout -b feature/ozellik-adi
# veya
git checkout -b bugfix/hata-adi
```

Branch isimlendirme kuralları:
- `feature/` - Yeni özellikler için
- `bugfix/` - Hata düzeltmeleri için
- `docs/` - Dokümantasyon için
- `refactor/` - Kod iyileştirmeleri için

### Kod Standartları

#### Kotlin Kodu

```kotlin
// İyi örnek
class MainActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupWebView()
    }
    
    private fun setupWebView() {
        // Açıklayıcı fonksiyon isimleri
        // Her fonksiyon tek bir görevi yerine getirmeli
    }
}
```

#### HTML/JavaScript

```javascript
// Türkçe yorum satırları ekleyin
function baslatOyun() {
    // Oyunu başlatır
    oyunDurumu = 'aktif';
    skoruSifirla();
}
```

### Commit Mesajları

Anlamlı commit mesajları yazın:

```bash
# İyi örnekler
git commit -m "Oyun skoru kaydetme özelliği eklendi"
git commit -m "WebView yükleme hızı iyileştirildi"
git commit -m "Türkçe dil desteği düzeltildi"

# Kötü örnekler
git commit -m "düzeltme"
git commit -m "güncelleme"
```

Commit mesaj formatı:
```
Kısa özet (50 karakter veya daha az)

Daha detaylı açıklama gerekirse, boş satırdan sonra
yazın. Her satır 72 karakteri geçmemeli.

- Madde işaretleri kullanabilirsiniz
- Neyin değiştiğini açıklayın
- Neden değiştiğini belirtin
```

## 🧪 Test Etme

Değişikliklerinizi test edin:

### Manuel Test

1. Uygulamayı hem emülatörde hem gerçek cihazda test edin
2. Farklı Android sürümlerinde deneyin (min: API 24)
3. Tüm oyun modlarını kontrol edin
4. Gece modu ve gündüz modunda test edin

### Kontrol Listesi

- [ ] Uygulama hatasız başlıyor mu?
- [ ] Tüm butonlar çalışıyor mu?
- [ ] Sesler düzgün çalıyor mu?
- [ ] LocalStorage kayıtları tutuluyor mu?
- [ ] Geri butonu doğru çalışıyor mu?
- [ ] Ekran döndürmede sorun var mı?

## 📤 Pull Request Gönderme

### 1. Son Değişiklikleri Alın

```bash
git checkout main
git pull upstream main
git checkout feature/ozellik-adi
git rebase main
```

### 2. Değişikliklerinizi Push Edin

```bash
git push origin feature/ozellik-adi
```

### 3. Pull Request Oluşturun

1. GitHub'da fork ettiğiniz depoya gidin
2. "Pull Request" butonuna tıklayın
3. Değişikliklerinizi açıklayın:

```markdown
## Değişiklikler

- Eklenen özellik 1
- Düzeltilen hata 2
- İyileştirilen performans 3

## Test Edilen Ortamlar

- Android 14 (API 34) - Pixel 7 Emulator
- Android 10 (API 29) - Samsung Galaxy S10

## Ekran Görüntüleri

(Varsa ekran görüntüleri ekleyin)

## İlgili Issue'lar

Fixes #123
Related to #456
```

### Pull Request Kontrol Listesi

- [ ] Kod derlenebiliyor
- [ ] Test edildi ve çalışıyor
- [ ] Yeni özellikler dokümante edildi
- [ ] Commit mesajları açıklayıcı
- [ ] Kod stili uygun
- [ ] Gereksiz değişiklik yok

## 🐛 Hata Bildirme

Hata bildirirken şu bilgileri ekleyin:

```markdown
## Hata Açıklaması
Kısa ve net hata açıklaması

## Tekrar Etme Adımları
1. Uygulamayı açın
2. X butonuna tıklayın
3. Y ekranına gidin
4. Hatayı görün

## Beklenen Davranış
Ne olmasını bekliyordunuz?

## Gerçek Davranış
Ne oldu?

## Ekran Görüntüleri
(Varsa ekleyin)

## Cihaz Bilgileri
- Cihaz: Samsung Galaxy S21
- Android Sürümü: 13
- Uygulama Sürümü: 1.0

## Ek Bilgiler
Logcat çıktısı veya diğer detaylar
```

## 💡 Özellik Önerisi

Yeni özellik önerirken:

```markdown
## Özellik Açıklaması
Eklemek istediğiniz özelliği açıklayın

## Motivasyon
Bu özellik neden gerekli?

## Çözüm Önerisi
Nasıl implement edilebilir?

## Alternatifler
Başka çözümler düşündünüz mü?

## Ek Bilgiler
Mockup'lar, tasarımlar, vs.
```

## 📜 Kod İnceleme Süreci

Pull request'iniz incelenirken:

1. Otomatik testler çalışacak
2. Kod incelemesi yapılacak
3. Geri bildirim alabilirsiniz
4. Gerekirse değişiklik yapmanız istenebilir

### Değişiklik Yapma

```bash
# Aynı branch'te değişiklik yapın
git add .
git commit -m "İnceleme sonrası düzeltmeler"
git push origin feature/ozellik-adi
```

Pull request otomatik güncellenecektir.

## 🎯 İyi Pratikler

1. **Küçük ve Odaklı PR'lar:** Her PR bir sorunu çözmeli
2. **Test Edin:** Değişikliklerinizi iyice test edin
3. **Dokümante Edin:** Kod ve değişiklikleri açıklayın
4. **Sabırlı Olun:** İnceleme süreci zaman alabilir
5. **İletişimde Kalın:** Sorular sorun, geri bildirim verin

## 🌍 Çeviri Katkısı

Uygulamayı başka dillere çevirmek için:

1. `app/src/main/res/values-[DIL_KODU]/` klasörü oluşturun
2. `strings.xml` dosyasını çevirin
3. Test edin
4. Pull request gönderin

## 📞 İletişim

- GitHub Issues: Teknik sorular için
- Pull Requests: Kod incelemeleri için
- Discussions: Genel tartışmalar için

## 🙏 Teşekkürler

Her katkı değerlidir! Projeyi geliştirmek için zaman ayırdığınız için teşekkür ederiz.

---

**Happy Coding! 💻**
