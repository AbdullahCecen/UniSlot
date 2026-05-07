package org.abdullah.unislot.service;

import org.abdullah.unislot.dto.LoginResponse;
import org.abdullah.unislot.entity.Kullanici;
import org.abdullah.unislot.repository.KullaniciRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private KullaniciRepository kullaniciRepository;

    public LoginResponse login(String email, String password) {

        Kullanici user = kullaniciRepository
                .findByEmailAndSifre(email, password)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı"));

        return new LoginResponse(user.getRol(), user.getPersonelId());
    }
}