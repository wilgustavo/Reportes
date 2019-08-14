package com.reportes.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.Data;

/**
 * ColumnaID
 */
@Data
@Embeddable
public class ColumnaID implements Serializable{

    private static final long serialVersionUID = -5569873240075370153L;

    Integer reporte;
    Integer numero;

}
