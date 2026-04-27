package org.abdullah.unislot.repository;

import org.abdullah.unislot.entity.Ders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DersRepository extends JpaRepository<Ders, Integer> {
    // Spring Data JPA, temel CRUD (Ekle, Sil, Güncelle, Listele) işlemlerini otomatik halledecek.
    // İleride özel sorgular gerekirse buraya ekleyeceğiz.
}