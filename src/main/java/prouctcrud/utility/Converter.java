package prouctcrud.utility;

import org.springframework.beans.BeanUtils;

import productcrud.bean.ProductBean;
import productcrud.entity.Product;

public class Converter {
	
	public Product beanToEntity(ProductBean bean) {
		Product productEntity = new Product();
		BeanUtils.copyProperties(bean, productEntity);
		return productEntity;
	}
	
	public ProductBean entityToBean(Product productEntity) {
		ProductBean productBean = new ProductBean();
		BeanUtils.copyProperties(productEntity, productBean);
		return productBean;
	}

}
