package org.abdullah.unislot.entity;

import jakarta.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "Oturumlar")
public class Oturum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "OturumID")
    private Integer oturumId;

    @Column(name = "Tanim")
    private String tanim;

    @Column(name = "BaslangicSaat")
    private LocalTime baslangicSaat;

    @Column(name = "BitisSaat")
    private LocalTime bitisSaat;

    public Integer getOturumId() {
        return oturumId;
    }

    public void setOturumId(Integer oturumId) {
        this.oturumId = oturumId;
    }

    public String getTanim() {
        return tanim;
    }

    public void setTanim(String tanim) {
        this.tanim = tanim;
    }

    public LocalTime getBaslangicSaat() {
        return baslangicSaat;
    }

    public void setBaslangicSaat(LocalTime baslangicSaat) {
        this.baslangicSaat = baslangicSaat;
    }

    public LocalTime getBitisSaat() {
        return bitisSaat;
    }

    public void setBitisSaat(LocalTime bitisSaat) {
        this.bitisSaat = bitisSaat;
    }
}