package org.abdullah.unislot.service;

import org.abdullah.unislot.entity.Sinav;
import org.abdullah.unislot.repository.SinavRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class SinavService {

    @Autowired
    private SinavRepository sinavRepository;

    // --- SALON ATAMA ---
    @Transactional
    public void salonAtamasiYap(Integer sinavId) {
        sinavRepository.akilliSalonAta(sinavId);
    }

    public List<Map<String, Object>> atananSalonlariGetir(Integer sinavId) {
        return sinavRepository.findAtananSalonlar(sinavId);
    }

    // --- GÖZETMEN ATAMA ---
    @Transactional
    public void gozetmenAtamasiYap(Integer sinavId) {
        sinavRepository.akilliGozetmenAta(sinavId);
    }

    public List<Map<String, Object>> atananGozetmenleriGetir(Integer sinavId) {
        return sinavRepository.findAtananGozetmenler(sinavId);
    }

    public List<Map<String, Object>> gorevlerimiGetir(Integer personelId) {
        return sinavRepository.findGorevlerim(personelId);
    }

    // --- SINAV OLUŞTUR ---
    @Transactional
    public Sinav sinavOlustur(Sinav sinav) {
        return sinavRepository.saveAndFlush(sinav);
    }

    // --- SINAV SİL ---
    @Transactional
    public void sinavSil(Integer sinavId) {
        sinavRepository.deleteGozetmenAtamalariBySinavId(sinavId);
        sinavRepository.deleteSalonAtamalariBySinavId(sinavId);
        sinavRepository.deleteById(sinavId);
    }

    @Transactional
    public void sinavGuncelle(Integer sinavId, String yeniTarih, Integer yeniOturumId, String degistiren) {
        sinavRepository.sinavGuncelle(sinavId, yeniTarih, yeniOturumId, degistiren);
    }

    @Transactional
    public void topluSalonAtamaGenel() {
        sinavRepository.topluSalonAtamaGenel();
    }
}