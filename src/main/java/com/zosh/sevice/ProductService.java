package com.zosh.sevice;

import com.zosh.exception.ProductException;
import com.zosh.model.Product;
import com.zosh.request.CreateProductRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    Product createProduct(CreateProductRequest req);

    String deleteProduct(Long productId) throws ProductException;

    Product updateProduct(Long productId, Product product) throws ProductException;

    Product findProductById(Long id) throws ProductException;

    List<Product> findProductById(String category);

    Page<Product> getAllProduct(String category, List<String> colors,
                                List<String> sizes, Integer minPrice,
                                Integer maxPrice, Integer minDiscount,
                                String sort, String stock,
                                Integer pageNumber, Integer pageSize);
}
