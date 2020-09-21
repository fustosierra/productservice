package com.globomantics.productservice.service;

import static org.mockito.Mockito.doReturn;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.globomantics.productservice.model.Product;
import com.globomantics.productservice.repository.ProductRepository;


/**
 * Tests the ProductService.
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ProductServiceTest {
	
	/**
     * The service that we want to test.
     */
    @Autowired
    private ProductService service;

    /**
     * A mock version of the ProductRepository for use in our tests.
     */
    @MockBean
    private ProductRepository repository;

    @Test
    @DisplayName("Test findById Success")
    void testFindByIdSuccess() {
        // Setup our mock
        Product mockProduct = new Product(1, "Product Name", 10, 1);
        doReturn(Optional.of(mockProduct)).when(repository).findById(1);

        // Execute the service call
        Optional<Product> returnedProduct = service.findById(1);

        // Assert the response
        Assertions.assertTrue(returnedProduct.isPresent(), "Product was not found");
        Assertions.assertSame(returnedProduct.get(), mockProduct, "Products should be the same");
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        // Setup our mock
        Product mockProduct = new Product(1, "Product Name", 10, 1);
        doReturn(Optional.empty()).when(repository).findById(1);

        // Execute the service call
        Optional<Product> returnedProduct = service.findById(1);

        // Assert the response
        Assertions.assertFalse(returnedProduct.isPresent(), "Product was found, when it shouldn't be");
    }


}
