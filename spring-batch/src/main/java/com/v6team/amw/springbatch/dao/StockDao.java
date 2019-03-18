package com.v6team.amw.springbatch.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.v6team.amw.springbatch.model.StockData;

@Repository
public class StockDao {
	private static Integer count = 1;
	private static String SQL_SELECT_STOCK = "INSERT INTO STOCK(ID,CODE,NAME,QTY,PRICE) VALUES(?,?,?,?,?)";

	public void save(Connection conn, List<? extends StockData> stocks) throws SQLException {
		PreparedStatement stmt = conn.prepareStatement(SQL_SELECT_STOCK);
		System.out.println(count++);
		for (StockData stock : stocks) {
			stmt.setInt(1, stock.getId());
			stmt.setString(2, stock.getCode());
			stmt.setString(3, stock.getName());
			stmt.setInt(4, stock.getQty());
			stmt.setDouble(5, stock.getPrice());
			
			stmt.addBatch();
		}
		
		stmt.executeBatch();
	}
}
