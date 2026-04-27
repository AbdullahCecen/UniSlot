package org.abdullah.unislot.repository;

import org.abdullah.unislot.entity.Derslik;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DerslikRepository extends JpaRepository<Derslik, Integer> {
}