package com.reportes.dao;

import java.util.List;

import com.reportes.dto.ColumnaQueryDto;

/**
 * QueryDao
 */
public interface QueryDao {

    List<ColumnaQueryDto> executarQuery(String query);

}
