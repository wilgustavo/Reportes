package com.reportes.controller;

import com.reportes.dao.ConsultaDao;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ConsultaController
 */
@Controller
public class ConsultaController {

    private ConsultaDao consultaDao;

    public ConsultaController(ConsultaDao consultaDao) {
        this.consultaDao = consultaDao;
    }

    @GetMapping("consulta")
    public String consultar(Model model) {
        model.addAttribute("lista", consultaDao.consultar());
        return "consulta";
    }



}
