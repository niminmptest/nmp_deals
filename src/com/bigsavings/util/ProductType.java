package com.bigsavings.util;

public enum ProductType {
	DRESS("Dress"),
	BEAUTY("Beauty"),
	SHOES("Shoe");
	
	private String productType;

	ProductType(String productType) {
		this.productType = productType;
	}

	public String getProductType() {
		return productType;
	}
}
