package org.abdullah.unislot.controller;

import org.abdullah.unislot.entity.Oturum;
import org.abdullah.unislot.repository.OturumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/oturumlar")
public class OturumController {

    @Autowired
    private OturumRepository oturumRepository;

    @GetMapping
    public List<Oturum> getAllOturumlar() {
        return oturumRepository.findAll();
    }
    @PostMapping
    public ResponseEntity<Oturum> oturumEkle(@RequestBody Oturum oturum) {
        Oturum kaydedilen = oturumRepository.save(oturum);
        return ResponseEntity.ok(kaydedilen);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> oturumSil(@PathVariable Integer id) {
        try {
            oturumRepository.deleteById(id);
            return ResponseEntity.ok("Oturum silindi.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bu oturum sınavlarda kullanıldığı için silinemez.");
        }
    }
}