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
	
	

	/**
	 * Returns the product with the specified ID.
     *
     * @param id    The ID of the product to retrieve.
     * @return      The product with the specified ID.
	 */
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
	
	
	
	/**
     * Returns all products in the database.
     *
     * @return  All products in the database.
     */
	@GetMapping("/products")
    public Iterable<Product> getProducts() {
        return productService.findAll();
    }

	/**
     * Creates a new product.
     * @param product   The product to create.
     * @return          The created product.
     */
	@PostMapping("/product")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		return null;
    	
    }
    
	 /**
     * Updates the fields in the specified product with the specified ID.
     * @param product   The product field values to update.
     * @param id        The ID of the product to update.
     * @param ifMatch   The eTag version of the product.
     * @return          A ResponseEntity that contains the updated product or one of the following error statuses:
     *                  NOT_FOUND if there is no product in the database with the specified ID
     *                  CONFLICT if the eTag does not match the version of the product to update
     *                  INTERNAL_SERVICE_ERROR if there is a problem creating the location URI
     */
	@PutMapping("/product/{id}")
    public ResponseEntity<?> updateProduct(@RequestBody Product product,
                                           @PathVariable Integer id,
                                           @RequestHeader("If-Match") Integer ifMatch) {
											return null;
		
	}
    
	
	/**
     * Deletes the product with the specified ID.
     * @param id    The ID of the product to delete.
     * @return      A ResponseEntity with one of the following status codes:
     *              200 OK if the delete was successful
     *              404 Not Found if a product with the specified ID is not found
     *              500 Internal Service Error if an error occurs during deletion
     */
	@DeleteMapping("/product/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
		return null;
		
	}
	
	    

}
