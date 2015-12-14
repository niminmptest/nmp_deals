package com.bigsavings.deals.repositories;

import org.springframework.data.repository.CrudRepository;

import com.bigsavings.deals.model.Comment;

public interface CommentEntityRepository extends CrudRepository<Comment, Long>{
	
	public Comment saveAndFlush(Comment comment);
	
}
