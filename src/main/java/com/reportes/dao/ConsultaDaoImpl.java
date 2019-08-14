package com.reportes.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.extern.slf4j.Slf4j;

/**
 * ConsultaDaoImpl
 */
@Slf4j
@Repository
public class ConsultaDaoImpl implements ConsultaDao {

    private JdbcTemplate jdbcTemplate;
    private static final String SQL = "select apellido, nombre, 12, CURRENT_DATE as fecha from contacto";

    public ConsultaDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<String> consultar() {

        return jdbcTemplate.query(SQL, (ResultSet rs) -> {
            chusmearMetadata(rs);
            return crearStram(rs).collect(Collectors.toList());
        });

    }

    private Stream<String> crearStram(ResultSet rs) {
        Stream.Builder<String> builder = Stream.builder();
        try {
            while (rs.next()) {
                builder.add(rs.getString("apellido"));
            }
        } catch (SQLException ex) {
            log.error("Error en la lectura del Result Set", ex);
            throw new RuntimeException(ex.getMessage(), ex);
		}
        return builder.build();
    }

    private void chusmearMetadata(ResultSet rs) {
        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int cantColumnas = metaData.getColumnCount();
            log.info("Cantidad de columnas: {}", cantColumnas);

            IntStream.range(1, cantColumnas + 1).forEach(column -> {
                chusmearColumnas(column, metaData);
            });

        } catch (SQLException ex) {
            log.error("Error en la lectura del Result Set", ex);
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

    private void chusmearColumnas(int columna, ResultSetMetaData metaData) {
        try {
            log.info("Nombre: {}, Tipo: {}", metaData.getColumnName(columna) , metaData.getColumnTypeName(columna));
        } catch (SQLException ex) {
            log.error("Error en la lectura de la Metadata", ex);
            throw new RuntimeException(ex.getMessage(), ex);
        }
    }

}
