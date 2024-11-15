package com.zosh.request;

import com.zosh.model.Size;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CreateProductRequest {

    private String title;
    private String description;
    private int price;

    private int discountedPrice;

    private int discountPersent;

    private int quantity;

    private String brand;

    private String color;

    private Set<Size> size = new HashSet<>();

    private String imageUrl;

    private String topLavelCategory;
    private String secondLavelCategory;
    private String thirdLavelCategory;



}
