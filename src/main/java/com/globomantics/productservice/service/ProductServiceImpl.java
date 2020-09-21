package com.globomantics.productservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.globomantics.productservice.model.Product;
@Service
public class ProductServiceImpl implements ProductService {

	@Override
	public Optional<Product> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Product save(Product product) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}


}
