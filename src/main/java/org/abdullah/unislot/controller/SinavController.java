package org.abdullah.unislot.controller;

import org.abdullah.unislot.entity.Sinav;
import org.abdullah.unislot.service.SinavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/sinavlar")
@CrossOrigin(origins = "http://localhost:5173")
public class SinavController {

    @Autowired
    private SinavService sinavService;

    @PostMapping("/{sinavId}/salon-ata")
    public ResponseEntity<Map<String, Object>> akilliSalonAta(@PathVariable Integer sinavId) {
        sinavService.salonAtamasiYap(sinavId);

        Map<String, Object> response = new HashMap<>();
        response.put("success", true);
        response.put("message", "Sınav ID: " + sinavId + " için akıllı salon ataması başarıyla tamamlandı.");

        return ResponseEntity.ok(response);
    }

    @GetMapping("/{sinavId}/salonlar")
    public ResponseEntity<?> getAtananSalonlar(@PathVariable Integer sinavId) {
        return ResponseEntity.ok(sinavService.atananSalonlariGetir(sinavId));
    }

    @PostMapping("/{sinavId}/gozetmen-ata")
    public ResponseEntity<String> akilliGozetmenAta(@PathVariable Integer sinavId) {
        sinavService.gozetmenAtamasiYap(sinavId);
        return ResponseEntity.ok("Gözetmen ataması başarıyla tamamlandı.");
    }

    @GetMapping("/{sinavId}/gozetmenler")
    public ResponseEntity<?> getAtananGozetmenler(@PathVariable Integer sinavId) {
        return ResponseEntity.ok(sinavService.atananGozetmenleriGetir(sinavId));
    }

    @GetMapping("/personel/{personelId}/gorevler")
    public ResponseEntity<?> getPersonelGorevleri(@PathVariable Integer personelId) {
        return ResponseEntity.ok(sinavService.gorevlerimiGetir(personelId));
    }

    @PostMapping
    public ResponseEntity<?> sinavOlustur(@RequestBody Map<String, Object> payload) {
        Object dersObj = payload.get("dersId");
        Object oturumObj = payload.get("oturumId");
        Object tarihObj = payload.get("tarih");

        if (dersObj == null || oturumObj == null || tarihObj == null) {
            throw new IllegalArgumentException("Ders, tarih ve oturum bilgileri zorunludur.");
        }

        Integer dersId = ((Number) dersObj).intValue();
        Integer oturumId = ((Number) oturumObj).intValue();
        String tarihStr = tarihObj.toString();

        Sinav sinav = new Sinav();
        sinav.setDersId(dersId);
        sinav.setOturumId(oturumId);
        sinav.setTarih(java.time.LocalDate.parse(tarihStr));

        Sinav kaydedilen = sinavService.sinavOlustur(sinav);

        return ResponseEntity.ok(kaydedilen);
    }

    @DeleteMapping("/{sinavId}")
    public ResponseEntity<?> sinavSil(@PathVariable Integer sinavId) {
        sinavService.sinavSil(sinavId);
        return ResponseEntity.ok("Sınav başarıyla silindi.");
    }
    @PutMapping("/{sinavId}")
    public ResponseEntity<?> sinavGuncelle(
            @PathVariable Integer sinavId,
            @RequestBody Map<String, Object> payload
    ) {
        Object tarihObj = payload.get("tarih");
        Object oturumObj = payload.get("oturumId");

        if (tarihObj == null || oturumObj == null) {
            return ResponseEntity.badRequest().body("Yeni tarih ve oturum bilgisi zorunludur.");
        }

        String yeniTarih = tarihObj.toString();
        Integer yeniOturumId = ((Number) oturumObj).intValue();

        sinavService.sinavGuncelle(
                sinavId,
                yeniTarih,
                yeniOturumId,
                "Admin"
        );

        return ResponseEntity.ok("Sınav başarıyla güncellendi.");
    }

    @PostMapping("/toplu-salon-ata")
    public ResponseEntity<String> topluSalonAta() {
        try {
            sinavService.topluSalonAtamaGenel();
            return ResponseEntity.ok("Tüm sınavlar için optimize edilmiş toplu salon ataması başarıyla tamamlandı.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Toplu atama başarısız: " + e.getMessage());
        }
    }

}