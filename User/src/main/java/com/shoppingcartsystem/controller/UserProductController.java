package com.shoppingcartsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("/api/users/product")
public class UserProductController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	
/**
 * USER CONNECTION WITH THE PRODUCT
 */
	
	@GetMapping("/getAllProducts")
	public String getAllProducts() {
		return restTemplate.getForObject("http://localhost:8082/api/products/allProducts", String.class);
	}
	
	@GetMapping("/getProductByName/{pName}")
	public String getProductBypName(@PathVariable String pName) {
		return restTemplate.getForObject("http://localhost:8082/api/products/productBypName/" + pName, String.class);
		
	}
	
	@GetMapping("/getProductByCategory/{pCategory}")
	public String getProductBypCategory(@PathVariable String pCategory) {
		return restTemplate.getForObject("http://localhost:8082/api/products/productBypCategory/" + pCategory, String.class);
	}
	

}
