package com.zosh.repository;

import com.zosh.model.Product;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.nio.file.LinkOption;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p " +
            "WHERE(p.category.name=:category OR :category='')" +
                 "AND ((:minPrice IS NULL AND :maxPrice IS NULL)" +
            " OR (p.discountedPrice BETWEEN :minPrice AND :maxPrice))" +
            "AND (:minDiscount IS NULL OR p.discountPersent>= :minDiscount)" +
                " ORDER BY " +
            "CASE WHEN :sort = 'price_low' THEN p.discountedPrice END ASC," +
            "CASE WHEN :sort = 'price_high' THEN p.discountedPrice END DESC")

    List<Product> filterProducts(@Param("category") String category,
                                 @Param("minPrice")Integer minPrice,
                                 @Param("maxPrice") String maxPrice,
                                 @Param("minDiscount") String minDiscount,
                                 @Param("sort") String sort);




}
