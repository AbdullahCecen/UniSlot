package org.abdullah.unislot.controller;

import org.abdullah.unislot.entity.Personel;
import org.abdullah.unislot.repository.PersonelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/personeller")
public class PersonelController {

    @Autowired
    private PersonelRepository personelRepository;

    @GetMapping
    public List<Personel> getAllPersoneller() {
        return personelRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Personel> personelEkle(@RequestBody Personel yeniPersonel) {
        Personel kaydedilen = personelRepository.save(yeniPersonel);
        return ResponseEntity.ok(kaydedilen);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> personelSil(@PathVariable("id") Integer personelId) {
        try {
            personelRepository.deleteById(personelId);
            return ResponseEntity.ok("Personel başarıyla silindi.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bu personel bir sınavda görevli olduğu için silinemez!");
        }
    }
}