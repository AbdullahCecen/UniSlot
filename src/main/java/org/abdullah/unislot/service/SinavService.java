package org.abdullah.unislot.service;

import org.abdullah.unislot.repository.SinavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SinavService {

    @Autowired
    private SinavRepository sinavRepository;

    @Transactional // İşlem sırasında hata olursa Spring Boot otomatik Rollback yapar
    public void salonAtamasiYap(Integer sinavId) {
        sinavRepository.akilliSalonAta(sinavId);
    }
}