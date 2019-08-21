package com.reportes.dao;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.reportes.dto.ColumnaQueryDto;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * QueryDaoImpl
 */
@Repository
public class QueryDaoImpl implements QueryDao {

    private JdbcTemplate jdbcTemplate;

    public QueryDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<ColumnaQueryDto> executarQuery(String query) {
        return jdbcTemplate.query(query, (ResultSet rs) -> consultarMetaData(rs.getMetaData()));
    }

    private List<ColumnaQueryDto> consultarMetaData(ResultSetMetaData metaData) throws SQLException {
        return IntStream.range(1, metaData.getColumnCount())
            .mapToObj(index -> consultarColumna(metaData, index))
            .collect(Collectors.toList());
    }

    private ColumnaQueryDto consultarColumna(ResultSetMetaData metaData, Integer index) {
        try {
            return new ColumnaQueryDto(metaData.getColumnName(index), metaData.getColumnTypeName(index));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage(), e.getCause());
        }
    }
}
