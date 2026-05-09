import axios from 'axios';

// This must match your Spring Boot port (usually 8080)
const API_URL = "http://localhost:8080/api/inventory";

export const getAllProducts = () => axios.get(API_URL);