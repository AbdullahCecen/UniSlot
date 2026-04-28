package org.abdullah.unislot.repository;

import org.abdullah.unislot.entity.PersonelDurum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonelDurumRepository extends JpaRepository<PersonelDurum, Integer> {
    // Belirli bir personelin mazeretlerini getirmek için özel metod
    List<PersonelDurum> findByPersonelID(Integer personelID);
}