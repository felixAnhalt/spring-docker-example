package com.itzeme.mario.demoDocker.rest;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
public class BuyingRestService {
	
	private final static Logger LOGGER = LoggerFactory.getLogger(BuyingRestService.class);
	private ApplicationContext ctx;
	
	@Autowired
	public BuyingRestService(ApplicationContext ctx) {
		ctx = ctx;
	}
	
	@PostConstruct
	public void setUp() {
		LOGGER.info(ctx.containsBean("buyingRestService") ? "Special bean has" : "Special bean has not" + " started it's rest-service!");
	}
	
	@GetMapping("works")
	public String getWiseSaying() {
		return "42 you search, but the question you know don't.<br> The way is the path's best friend on the journey!";
	}

	@GetMapping("doesntwork")
	public String getNonWiseSaying() {
		return "The final GOT episode was great!".substring(-1);
	}
	
}