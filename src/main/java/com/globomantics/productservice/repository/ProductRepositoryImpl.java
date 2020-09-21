package com.globomantics.productservice.repository;

import java.util.Optional;

import javax.sql.DataSource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.globomantics.productservice.model.Product;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
	
	private static final Logger logger = LogManager.getLogger(ProductRepositoryImpl.class);

    private final JdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsert simpleJdbcInsert;
    
    public ProductRepositoryImpl(JdbcTemplate jdbcTemplate, DataSource dataSource) {
        this.jdbcTemplate = jdbcTemplate;
     // Build a SimpleJdbcInsert object from the specified data source
        this.simpleJdbcInsert = new SimpleJdbcInsert(dataSource)
                .withTableName("products")
                .usingGeneratedKeyColumns("id");
    }

	@Override
	public Optional<Product> findById(Integer id) {
		// TODO Auto-generated method stub
		try {
            Product product = jdbcTemplate.queryForObject("SELECT * FROM products WHERE id = ?",
                    new Object[]{id},
                    (rs, rowNum) -> {
                        Product p = new Product();
                        p.setId(rs.getInt("id"));
                        p.setName(rs.getString("name"));
                        p.setQuantity(rs.getInt("quantity"));
                        p.setVersion(rs.getInt("version"));
                        return p;
                    });
            return Optional.of(product);
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
	}

}
