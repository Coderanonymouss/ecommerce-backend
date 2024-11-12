package com.zosh.sevice.impl;

import com.zosh.exception.ProductException;
import com.zosh.model.Category;
import com.zosh.model.Product;
import com.zosh.repository.CategoryRepository;
import com.zosh.repository.ProductRepository;
import com.zosh.request.CreateProductRequest;
import com.zosh.sevice.ProductService;
import com.zosh.sevice.UserService;
import org.springframework.data.domain.Page;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProductServiceImplemention implements ProductService {
    private ProductRepository productRepository;
    private UserService userService;
    private CategoryRepository categoryRepository;

    public ProductServiceImplemention(ProductRepository productRepository, UserService userService, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.userService = userService;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product createProduct(CreateProductRequest req) {

        Category topLevel = categoryRepository.findByName(req.getTopLavelCategory());
        if (topLevel == null) {
            Category topLevelCategory = new Category();
            topLevelCategory.setName(req.getTopLavelCategory());
            topLevelCategory.setLevel(1);

            topLevel = categoryRepository.save(topLevelCategory);

        }

        Category secondLevel = categoryRepository.
                findByNameAndParent(req.getSecondLavelCategory(),topLevel.getName());
        if (secondLevel == null) {
            Category secondLevelCategory = new Category();
            secondLevelCategory.setName(req.getSecondLavelCategory());
            secondLevelCategory.setParentCategory(topLevel);
            secondLevelCategory.setLevel(2);

            secondLevel = categoryRepository.save(secondLevelCategory);

        }

        Category thirdLevel = categoryRepository.findByNameAndParent(req.getThirdLavelCategory(),secondLevel.getName());
        if (thirdLevel == null) {
            Category thirdLevelCategory = new Category();
            thirdLevelCategory.setName(req.getThirdLavelCategory());
            thirdLevelCategory.setParentCategory(secondLevel);
            thirdLevelCategory.setLevel(3);

            thirdLevel = categoryRepository.save(thirdLevelCategory);

        }

        Product product = Product.builder()
                .title(req.getTitle())
                .color(req.getColor())
                .description(req.getDescription())
                .discountedPrice(req.getDiscountedPrice())
                .discountPersent(req.getDiscountPersent())
                .imageUrl(req.getImageUrl())
                .brand(req.getBrand())
                .price(req.getPrice())
                .sizes(req.getSize())
                .quantity(req.getQuantity())
                .category(thirdLevel)
                .createdAt(LocalDateTime.now())
                .build();

        Product saveProduct = productRepository.save(product);
        return saveProduct;
    }

    @Override
    public String deleteProduct(Long productId) throws ProductException {
        return null;
    }

    @Override
    public Product updateProduct(Long productId, Product product) throws ProductException {
        return null;
    }

    @Override
    public Product findProductById(Long id) throws ProductException {
        return null;
    }

    @Override
    public List<Product> findProductById(String category) {
        return null;
    }

    @Override
    public Page<Product> getAllProduct(String category, List<String> colors, List<String> sizes, Integer minPrice, Integer maxPrice, Integer minDiscount, String sort, String stock, Integer pageNumber, Integer pageSize) {
        return null;
    }
}
