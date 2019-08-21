package com.reportes.service;

import java.util.List;

import com.reportes.dao.QueryDao;
import com.reportes.dto.ColumnaQueryDto;
import com.reportes.dto.QueryDto;

import org.springframework.stereotype.Service;

/**
 * ReporteServiceImpl
 */
@Service
public class ReporteServiceImpl implements ReporteService {

    private QueryDao queryDao;

    public ReporteServiceImpl(QueryDao queryDao) {
        this.queryDao = queryDao;
    }

	@Override
	public List<ColumnaQueryDto> crearQuery(QueryDto query) {
        return queryDao.executarQuery(query.getSql());
	}


}
