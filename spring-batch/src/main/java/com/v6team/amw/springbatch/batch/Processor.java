package com.v6team.amw.springbatch.batch;

import java.util.HashMap;
import java.util.Map;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.v6team.amw.springbatch.model.StockData;

@Component
public class Processor implements ItemProcessor<StockData, StockData> {
	private static final Map<String,String> STOCK_DESC = new HashMap<>();
	
	public Processor() {
		STOCK_DESC.put("1", "APPLE");
		STOCK_DESC.put("2", "BOOK");
		STOCK_DESC.put("3", "HOUSE");
	}
	@Override
	public StockData process(StockData stockData) throws Exception {
/*		String id = stockData.getId()+"";
		String name = STOCK_DESC.get(id) != null ? STOCK_DESC.get(id) : stockData.getName();*/
		stockData.setName("AAA");
		return stockData;
	}

}
