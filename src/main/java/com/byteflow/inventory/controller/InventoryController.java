package com.byteflow.inventory.controller;

import com.byteflow.inventory.entity.Product;
import com.byteflow.inventory.service.InventoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory") // This is the base URL for your module
@CrossOrigin(origins = "http://localhost:5173") // Allows your React frontend to call these APIs
public class InventoryController {

    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // 1. Get all products (Used for your Module's UI)
    @GetMapping
    public List<Product> getAllProducts() {
        return inventoryService.getAllProducts();
    }

    // 2. Get stock details by SKU (Integration: Shared Identifier Requirement)
    // Used by Order & Billing module to check availability
    @GetMapping("/{sku}")
    public ResponseEntity<Product> getProductBySku(@PathVariable String sku) {
        return inventoryService.getProductBySku(sku)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. Update stock levels (Integration: Shared Identifier Requirement)
    // Used by Shipment module to adjust stock after delivery
    @PutMapping("/update/{sku}")
    public ResponseEntity<Product> updateStock(@PathVariable String sku, @RequestParam int change) {
        try {
            Product updatedProduct = inventoryService.updateStock(sku, change);
            return ResponseEntity.ok(updatedProduct);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
