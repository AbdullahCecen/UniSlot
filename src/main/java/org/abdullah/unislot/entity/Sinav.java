package org.abdullah.unislot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "Sinavlar")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Sinav {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SinavID")
    private Integer sinavId;

    @Column(name = "DersID", nullable = false)
    private Integer dersId;

    @Column(name = "Tarih", nullable = false)
    private LocalDate tarih;

    @Column(name = "OturumID", nullable = false)
    private Integer oturumId;
}