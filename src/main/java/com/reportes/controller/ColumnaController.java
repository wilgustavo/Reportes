package com.reportes.controller;

import com.reportes.dto.ListaColumnasDto;
import com.reportes.model.Columna;
import com.reportes.model.ColumnaID;
import com.reportes.model.Reporte;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


/**
 * ColumnaController
 */
@Controller
@RequestMapping("/columnas")
@Slf4j
public class ColumnaController {

    @GetMapping("/create")
    public String columnasForm(Model model) {
        ListaColumnasDto columnas = new ListaColumnasDto();
        columnas.addColumna(new Columna(new ColumnaID(), new Reporte(), "Nombre 1", "Tipo 1", "Formato 1"));
        columnas.addColumna(new Columna(new ColumnaID(), new Reporte(), "Nombre 2", "Tipo 2", "Formato 2"));
        columnas.addColumna(new Columna(new ColumnaID(), new Reporte(), "Nombre 3", "Tipo 3", "Formato 3"));
        model.addAttribute("form", columnas);
        return "columnasForm";
    }

    @PostMapping("/save")
    public String guardarColumnas(@ModelAttribute ListaColumnasDto columnas) {
        log.info("guardar las columas: {}", columnas);
        return "redirect:/columnas/create";
    }

}
