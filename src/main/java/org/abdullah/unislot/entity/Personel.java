package org.abdullah.unislot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Personel")
public class Personel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PersonelID")
    private Integer personelID;

    @Column(name = "Ad")
    private String ad;

    @Column(name = "Soyad")
    private String soyad;

    @Column(name = "Unvan")
    private String unvan;

    @Column(name = "BolumID")
    private Integer bolumID;

    // Getter ve Setter Metodları
    public Integer getPersonelID() { return personelID; }
    public void setPersonelID(Integer personelID) { this.personelID = personelID; }
    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }
    public String getSoyad() { return soyad; }
    public void setSoyad(String soyad) { this.soyad = soyad; }
    public String getUnvan() { return unvan; }
    public void setUnvan(String unvan) { this.unvan = unvan; }
    public Integer getBolumID() { return bolumID; }
    public void setBolumID(Integer bolumID) { this.bolumID = bolumID; }
}