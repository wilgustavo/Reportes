package com.reportes.dao;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

import java.util.List;
import java.util.stream.Collectors;

import com.reportes.model.Reporte;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * ReporteIntegrationTest
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ReporteRepositoryIntegrationTest {

    @Autowired
    private ReporteRepository reporteRepository;

    @Test
    @Sql({"/sql/reportes.sql"})
    public void deberia_consultar_un_reporte() {
        Reporte reporte = reporteRepository.findById(1).get();
        assertThat(reporte.getNombre(), is("contactos"));
        assertThat(reporte.getSql(), is("select * from contactos"));
        assertThat(reporte.getColumnas(), hasSize(2));
        assertThat(getNombres(reporte), contains("nombre", "apellido"));
    }

    private List<String> getNombres(Reporte reporte) {
        List<String> columnas = reporte.getColumnas().stream().map(columa -> columa.getNombre()).collect(Collectors.toList());
        return columnas;
    }
}
