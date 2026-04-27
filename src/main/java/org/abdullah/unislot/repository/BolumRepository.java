package org.abdullah.unislot.repository;

import org.abdullah.unislot.entity.Bolum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BolumRepository extends JpaRepository<Bolum, Integer> {
}