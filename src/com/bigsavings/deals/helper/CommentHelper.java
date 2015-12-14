package com.bigsavings.deals.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bigsavings.deals.model.Comment;
import com.bigsavings.deals.repositories.CommentEntityRepository;

@Component
public class CommentHelper {

	@Autowired
	private CommentEntityRepository commentEntityRepository;
	
	public void saveDeal(Comment comment) {
		commentEntityRepository.saveAndFlush(comment);
	}
}
