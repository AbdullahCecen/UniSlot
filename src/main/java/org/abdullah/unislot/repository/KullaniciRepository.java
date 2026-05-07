package org.abdullah.unislot.repository;

import org.abdullah.unislot.entity.Kullanici;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KullaniciRepository extends JpaRepository<Kullanici, Integer> {

    Optional<Kullanici> findByEmailAndSifre(String email, String sifre);

}