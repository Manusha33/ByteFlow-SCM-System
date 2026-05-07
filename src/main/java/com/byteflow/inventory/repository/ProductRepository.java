package com.byteflow.inventory.repository;

import com.byteflow.inventory.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    /**
     * Finds a product using the shared SKU identifier.
     * Required for integration with Order and Shipment modules.
     */
    Optional<Product> findBySku(String sku);

    /**
     * Used to verify if a product exists before trying to update stock.
     */
    boolean existsBySku(String sku);
}
