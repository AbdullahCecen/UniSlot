package org.abdullah.unislot.controller;

import org.abdullah.unislot.entity.Ders;
import org.abdullah.unislot.repository.DersRepository;
import org.abdullah.unislot.repository.SinavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/dersler")
public class DersController {

    @Autowired
    private DersRepository dersRepository;

    @Autowired
    private SinavRepository sinavRepository;

    @GetMapping
    public List<Ders> getAllDersler() {
        return dersRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Ders> dersEkle(@RequestBody Ders yeniDers) {
        Ders kaydedilenDers = dersRepository.save(yeniDers);
        return ResponseEntity.ok(kaydedilenDers);
    }

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
    @DeleteMapping("/{id}")
    public ResponseEntity<String> dersSil(@PathVariable Integer id) {
        try {
            dersRepository.deleteById(id);
            return ResponseEntity.ok("Ders başarıyla silindi.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bu ders sınavlarda kullanıldığı için silinemez.");
        }
    }
}