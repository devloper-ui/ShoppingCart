package com.dev_loper.ShoppingCart.Controller;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev_loper.ShoppingCart.Models.Cart;
import com.dev_loper.ShoppingCart.Models.Product;

@Controller
public class ShoppingCartController {
	
	@Autowired
	Cart cart;
	
	@GetMapping("/demo")
	public String demo() {
		return "demo";
	}
	
	@GetMapping("/list")//list all available products.
	@ResponseBody
	public List<Product> list(ModelMap model) {
		model.put("products",cart.getAllProducts());
		return cart.getAllProducts();
	}
	
//	@GetMapping("/search")
//	public String listBySearch(@RequestParam String type, ModelMap model) {
//		model.put("products", cart.searchByCategory(type));
//		return "list";
//	}
	
	@GetMapping("/search")
	public String listBySearch(@RequestParam Map<String,String> requestParams, ModelMap model) {
		String type = requestParams.get("type")==null ? "" : requestParams.get("type");
		String category = requestParams.get("category")==null ? "" : requestParams.get("category");
		String name = requestParams.get("name")==null ? "" : requestParams.get("name");
		String min = requestParams.get("min")==null ? "" : requestParams.get("min");
		String max = requestParams.get("max")==null ? "" : requestParams.get("max");
		String[] params = {category,type,name,min,max};
		model.put("products", cart.searchByCategory(params));
		return "list";
	}
	
	@GetMapping("/search/{id}")
	@ResponseBody
	public Product getProduct(@PathVariable int id) {
		return cart.getProductById(id);
	}
	
//	@GetMapping("/addToCart")
//	@ResponseBody
//	public  displayCart() {
//		
//		return "";
//	}
	
	@PostMapping("/list")
	@ResponseBody
	public Product addToCart(@RequestBody Product product) {	
		cart.addProduct(product);
		return product;
	}
}
