package com.globomantics.productservice.repository;

import java.util.Optional;

import com.globomantics.productservice.model.Product;

public interface ProductRepository {

	/**
     * Returns the produce with the specified id.
     *
     * @param id        ID of the product to retrieve.
     * @return          The requested Product if found.
     */
	Optional<Product> findById(Integer id);

}
