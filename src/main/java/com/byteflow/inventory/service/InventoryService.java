package com.byteflow.inventory.service;

import com.byteflow.inventory.entity.Product;
import com.byteflow.inventory.repository.ProductRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    private final ProductRepository productRepository;

    // Dependency Injection via Constructor
    public InventoryService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // 1. Get all products (Useful for your React Frontend)
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    // 2. Check stock by SKU (Crucial for the Order & Billing group)
    public Optional<Product> getProductBySku(String sku) {
        return productRepository.findBySku(sku);
    }

    // 3. Update stock levels (Used by Shipment group when items are delivered)
    public Product updateStock(String sku, int quantityChange) {
        Product product = productRepository.findBySku(sku)
                .orElseThrow(() -> new RuntimeException("Product not found with SKU: " + sku));

        int newQuantity = product.getQuantity() + quantityChange;

        if (newQuantity < 0) {
            throw new RuntimeException("Insufficient stock for SKU: " + sku);
        }

        product.setQuantity(newQuantity);
        return productRepository.save(product);
    }
}
