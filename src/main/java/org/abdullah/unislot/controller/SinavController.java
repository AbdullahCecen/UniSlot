package org.abdullah.unislot.controller;

import org.abdullah.unislot.service.SinavService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sinavlar")
public class SinavController {

    @Autowired
    private SinavService sinavService;

    // Vue.js'den POST isteği geldiğinde bu metod çalışacak
    @PostMapping("/{sinavId}/salon-ata")
    public ResponseEntity<String> akilliSalonAta(@PathVariable Integer sinavId) {
        try {
            sinavService.salonAtamasiYap(sinavId);
            return ResponseEntity.ok("Sınav ID: " + sinavId + " için akıllı salon ataması başarıyla tamamlandı.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Atama sırasında hata oluştu: " + e.getMessage());
        }
    }
}