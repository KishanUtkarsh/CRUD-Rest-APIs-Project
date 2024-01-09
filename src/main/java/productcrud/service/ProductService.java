package productcrud.service;

import java.util.List;

import productcrud.entity.Product;

public interface ProductService {

	public Product showProduct(int productId);

	public List<Product> showProducts();

	public int addProduct(Product product);

	public int removeProduct(int productId);

	public int updateProduct(Product product);
}
