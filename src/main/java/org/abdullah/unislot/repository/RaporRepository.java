package org.abdullah.unislot.repository;

import org.abdullah.unislot.entity.SinavProgramiRapor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RaporRepository extends JpaRepository<SinavProgramiRapor, Integer> {
    @Query(value = """
    SELECT
        derslik.Ad AS salonAdi,
        o.Tanim AS oturum,
        s.Tarih AS tarih,
        d.DersKodu AS dersKodu,
        d.Ad AS dersAdi,
        p.Ad + ' ' + p.Soyad AS gozetmen
    FROM Sinav_Salonlari ss
    INNER JOIN Derslikler derslik ON ss.DerslikID = derslik.DerslikID
    INNER JOIN Sinavlar s ON ss.SinavID = s.SinavID
    INNER JOIN Dersler d ON s.DersID = d.DersID
    INNER JOIN Oturumlar o ON s.OturumID = o.OturumID
    LEFT JOIN Gozetmen_Atamalari ga ON ss.SinavSalonID = ga.SinavSalonID
    LEFT JOIN Personel p ON ga.PersonelID = p.PersonelID
    ORDER BY derslik.Ad, s.Tarih, o.BaslangicSaat
""", nativeQuery = true)
    List<Map<String, Object>> getSinavProgrami();
}