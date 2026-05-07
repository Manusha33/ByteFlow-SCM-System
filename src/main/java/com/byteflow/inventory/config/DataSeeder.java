package com.byteflow.inventory.config;

import com.byteflow.inventory.entity.Product;
import com.byteflow.inventory.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DataSeeder {

    @Bean
    CommandLineRunner initDatabase(ProductRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                List<Product> products = List.of(
                        new Product(null, "LAP-ASU-G14-S", "Asus Zephyrus G14", "Laptop", "High-end gaming laptop", BigDecimal.valueOf(450000.0), 15, 5, "A-01"),
                        new Product(null, "CPU-INT-I7-12K", "Intel Core i7-12700K", "Component", "12th Gen Processor", BigDecimal.valueOf(125000.0), 25, 10, "B-05"),
                        new Product(null, "GPU-NVI-RTX40", "NVIDIA RTX 4060", "Component", "8GB VRAM Graphics Card", BigDecimal.valueOf(115000.0), 10, 3, "B-08")
                        // You can add more from our master list here
                );
                repository.saveAll(products);
                System.out.println(">> Inventory seeded successfully with 3 sample products!");
            }
        };
    }
}

