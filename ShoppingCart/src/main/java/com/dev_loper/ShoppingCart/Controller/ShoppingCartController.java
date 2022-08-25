package com.dev_loper.ShoppingCart.Controller;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dev_loper.ShoppingCart.Models.Cart;

@Controller
public class ShoppingCartController {
	
	@Autowired
	Cart cart;
	
	@GetMapping("/demo")
	public String demo() {
		return "demo";
	}
	
	@GetMapping("/list")//list all available products.
	public String list(ModelMap model) {
		model.put("products",cart.getAllProducts());
		return "list";
	}
		
	@GetMapping("/search")//search products according to type,category,name,price(min,max)
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
}
