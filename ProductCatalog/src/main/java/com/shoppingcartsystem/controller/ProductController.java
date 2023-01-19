package com.shoppingcartsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shoppingcartsystem.exception.ApiRequestException;
import com.shoppingcartsystem.model.Product;
import com.shoppingcartsystem.repository.ProductRepository;
import com.shoppingcartsystem.service.ProductService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ProductRepository productRepository;
	
	@GetMapping("pagination/allProducts")
	private Page<Product> getProductPerPage(Pageable p){
		Page<Product> productLists = productService.getProductByPageNo(p);
//		if (!productLists.isEmpty()) {
//			log.info("FINDING ALLPRODUCTS INFO USING PAGINATION {}");
			return productLists;
//		} else {
//			log.error("GETTINGALLPRODUCTS METHOD ERROR {}");
//		}
	}
	

	// Getting all product
	@GetMapping("/allProducts")
	private ResponseEntity<Object> gettingAllProducts() {
//		try {
//			List<Product> products = productService.findAll();
//			log.info("FINDING ALLPRODUCTS INFO {}");
//			return new ResponseEntity<> (products, HttpStatus.FOUND);
//		} catch (Exception e) {
//			log.error("GETTINGALLPRODUCTS PRODUCTS METHOD ERROR {}",e.getMessage());
//			return new ResponseEntity<>("TRY AGAIN IN SOMETIME",HttpStatus.NOT_FOUND);
//		}
//		

		List<Product> productLists = productService.findAll();
		if (!productLists.isEmpty()) {
//				List<Product> product = productService.findAll();
			log.info("FINDING ALLPRODUCTS INFO {}");
			return new ResponseEntity<Object>(productLists, HttpStatus.OK);
		} else {
			log.error("GETTINGALLPRODUCTS METHOD ERROR {}");
			return new ResponseEntity<Object>("OPPS!!! TRY AGAIN LATER", HttpStatus.NOT_FOUND);
		}
	}

	// Getting Product by pName
	@GetMapping("/productBypName/{pName}")
	private ResponseEntity<Object> gettingProductsBypName(@PathVariable(value = "pName") String pName) {

//		try {
//			Product product = productService.findBypName(pName);
//			log.info("FINDING PRODUCTS BY PNAME {}");
//			return new ResponseEntity<>(product, HttpStatus.FOUND);
//			
//		}catch(Exception e) {
//			log.error("FIND PRODUCTBYNAME METHOD ERROR {}" , e.getMessage());
//			return new ResponseEntity<>("TRY SEARCHING WITH OTHER NAME",HttpStatus.NOT_FOUND);	
//		}

		boolean isProductExists = productRepository.existsBypName(pName);
		if (isProductExists) {
			List<Product> product = productService.findBypName(pName);
			return new ResponseEntity<Object>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("PRODUCT NOT PRESENT WITH THIS NAME {}", HttpStatus.NOT_FOUND);
		}
	}

	// Getting Product by pCategory
	@GetMapping("/productBypCategory/{pCategory}")
	private ResponseEntity<Object> gettingProductBypCategory(@PathVariable String pCategory) {

		boolean isProductExists = productRepository.existsBypCategory(pCategory);
		if (isProductExists) {
			List<Product> product = productService.findBypCategory(pCategory);
			return new ResponseEntity<Object>(product, HttpStatus.OK);
		} else {
			return new ResponseEntity<Object>("PRODUCT NOT PRESENT WITH THIS CATOGERY {}", HttpStatus.NOT_FOUND);
		}
	}

	// Getting Product by PId
	@GetMapping("/productBypId/{pId}")
	private ResponseEntity<Object> gettingProductBypId(@PathVariable long pId) {

		Product product = productService.findBypId(pId);
		if (product != null) {
			log.info("FINDING PRODUCTS BY PID {}");
			return new ResponseEntity<>(product, HttpStatus.OK);
		} else {
			log.error("PRODUCT NOT PRESENT WITH THIS ID {}");
			return new ResponseEntity<>("PRODUCT NOT PRESENT WITH THIS ID {}", HttpStatus.NOT_FOUND);
		}

//		try {
//			boolean isProductExists = productRepository.existsById(pId);
//			if (isProductExists) {
//				Product product = productService.findBypId(pId);
//				return new ResponseEntity<Object>(product, HttpStatus.FOUND);
//			} else {
//				throw new ApiRequestException("PRODUCT NOT PRESENT WITH THIS ID ::");
//			}
//		} catch (Exception e) {
//			log.error("FIND PRODUCTBYID METHOD ERROR {}", e.getMessage());
//			return new ResponseEntity<Object>("PRODUCT NOT PRESENT WITH THIS ID {}", HttpStatus.NOT_FOUND);
//		}
	}

	// Adding Product
	@PostMapping("/create")
	private ResponseEntity<Object> createProduct(@RequestBody Product product) {
		try {
			Product products = productService.addProduct(product);
			log.info("CREATING NEW PRODUCT {}");
			return new ResponseEntity<Object>(products, HttpStatus.CREATED);
		} catch (Exception e) {
			log.error("CREATE PRODUCT METHOD ERROR {}", e.getMessage());
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.CONFLICT);
		}
	}

	// Updating Product
	@PutMapping("/update/{pId}")
	private ResponseEntity<Object> updateProduct(@RequestBody Product product, @PathVariable long pId) {

		try {
			boolean isProductExistsByuId = productRepository.existsById(pId);
			if (isProductExistsByuId) {
				if (product.getpId() == pId) {
					productService.updateProduct(product);
					log.info("UPDATING USER BY PID {}");
					return new ResponseEntity<Object>(product, HttpStatus.OK);
				} else {
					log.error("PID MISMATCH {} ");
					return new ResponseEntity<Object>("PID MISMATCH {}", HttpStatus.BAD_REQUEST);
				}
			} else {
				log.error("PRODUCT NOT FOUND WITH THIS PID {} " + pId);
				return new ResponseEntity<Object>("PRODUCT NOT FOUND WITH THIS ID {} " + pId, HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			log.error("PID MISSING {} ");
			return new ResponseEntity<Object>("PID MISSING {}" + e.getMessage(), HttpStatus.BAD_REQUEST);
		}

//		try {
//			boolean isProductExists = productRepository.existsById(pId);
//			if(isProductExists) {
//				productService.updateProduct(product);
//				return new ResponseEntity<Object>(product, HttpStatus.OK);
//			}else {
//				throw new ApiRequestException("CAN NOT UPDATE AS PRODUCT NOT FOUND WITH THIS ID ::");
//			}
//		}catch(Exception e){
//			log.error("UPDATE PRODUCT METHOD ERROR {}",e.getMessage());
//			return new ResponseEntity<Object>("PRODUCT NOT PRESENT WITH THIS ID {}",HttpStatus.NOT_FOUND);
//		}
	}

	// Delete product by pId
	@DeleteMapping("/delete/{pId}")
	private ResponseEntity<Object> deleteProductBypId(@PathVariable long pId) {

		boolean isProductExistsBypId = productRepository.existsById(pId);
		if (isProductExistsBypId) {
			productService.deleteBypId(pId);
			log.info("DELETING PRODUCTS BY PID {}");
			return new ResponseEntity<Object>("PRODUCT DELETED SUCCESSFULLY", HttpStatus.OK);
		} else {
			log.error("DATA NOT PRESENT WITH THIS ID {}");
			return new ResponseEntity<Object>("PRODUCT NOT PRESENT WITH THIS ID {}", HttpStatus.NOT_FOUND);
		}
	}
}
