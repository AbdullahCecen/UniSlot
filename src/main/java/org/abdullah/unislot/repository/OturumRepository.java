package org.abdullah.unislot.repository;

import org.abdullah.unislot.entity.Oturum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OturumRepository extends JpaRepository<Oturum, Integer> {
}