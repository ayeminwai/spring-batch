package com.v6team.amw.springbatch.model;

public class StockData{
	
	private Integer id;
	private String code;
	private String name;
	private Integer qty;
	private Double price;
	
	public StockData() {
		super();
		this.clearProperties();
	}

	private void clearProperties() {
		this.id = 0;
		this.code = "";
		this.name = "";
		this.qty = 0;
		this.price = 0D;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQty() {
		return qty;
	}

	public void setQty(Integer qty) {
		this.qty = qty;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "StockData [id=" + id + ", code=" + code + ", name=" + name + ", qty=" + qty + ", price=" + price + "]";
	}
}
