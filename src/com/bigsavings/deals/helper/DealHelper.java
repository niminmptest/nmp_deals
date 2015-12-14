package com.bigsavings.deals.helper;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigsavings.deals.model.Deal;
import com.bigsavings.deals.repositories.DealEntityRepository;

@Component
public class DealHelper {

	@Autowired
	private DealEntityRepository dealEntityRepository;
	
	public List<Deal> getAllDeals() {
		return dealEntityRepository.findAll();
	}
	
	public void saveDeal(Deal deal) {
		dealEntityRepository.saveAndFlush(deal);
	}
	
	public Deal getDeal(Long dealId) {
		return dealEntityRepository.findOne(dealId);
	}
	
	public void updateDealLikes(Long dealId) {
		dealEntityRepository.updateLikes(dealId);
	}
}
