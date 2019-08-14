package com.reportes.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import lombok.Data;

/**
 * Columna
 */
@Data
@Entity
public class Columna {

    @EmbeddedId
    ColumnaID columnaID;

    @ManyToOne
    @MapsId("reporte")
    Reporte reporte;

    String nombre;
    String tipo;
    String formato;

}
