package com.reportes.controller;

import java.util.List;

import com.reportes.dto.ColumnaQueryDto;
import com.reportes.dto.QueryDto;
import com.reportes.service.ReporteService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * ReporteController
 */
@Controller
@Slf4j
public class ReporteController {

    private ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @GetMapping("/reportes/nuevo")
    public String nuevo() {
        return "formQuery";
    }

    @PostMapping("/reportes/nuevos")
    public String crearQuery(QueryDto queryDto) {
        log.info("Creando nuevo reporte {}", queryDto);
        List<ColumnaQueryDto> lista =  reporteService.crearQuery(queryDto);
        log.info("obteniendo lista de columnas: {}", lista);
        return "formQuery";
    }

}
