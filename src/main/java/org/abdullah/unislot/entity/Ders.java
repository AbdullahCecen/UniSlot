package org.abdullah.unislot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "Dersler") // SQL Server'daki tablomuzun tam adı
@Data // Lombok: Getter, Setter, toString metodlarını otomatik oluşturuyorum Burada
@NoArgsConstructor
@AllArgsConstructor
public class Ders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DersID")
    private Integer dersId;

    @Column(name = "BolumID", nullable = false)
    private Integer bolumId;

    @Column(name = "DersKodu", nullable = false, length = 20, unique = true)
    private String dersKodu;

    @Column(name = "Ad", nullable = false, length = 100)
    private String ad;

    @Column(name = "DersTuru", nullable = false, length = 20)
    private String dersTuru;

    @Column(name = "OgrenciSayisi", nullable = false)
    private Integer ogrenciSayisi;

    @Column(name = "Yariyil", nullable = false)
    private Integer yariyil;
}