package org.abdullah.unislot.controller;

import org.abdullah.unislot.entity.Bolum;
import org.abdullah.unislot.repository.BolumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/bolumler")
public class BolumController {

    @Autowired
    private BolumRepository bolumRepository;

    // 1. Bölümleri Listele
    @GetMapping
    public List<Bolum> getAllBolumler() {
        return bolumRepository.findAll();
    }

    // 2. Yeni Bölüm Ekle
    @PostMapping
    public ResponseEntity<Bolum> bolumEkle(@RequestBody Bolum yeniBolum) {
        Bolum kaydedilen = bolumRepository.save(yeniBolum);
        return ResponseEntity.ok(kaydedilen);
    }

    // 3. Bölüm Sil
    @DeleteMapping("/{id}")
    public ResponseEntity<String> bolumSil(@PathVariable("id") Integer bolumId) {
        try {
            bolumRepository.deleteById(bolumId);
            return ResponseEntity.ok("Bölüm başarıyla silindi.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bu bölüme ait dersler olduğu için silinemez!");
        }
    }
}