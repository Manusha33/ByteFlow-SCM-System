# ByteFlow Systems: Master Integration Guide (Initial draft of shared SKUs and API ports)

This document is the official integration reference for the SCM System Project. All four modules— "Inventory", "Order & Billing", "Shipment" and "User Management"
— must adhere to these standards to ensure the integrated system runs successfully via Docker.


## 1. Shared Identifier Standard (SKUs-Stock Keeping Units)
To ensure all modules can communicate regarding products, we use SKUs as our primary shared identifier. 
Format: [CATEGORY]-[BRAND]-[MODEL]-[VARIANT]

| SKU            | Product Name           | Category   | Base Price (LKR) | Initial Stock |
|                |                        |            |                  |               |
| LAP-ASU-G14-S  | Asus Zephyrus G14      | Laptop     | 450,000          | 15            |
| CPU-INT-I7-12K | Intel Core i7-12700K   | Component  | 125,000          | 25            |
| GPU-NVI-RTX40  | NVIDIA RTX 4060        | Component  | 115,000          | 10            |
| MON-DEL-U27    | Dell UltraSharp 27"    | Peripheral | 95,000           | 20            |
| RAM-COR-16D5   | Corsair Vengeance 16GB | Component  | 22,000           | 50            |
| SSD-SAM-980P   | Samsung 980 Pro 1TB    | Component  | 35,000           | 40            |
| KEY-LOG-MXM    | Logitech MX Master 3S  | Peripheral | 28,000           | 30            |
| MB-ASU-Z790    | ASUS Prime Z790-P      | Component  | 75,000           | 12            |
| PSU-SEA-850G   | Seasonic Focus 850W    | Component  | 45,000           | 18            |
| CAS-NZX-H51    | NZXT H510 Flow         | Component  | 18,000           | 15            |


## 2. API Integration Requirements[cite: 1]
All communication must use REST APIs and JSON data format[cite: 1].

### Inventory Module Endpoints (Group 5)
*   GET  - /api/inventory/{sku}  : Checks stock availability[cite: 1].
*   POST - /api/inventory/reserve  : Temporarily holds stock for an order[cite: 1].
*   PUT  - /api/inventory/update  : Confirms final stock deduction after shipping[cite: 1].

### Integration Logic Flow[cite: 1]
1. Order Module - checks stock in Inventory via SKU before confirming a purchase[cite: 1].
2. Order Module - notifies Inventory to "Reserve" the item[cite: 1].
3. Shipment Module - notifies Inventory to finalize the stock update once the item is dispatched[cite: 1].

---

## 3. Docker Port Allocations[cite: 1]
To prevent port conflicts on `localhost` during the `docker-compose up --build` demo, use these assigned ports[cite: 1]:

| Module           | Backend (Spring Boot) | Frontend (React) | Database (MySQL) |
|                  |                       |                  |                  |
| Inventory        | 8081                  | 3001             | 3306             |
| Order & Billing  | 8082                  | 3002             | 3307             |
| Shipment         | 8083                  | 3003             | 3308             |
| User Management  | 8084                  | 3004             | 3309             |

---

## 4. Technology Stack[cite: 1]
*   Frontend:- React.js[cite: 1]
*   Backend:- Spring Boot[cite: 1]
*   Database:- MySQL[cite: 1]
*   Deployment:- Docker / Docker Compose[cite: 1]
