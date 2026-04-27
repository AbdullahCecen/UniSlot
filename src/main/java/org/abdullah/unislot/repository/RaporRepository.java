package org.abdullah.unislot.repository;

import org.abdullah.unislot.entity.SinavProgramiRapor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaporRepository extends JpaRepository<SinavProgramiRapor, Integer> {
}