package com.bigsavings.deals.service;

import java.util.Arrays;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;

import com.bigsavings.deals.domain.DealsResponse;
import com.bigsavings.deals.exception.AppException;
import com.bigsavings.deals.exception.ErrorCode;
import com.bigsavings.deals.helper.CommentHelper;
import com.bigsavings.deals.helper.DealHelper;
import com.bigsavings.deals.model.Comment;
import com.bigsavings.deals.model.Deal;

@Path("/v1/dealsService")
@Component
public class DealsService {
	
	@Autowired
	private DealHelper dealHelper;
	
	@Autowired
	private CommentHelper commentHelper;

	// added to test git. TO be removed
	private String test;
 
	@Path("/deal")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDeals() throws AppException {
		
		DealsResponse dealsResponse = new DealsResponse();
		try {
			dealsResponse.setDeals(dealHelper.getAllDeals());
		} catch(Exception exc) {
			throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					ErrorCode.BIGSAVINGS_ERROR_CODE.getErrorCode(), "System Error", "System Error");
		}
		
		return Response.status(HttpStatus.OK.value()).entity(dealsResponse)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS")
				.type(MediaType.APPLICATION_JSON).build();
	}
	
	@Path("/deal")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postDeal(@Validated @RequestBody Deal deal) throws AppException {
		
		try {
			dealHelper.saveDeal(deal);
		} catch(Exception exc) {
			throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					ErrorCode.BIGSAVINGS_ERROR_CODE.getErrorCode(), "System Error", "System Error");
		}
		
		return Response.status(HttpStatus.CREATED.value()).build();
	}
	
	@Path("/comment/{dealId}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response postComment(@RequestBody Comment comment, @PathParam("dealId") String dealId) throws AppException {
		
		Deal deal = new Deal();
		deal.setDealId(Long.valueOf(dealId));
		try {
			comment.setDeal(deal);
			commentHelper.saveDeal(comment);
		} catch(Exception exc) {
			throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					ErrorCode.BIGSAVINGS_ERROR_CODE.getErrorCode(), "System Error", "System Error");
		}
		
		return Response.status(HttpStatus.CREATED.value()).build();
	}
	
	@Path("/deal/{dealId}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllDeals(@PathParam("dealId") String dealId) throws AppException {
		
		DealsResponse dealsResponse = new DealsResponse();
		try {
			dealsResponse.setDeals(Arrays.asList(dealHelper.getDeal(Long.valueOf(dealId))));
		} catch(Exception exc) {
			throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					ErrorCode.BIGSAVINGS_ERROR_CODE.getErrorCode(), "System Error", "System Error");
		}
		
		return Response.status(HttpStatus.OK.value()).entity(dealsResponse)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS")
				.type(MediaType.APPLICATION_JSON).build();
	}
	
	@Path("/deal/like/{dealId}")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response likeDeal(@PathParam("dealId") String dealId) throws AppException {
		
		try {
			dealHelper.updateDealLikes(Long.valueOf(dealId));
		} catch(Exception exc) {
			throw new AppException(HttpStatus.INTERNAL_SERVER_ERROR.value(),
					ErrorCode.BIGSAVINGS_ERROR_CODE.getErrorCode(), "System Error", "System Error");
		}
		
		return Response.status(HttpStatus.CREATED.value()).build();
	}
}
