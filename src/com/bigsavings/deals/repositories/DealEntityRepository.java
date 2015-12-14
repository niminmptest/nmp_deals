package com.bigsavings.deals.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.bigsavings.deals.model.Deal;

/**
 * DAO class dealing with DB operations for DEAL
 * @author Nimin
 *
 */
public interface DealEntityRepository extends CrudRepository<Deal, Long>{

	List<Deal> findAll();
	
	Deal saveAndFlush(Deal deal);
	
	Deal findOne(Long dealId);
	
	@Modifying
	@Transactional(readOnly=false)
	@Query("update Deal d set d.likeCount = d.likeCount + 1 where d.dealId = ?1")
	void updateLikes(Long dealid);
	
}
