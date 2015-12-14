package com.bigsavings.deals.domain;

import java.io.Serializable;
import java.util.List;

import com.bigsavings.deals.model.Deal;

public class DealsResponse implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6527432534391605944L;

	public DealsResponse() {
		super();
	}

	private List<Deal> deals;

	public List<Deal> getDeals() {
		return deals;
	}

	public void setDeals(List<Deal> deals) {
		this.deals = deals;
	}
}
