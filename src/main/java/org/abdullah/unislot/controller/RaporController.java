package org.abdullah.unislot.controller;

import org.abdullah.unislot.entity.SinavProgramiRapor;
import org.abdullah.unislot.repository.RaporRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/raporlar")
public class RaporController {

    @Autowired
    private RaporRepository raporRepository;

    @GetMapping("/sinav-programi")
    public List<SinavProgramiRapor> getGenelSinavProgrami() {
        // SQL View'ini çalıştırıp JSON olarak Frontend'e gönderir
        return raporRepository.findAll();
    }
}