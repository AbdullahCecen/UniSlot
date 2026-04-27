package org.abdullah.unislot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Derslikler")
public class Derslik {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DerslikID")
    private Integer derslikID;

    @Column(name = "Ad")
    private String ad;

    // EKSİK OLAN 1. SÜTUN
    @Column(name = "Tip")
    private String tip;

    @Column(name = "Kapasite")
    private Integer kapasite;

    // EKSİK OLAN 2. SÜTUN (Varsayılan olarak 1 yani Aktif veriyoruz)
    @Column(name = "Aktif")
    private Integer aktif = 1;

    // Getter ve Setter Metodları
    public Integer getDerslikID() { return derslikID; }
    public void setDerslikID(Integer derslikID) { this.derslikID = derslikID; }
    public String getAd() { return ad; }
    public void setAd(String ad) { this.ad = ad; }
    public String getTip() { return tip; }
    public void setTip(String tip) { this.tip = tip; }
    public Integer getKapasite() { return kapasite; }
    public void setKapasite(Integer kapasite) { this.kapasite = kapasite; }
    public Integer getAktif() { return aktif; }
    public void setAktif(Integer aktif) { this.aktif = aktif; }
}