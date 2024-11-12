package com.zosh.repository;

import com.zosh.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.parameters.P;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category findByName(String name);

    @Query("SELECT c from Category c WHERE c.name=:name AND c.parentCategory=:parentCategoryName")
    Category findByNameAndParent(@Param("name") String name,
                                 @Param("parentCategoryName") String parentCategoryName);
}
