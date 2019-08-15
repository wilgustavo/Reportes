package com.reportes.dao;

import static org.junit.Assert.assertThat;

import com.reportes.model.Reporte;

import static org.hamcrest.CoreMatchers.*;
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
    }
}
