package com.v6team.amw.springbatch.service;

import java.sql.Connection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.v6team.amw.springbatch.dao.StockDao;
import com.v6team.amw.springbatch.model.StockData;
import com.v6team.amw.springbatch.utility.ConnectionUtil;

@Service
public class StockService{
	@Autowired
	StockDao stockDao;
	public void save(List<? extends StockData> stocks) {
		try (Connection conn = ConnectionUtil.getConnection();){
			stockDao.save(conn, stocks);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
