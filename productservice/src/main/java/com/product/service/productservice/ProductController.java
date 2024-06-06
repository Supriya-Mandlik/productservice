package com.product.service.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProductController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(path="/buyproduct" , method = RequestMethod.POST)
	public String buyProduct(@RequestBody Product product) {
		
		System.out.println(product);
		
		String msg = restTemplate.getForObject(
		       "http://localhost:8081/sendemail/"+product.getId(), String.class);
		
		return msg ;
		
	}

}

