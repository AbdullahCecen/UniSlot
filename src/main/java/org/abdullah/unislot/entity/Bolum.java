package org.abdullah.unislot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Bolumler")
public class Bolum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BolumID") // SQL'deki sütun adıyla birebir eşleşir
    private Integer bolumID;

    @Column(name = "BolumAd") // SQL'deki sütun adıyla birebir eşleşir
    private String bolumAd;

    // Getter ve Setter Metodları
    public Integer getBolumID() {
        return bolumID;
    }

    public void setBolumID(Integer bolumID) {
        this.bolumID = bolumID;
    }

    public String getBolumAd() {
        return bolumAd;
    }

    public void setBolumAd(String bolumAd) {
        this.bolumAd = bolumAd;
    }
}