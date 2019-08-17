package com.reportes.controller;

import com.reportes.dto.QueryDto;
import com.reportes.model.Reporte;

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

    @GetMapping("/reportes/nuevo")
    public String nuevo() {
        return "formQuery";
    }

    @PostMapping("/reportes/nuevos")
    public String crearQuery(QueryDto queryDto) {
        log.info("Creando nuevo reporte {}", queryDto);
        return "formQuery";
    }

}
