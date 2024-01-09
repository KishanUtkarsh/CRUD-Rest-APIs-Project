package productcrud.controllers;

import java.net.http.HttpRequest;

import javax.servlet.http.HttpServletRequest;
import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import productcrud.entity.Product;
import productcrud.service.ProductService;

@Controller
public class HomeController {
	
	@Autowired
	private ProductService service;

	@RequestMapping("/")
	public String home(Model m) {		
		m.addAttribute("title" , "Home Page");
		m.addAttribute("products", this.service.showProducts());
		return "index";
	}
	
	@RequestMapping("/add-product")
	public String addPage(Model m) {
		
		m.addAttribute("title", "Add Product");		
		return "add_product_form";
	}
	
	@RequestMapping(value = "/handle-product" , method = RequestMethod.POST)
	public RedirectView addProduct(@ModelAttribute("Product") Product product, HttpServletRequest r ) {
		RedirectView view = new RedirectView(r.getContextPath()+"/");
		if(product.getProductName()!= "") {
			this.service.addProduct(product);
		}
		return view;
	}
	
	@RequestMapping("/delete/{productId}")
	public RedirectView deleteProduct(@PathVariable int productId, HttpServletRequest r) {
		RedirectView view = new RedirectView(r.getContextPath()+"/");
		this.service.removeProduct(productId);
		return view;
	}
	
	@RequestMapping("/update/{productId}")
	public String updateProduct(@PathVariable int productId , Model model) {
		model.addAttribute("title","Update Product");
		model.addAttribute("product",this.service.showProduct(productId));
		
		return "update-form";
	}
	
	@RequestMapping(value = "/update-product", method = RequestMethod.POST)
	public RedirectView updateForm(@ModelAttribute("Product") Product product, HttpServletRequest r ) {
		RedirectView view = new RedirectView(r.getContextPath()+"/");
		this.service.updateProduct(product);
		return view;
	}
}
