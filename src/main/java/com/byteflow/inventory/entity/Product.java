package com.byteflow.inventory.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50, unique = true, nullable = false)
    private String sku; // Stock Keeping Unit - Unique identifier

    @Column(length = 255, nullable = false)
    private String name;

    @Column(length = 100)
    private String category;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    private Integer quantity;

    @Column(name = "reorder_level")
    private Integer reorderLevel;

    @Column(length = 50)
    private String location; // e.g., Warehouse Bin A-12
}
