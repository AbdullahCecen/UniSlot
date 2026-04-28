package org.abdullah.unislot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Personel_Durum")
public class PersonelDurum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DurumID")
    private Integer durumID;

    @Column(name = "PersonelID")
    private Integer personelID;

    @Column(name = "Tarih")
    private String tarih;

    @Column(name = "MazeretTuru")
    private String mazeretTuru;

    // --- EKSİK OLAN SÜTUNLAR EKLENDİ (Otomatik Tam Gün İzin) ---
    @Column(name = "BaslangicSaat")
    private String baslangicSaat = "08:00";

    @Column(name = "BitisSaat")
    private String bitisSaat = "23:59";

    // --- Getter ve Setter Metodları ---
    public Integer getDurumID() { return durumID; }
    public void setDurumID(Integer durumID) { this.durumID = durumID; }
    public Integer getPersonelID() { return personelID; }
    public void setPersonelID(Integer personelID) { this.personelID = personelID; }
    public String getTarih() { return tarih; }
    public void setTarih(String tarih) { this.tarih = tarih; }
    public String getMazeretTuru() { return mazeretTuru; }
    public void setMazeretTuru(String mazeretTuru) { this.mazeretTuru = mazeretTuru; }
    public String getBaslangicSaat() { return baslangicSaat; }
    public void setBaslangicSaat(String baslangicSaat) { this.baslangicSaat = baslangicSaat; }
    public String getBitisSaat() { return bitisSaat; }
    public void setBitisSaat(String bitisSaat) { this.bitisSaat = bitisSaat; }
}