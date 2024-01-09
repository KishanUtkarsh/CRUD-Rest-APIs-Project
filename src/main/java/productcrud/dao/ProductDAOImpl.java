package productcrud.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import productcrud.entity.Product;

@Repository
public class ProductDAOImpl implements ProductDAO{

	
	@Autowired
	private HibernateTemplate hibernateTemplate;
	
	@Override
	public Product showProduct(int productId) {
		Product product = this.hibernateTemplate.get(Product.class, productId);
		return product;
	}

	@Override
	public List<Product> showProducts() {
		List<Product> products = this.hibernateTemplate.loadAll(Product.class);
		return products;
	}

	@Override
	@Transactional
	public int addProduct(Product product) {
		this.hibernateTemplate.save(product);
		return product.getProductId();
	}

	@Override
	@Transactional
	public int removeProduct(int productId) {
		int prodId = productId;
		Product product = this.hibernateTemplate.get(Product.class, productId);
		this.hibernateTemplate.delete(product);
		return prodId;
	}

	@Override
	@Transactional
	public int updateProduct(Product product) {
		this.hibernateTemplate.update(product);
		return product.getProductId();
	}

}
