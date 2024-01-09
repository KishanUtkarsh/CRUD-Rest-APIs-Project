package productcrud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import productcrud.dao.ProductDAO;
import productcrud.entity.Product;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDAO productdao;
	
	@Override
	public Product showProduct(int productId) {
		return productdao.showProduct(productId);
	}

	@Override
	public List<Product> showProducts() {
		return productdao.showProducts();
	}

	@Override
	public int addProduct(Product product) {
		return productdao.addProduct(product);
	}

	@Override
	public int removeProduct(int productId) {
		return productdao.removeProduct(productId);
	}

	@Override
	public int updateProduct(Product product) {
		return productdao.updateProduct(product);
	}

}
