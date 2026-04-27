package org.abdullah.unislot.controller;

import org.abdullah.unislot.entity.Ders;
import org.abdullah.unislot.entity.Sinav;
import org.abdullah.unislot.repository.DersRepository;
import org.abdullah.unislot.repository.SinavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/dersler")
public class DersController {

    @Autowired
    private DersRepository dersRepository;
    @Autowired
    private SinavRepository sinavRepository;

    // Tüm dersleri listeleyen API miz
    @GetMapping
    public List<Ders> getAllDersler() {
        return dersRepository.findAll();
    }
    // Yeni ders ekleme API'miz
    @PostMapping
    public ResponseEntity<Ders> dersEkle(@RequestBody Ders yeniDers) {
        // Vue'dan gelen JSON verisini veritabanına kaydetme işlemini Burada YAPIYORUZ
        Ders kaydedilenDers = dersRepository.save(yeniDers);
        return ResponseEntity.ok(kaydedilenDers);
    }
    @PostMapping("/{id}/salon-ata")
    public ResponseEntity<String> akilliSalonAta(@PathVariable("id") Integer dersId) {
        try {
            // ADIM 1: Sınavlar Tablosuna Yeni Bir Sınav Ekle
            Sinav yeniSinav = new Sinav();
            yeniSinav.setDersId(dersId);
            yeniSinav.setOturumId(1); // Şimdilik 1 numaralı oturumu varsayılan olarak atıyoruz

            // Veritabanında nullable=false olduğu için mecburen bir tarih atıyoruz.
            // Şimdilik bugünden 7 gün sonrasını sınav tarihi olarak belirleyelim.
            yeniSinav.setTarih(LocalDate.now().plusDays(7));

            // Sınavı veritabanına kaydet ve SQL'in otomatik verdiği (Identity) ID'yi al
            Sinav kaydedilenSinav = sinavRepository.save(yeniSinav);
            Integer olusanSinavId = kaydedilenSinav.getSinavId();

            // ADIM 2: Stored Procedure'ü Çağır
            // Şimdi elimizde geçerli bir SınavID var, bunu T-SQL prosedürüne güvenle yolluyoruz
            sinavRepository.akilliSalonAta(olusanSinavId);

            return ResponseEntity.ok("Ders için Sınav (ID: " + olusanSinavId + ") oluşturuldu ve salon ataması yapıldı.");
        } catch (Exception e) {
            // Eğer SP içerisinde kapasite yetmezse ve THROW / ROLLBACK çalışırsa hata buraya düşer
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Atama başarısız oldu: " + e.getMessage());
        }
    }
    @GetMapping("/{id}/salonlar")
    public ResponseEntity<List<Map<String, Object>>> getAtananSalonlar(@PathVariable("id") Integer dersId) {
        try {
            List<Map<String, Object>> salonlar = sinavRepository.findAtananSalonlar(dersId);
            return ResponseEntity.ok(salonlar);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
    // Arayüzden çağrılacak "Yedek Al" API'si
    @PostMapping("/yedek-al")
    public ResponseEntity<String> yedekAl() {
        try {
            sinavRepository.veritabaniYedekle();
            return ResponseEntity.ok("Sistem yedeği C:\\Yedekler klasörüne başarıyla oluşturuldu.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Yedekleme başarısız: " + e.getMessage());
        }
    }
}