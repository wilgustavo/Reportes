package com.reportes.service;

import java.util.List;

import com.reportes.dto.ColumnaQueryDto;
import com.reportes.dto.QueryDto;

/**
 * ReporteService
 */
public interface ReporteService {

    List<ColumnaQueryDto> crearQuery(QueryDto query);

}
