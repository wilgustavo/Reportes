package com.reportes.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Columna
 */
@Data
@Entity
@AllArgsConstructor @NoArgsConstructor
public class Columna {

    @EmbeddedId
    ColumnaID columnaID;

    @ManyToOne
    @JoinColumn(name = "reporte")
    @MapsId("reporte")
    Reporte reporte;

    String nombre;
    String tipo;
    String formato;

}
