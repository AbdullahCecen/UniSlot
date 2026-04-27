package org.abdullah.unislot.repository;

import org.abdullah.unislot.entity.Personel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonelRepository extends JpaRepository<Personel, Integer> {
}