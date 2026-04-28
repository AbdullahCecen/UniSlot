package org.abdullah.unislot.controller;

import org.abdullah.unislot.entity.PersonelDurum;
import org.abdullah.unislot.repository.PersonelDurumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/mazeretler")
public class PersonelDurumController {

    @Autowired
    private PersonelDurumRepository durumRepository;

    // Belirli bir personelin mazeretlerini getir
    @GetMapping("/personel/{id}")
    public List<PersonelDurum> getPersonelMazeretleri(@PathVariable("id") Integer personelId) {
        return durumRepository.findByPersonelID(personelId);
    }

    // Yeni mazeret ekle
    @PostMapping
    public ResponseEntity<?> mazeretEkle(@RequestBody PersonelDurum yeniDurum) {
        try {
            PersonelDurum kaydedilen = durumRepository.save(yeniDurum);
            return ResponseEntity.ok(kaydedilen);
        } catch (Exception e) {
            // SQL Server'daki Trigger hata fırlatırsa (Geçmiş tarih vb.) buraya düşer
            return ResponseEntity.badRequest().body("Mazeret eklenemedi: " + e.getMessage());
        }
    }

    // Mazeret Sil
    @DeleteMapping("/{id}")
    public ResponseEntity<?> mazeretSil(@PathVariable("id") Integer durumId) {
        durumRepository.deleteById(durumId);
        return ResponseEntity.ok("Mazeret başarıyla silindi.");
    }
}