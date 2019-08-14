package com.reportes.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * Reporte
 */
@Data
@Entity
public class Reporte {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String descripcion;

    @Lob @Column(length = 5000)
    private String sql;

    @OneToMany
    Collection<Columna> columnas;

}
