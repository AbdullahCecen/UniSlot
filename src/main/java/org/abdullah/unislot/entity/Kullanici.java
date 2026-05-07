package org.abdullah.unislot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "Kullanicilar")
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer kullaniciID;

    private String email;
    private String sifre;
    private String rol;

    @Column(name = "PersonelID")
    private Integer personelId;

    public Kullanici(Integer kullaniciID, String email, String sifre, String rol, Integer personelId) {
        this.kullaniciID = kullaniciID;
        this.email = email;
        this.sifre = sifre;
        this.rol = rol;
        this.personelId = personelId;
    }

    public Integer getKullaniciID() {
        return kullaniciID;
    }

    public void setKullaniciID(Integer kullaniciID) {
        this.kullaniciID = kullaniciID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSifre() {
        return sifre;
    }

    public void setSifre(String sifre) {
        this.sifre = sifre;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Integer getPersonelId() {
        return personelId;
    }

    public void setPersonelId(Integer personelId) {
        this.personelId = personelId;
    }

    public Kullanici() {
    }
// getters setters
}