import { useEffect, useState } from 'react';
import { getAllProducts } from './api/inventoryApi';

function App() {
  const [products, setProducts] = useState([]);

  // This runs as soon as the page loads
  useEffect(() => {
    getAllProducts()
        .then(response => {
          setProducts(response.data);
        })
        .catch(error => {
          console.error("Connection to ByteFlow Backend failed!", error);
        });
  }, []);

  return (
      <div style={{ padding: '30px', fontFamily: 'sans-serif' }}>
        <h1 style={{ color: '#2c3e50' }}>📦 ByteFlow Inventory Dashboard</h1>
        <table border="1" cellPadding="10" style={{ width: '100%', borderCollapse: 'collapse' }}>
          <thead style={{ backgroundColor: '#ecf0f1' }}>
          <tr>
            <th>SKU</th>
            <th>Name</th>
            <th>Stock Quantity</th>
            <th>Price (LKR)</th>
          </tr>
          </thead>
          <tbody>
          {products.map(p => (
              <tr key={p.id}>
                <td><code>{p.sku}</code></td>
                <td>{p.name}</td>
                <td style={{ color: p.quantity < 10 ? 'red' : 'black', fontWeight: 'bold' }}>
                  {p.quantity}
                </td>
                <td>{p.price.toLocaleString()}</td>
              </tr>
          ))}
          </tbody>
        </table>
      </div>
  );
}

export default App;
