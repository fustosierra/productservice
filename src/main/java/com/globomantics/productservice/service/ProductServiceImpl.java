package com.globomantics.productservice.service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.globomantics.productservice.model.Product;
import com.globomantics.productservice.repository.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

	private static final Logger logger = LogManager.getLogger(ProductServiceImpl.class);

	private final ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
	
	@Override
	public Optional<Product> findById(Integer id) {
		// TODO Auto-generated method stub
		logger.info("Find product with id: {}", id);
		return productRepository.findById(id);
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		logger.info("Find all products");
        return productRepository.findAll();
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		// Set the product version to 1 as we're adding a new product to the database
        product.setVersion(1);

        logger.info("Save product to the database: {}", product);
        return productRepository.save(product);
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}


}
