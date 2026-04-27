package org.abdullah.unislot.repository;

import org.abdullah.unislot.entity.Sinav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public interface SinavRepository extends JpaRepository<Sinav, Integer> {

    // T-SQL'de yazdığımız "sp_AkilliSalonAtama" prosedürünü nativeQuery ile tetikliyoruz
    @Modifying
    @Transactional
    @Query(value = "EXEC sp_AkilliSalonAtama :sinavId", nativeQuery = true)
    void akilliSalonAta(@Param("sinavId") Integer sinavId);
    @Query(value = "SELECT d.Ad as ad, d.Kapasite as kapasite " +
            "FROM Derslikler d " +
            "INNER JOIN Sinav_Salonlari ss ON d.DerslikID = ss.DerslikID " +
            "INNER JOIN Sinavlar s ON ss.SinavID = s.SinavID " +
            "WHERE s.DersID = :dersId", nativeQuery = true)
    List<Map<String, Object>> findAtananSalonlar(@Param("dersId") Integer dersId);

    // Veritabanı yedeğini alan Stored Procedure'ü ÇağırıYORUZZ
    @Modifying
    @Transactional
    @Query(value = "EXEC sp_VeritabaniYedekle", nativeQuery = true)
    void veritabaniYedekle();
}