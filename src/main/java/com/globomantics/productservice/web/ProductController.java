/**
 * 
 */
package com.globomantics.productservice.web;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.globomantics.productservice.model.Product;
import com.globomantics.productservice.service.ProductService;

@RestController
public class ProductController {
	
	private final ProductService productService;
	
	private static final Logger logger = LogManager.getLogger(ProductController.class);
	
	public ProductController(ProductService productService) {
        this.productService = productService;
    }
	
	

	@GetMapping("/product/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Integer id) {
		 return productService.findById(id)
	                .map(product -> {
	                    try {
	                        return ResponseEntity
	                                .ok()
	                                .eTag(Integer.toString(product.getVersion()))
	                                .location(new URI("/product/" + product.getId()))
	                                .body(product);
	                    } catch (URISyntaxException e ) {
	                        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	                    }
	                })
	                .orElse(ResponseEntity.notFound().build());
		
	}
	
	

	@GetMapping("/products")
    public Iterable<Product> getProducts() {
        return productService.findAll();
    }

	
	@PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return null;
    	
    }
    
	
	@PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product,
                                           @PathVariable Integer id,
                                           @RequestHeader("If-Match") Integer ifMatch) {
											return null;
		
	}
    
	
	
	@DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
		return null;
		
	}
	
	    

}
