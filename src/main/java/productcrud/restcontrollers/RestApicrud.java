package productcrud.restcontrollers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import productcrud.bean.ProductBean;
import productcrud.entity.Product;
import productcrud.service.ProductService;
import prouctcrud.utility.Converter;

@Controller
public class RestApicrud {

	@Autowired
	private ProductService service;
	
	private Converter convert = new Converter();
	
	
	// Retrieving Single Product Data from Database
	@RequestMapping(path = "/get-product/{id}" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
		Product product = this.service.showProduct(id);
		
		return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
	
	
	
	// Adding Product into Database
	@RequestMapping(path = "/set-product" , method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE
			,produces = MediaType.TEXT_PLAIN_VALUE)
	
	public ResponseEntity<String> setProduct(@RequestBody Product product) {
		
		int id = this.service.addProduct(product);
		return new ResponseEntity<String>("Product save in Database ID : " + id,HttpStatus.OK);
	}
	
	
	
	// Updating Product Database
	@RequestMapping(path = "/update-product" , consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE,method = RequestMethod.POST)
	public ResponseEntity<ProductBean> updateProduct(@RequestBody Product product){
		int id = this.service.updateProduct(product);
		ProductBean updatedBean = convert.entityToBean(this.service.showProduct(id));
		return new ResponseEntity<ProductBean>(updatedBean,HttpStatus.OK);
	}
	
	
	// Getting All the Product Database
	@RequestMapping(path = "/get-all",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> showAllProduct(){
		List<Product> products = this.service.showProducts();
		return new ResponseEntity<List<Product>>(products,HttpStatus.OK);
		
	}
	
	
	
	
	
	
}
