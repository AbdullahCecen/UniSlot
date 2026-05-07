package org.abdullah.unislot.repository;

import jakarta.transaction.Transactional;
import org.abdullah.unislot.entity.Sinav;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface SinavRepository extends JpaRepository<Sinav, Integer> {

    @Modifying
    @Query(value = "EXEC sp_AkilliSalonAtama :sinavId", nativeQuery = true)
    void akilliSalonAta(@Param("sinavId") Integer sinavId);

    @Query(value = """
            SELECT 
                d.Ad AS ad,
                d.Tip AS tip,
                d.Kat AS kat,
                d.Kapasite AS kapasite
            FROM Derslikler d
            INNER JOIN Sinav_Salonlari ss ON d.DerslikID = ss.DerslikID
            WHERE ss.SinavID = :sinavId
            ORDER BY d.Kat, d.Kapasite DESC
            """, nativeQuery = true)
    List<Map<String, Object>> findAtananSalonlar(@Param("sinavId") Integer sinavId);

    @Modifying
    @Query(value = "EXEC sp_AkilliGozetmenAtama :sinavId", nativeQuery = true)
    void akilliGozetmenAta(@Param("sinavId") Integer sinavId);

    @Query(value = """
            SELECT
                ga.AtamaID AS atamaId,
                ss.SinavSalonID AS sinavSalonId,
                d.Ad AS salonAdi,
                p.Unvan AS unvan,
                p.Ad AS ad,
                p.Soyad AS soyad
            FROM Gozetmen_Atamalari ga
            INNER JOIN Sinav_Salonlari ss ON ga.SinavSalonID = ss.SinavSalonID
            INNER JOIN Derslikler d ON ss.DerslikID = d.DerslikID
            INNER JOIN Personel p ON ga.PersonelID = p.PersonelID
            WHERE ss.SinavID = :sinavId
            ORDER BY d.Ad, p.Soyad, p.Ad
            """, nativeQuery = true)
    List<Map<String, Object>> findAtananGozetmenler(@Param("sinavId") Integer sinavId);

    @Transactional
    @Modifying
    @Query(value = "EXEC sp_VeritabaniYedekle", nativeQuery = true)
    void veritabaniYedekle();
    @Query(value = """
        SELECT
            s.SinavID AS sinavId,
            s.Tarih AS tarih,
            CONVERT(VARCHAR(5), o.BaslangicSaat, 108) + ' - ' + CONVERT(VARCHAR(5), o.BitisSaat, 108) AS saat,
            d.DersKodu AS dersKodu,
            d.Ad AS dersAdi,
            b.BolumAd AS bolumAd,
            derslik.Ad AS salonAdi
        FROM Gozetmen_Atamalari ga
        INNER JOIN Sinav_Salonlari ss ON ga.SinavSalonID = ss.SinavSalonID
        INNER JOIN Sinavlar s ON ss.SinavID = s.SinavID
        INNER JOIN Dersler d ON s.DersID = d.DersID
        INNER JOIN Bolumler b ON d.BolumID = b.BolumID
        INNER JOIN Oturumlar o ON s.OturumID = o.OturumID
        INNER JOIN Derslikler derslik ON ss.DerslikID = derslik.DerslikID
        WHERE ga.PersonelID = :personelId
        ORDER BY s.Tarih, o.BaslangicSaat
        """, nativeQuery = true)
    List<Map<String, Object>> findGorevlerim(@Param("personelId") Integer personelId);


    @Modifying
    @Query(value = """
    DELETE ga
    FROM Gozetmen_Atamalari ga
    INNER JOIN Sinav_Salonlari ss ON ga.SinavSalonID = ss.SinavSalonID
    WHERE ss.SinavID = :sinavId
""", nativeQuery = true)
    void deleteGozetmenAtamalariBySinavId(@Param("sinavId") Integer sinavId);

    @Modifying
    @Query(value = """
    DELETE FROM Sinav_Salonlari
    WHERE SinavID = :sinavId
""", nativeQuery = true)
    void deleteSalonAtamalariBySinavId(@Param("sinavId") Integer sinavId);

    @Modifying
    @Query(value = "EXEC dbo.sp_SinavGuncelle :sinavId, :yeniTarih, :yeniOturumId, :degistiren", nativeQuery = true)
    void sinavGuncelle(
            @Param("sinavId") Integer sinavId,
            @Param("yeniTarih") String yeniTarih,
            @Param("yeniOturumId") Integer yeniOturumId,
            @Param("degistiren") String degistiren
    );
}