package com.globomantics.productservice.service;

import com.globomantics.productservice.model.Product;

public interface ProductService {

	Iterable<Product> findAll();

}
