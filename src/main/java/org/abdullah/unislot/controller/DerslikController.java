package org.abdullah.unislot.controller;

import org.abdullah.unislot.entity.Derslik;
import org.abdullah.unislot.repository.DerslikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/derslikler")
public class DerslikController {

    @Autowired
    private DerslikRepository derslikRepository;

    @GetMapping
    public List<Derslik> getAllDerslikler() {
        return derslikRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Derslik> derslikEkle(@RequestBody Derslik yeniDerslik) {
        Derslik kaydedilen = derslikRepository.save(yeniDerslik);
        return ResponseEntity.ok(kaydedilen);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> derslikSil(@PathVariable("id") Integer derslikId) {
        try {
            derslikRepository.deleteById(derslikId);
            return ResponseEntity.ok("Derslik silindi.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bu salon bir sınava atandığı için silinemez!");
        }
    }
}