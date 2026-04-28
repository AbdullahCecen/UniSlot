package org.abdullah.unislot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vw_GenelSinavProgrami")
public class SinavProgramiRapor {

    @Id
    @Column(name = "SinavID")
    private Integer sinavID;

    @Column(name = "DersKodu")
    private String dersKodu;

    @Column(name = "DersAdi")
    private String dersAdi;

    @Column(name = "BolumAd")
    private String bolumAd;

    // --- İŞTE YENİ EKLENEN SÜTUN ---
    @Column(name = "Yariyil")
    private Integer yariyil;

    @Column(name = "Tarih")
    private String tarih;

    @Column(name = "Saat")
    private String saat;

    @Column(name = "AyrilanKapasite")
    private Integer ayrilanKapasite;

    // --- Getter ve Setter Metodları ---
    public Integer getSinavID() { return sinavID; }
    public void setSinavID(Integer sinavID) { this.sinavID = sinavID; }
    public String getDersKodu() { return dersKodu; }
    public void setDersKodu(String dersKodu) { this.dersKodu = dersKodu; }
    public String getDersAdi() { return dersAdi; }
    public void setDersAdi(String dersAdi) { this.dersAdi = dersAdi; }
    public String getBolumAd() { return bolumAd; }
    public void setBolumAd(String bolumAd) { this.bolumAd = bolumAd; }
    public Integer getYariyil() { return yariyil; }
    public void setYariyil(Integer yariyil) { this.yariyil = yariyil; }
    public String getTarih() { return tarih; }
    public void setTarih(String tarih) { this.tarih = tarih; }
    public String getSaat() { return saat; }
    public void setSaat(String saat) { this.saat = saat; }
    public Integer getAyrilanKapasite() { return ayrilanKapasite; }
    public void setAyrilanKapasite(Integer ayrilanKapasite) { this.ayrilanKapasite = ayrilanKapasite; }
}