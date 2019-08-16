package com.reportes.dto;

import java.util.ArrayList;
import java.util.List;

import com.reportes.model.Columna;

import lombok.Data;

/**
 * ListaColumnasDto
 */
@Data
public class ListaColumnasDto {

    private List<Columna> columnas;

    public ListaColumnasDto() {
        this.columnas = new ArrayList<>();
    }

    public void addColumna(Columna columna) {
        this.columnas.add(columna);
    }

}
