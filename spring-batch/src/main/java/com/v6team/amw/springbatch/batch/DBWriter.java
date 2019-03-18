package com.v6team.amw.springbatch.batch;

import java.util.List;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.v6team.amw.springbatch.model.StockData;
import com.v6team.amw.springbatch.service.StockService;

@Component
public class DBWriter implements ItemWriter<StockData> {

	@Autowired
	private StockService stockService;
	
	@Override
	public void write(List<? extends StockData> stockData) throws Exception {
		stockService.save(stockData);
	}

}
