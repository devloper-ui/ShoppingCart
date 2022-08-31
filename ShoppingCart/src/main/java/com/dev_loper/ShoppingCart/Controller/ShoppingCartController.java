package com.dev_loper.ShoppingCart.Controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.dev_loper.ShoppingCart.Models.Item;
import com.dev_loper.ShoppingCart.Models.Product;
import com.dev_loper.ShoppingCart.Services.CartService;
import com.dev_loper.ShoppingCart.Services.ProductService;

@Controller
public class ShoppingCartController {

	@Autowired
	ProductService product;

	@Autowired
	CartService cart;

//	@GetMapping("/demo")
//	public String demo() {
//		return "demo";
//	}

	@GetMapping("/list") // list all available products.
	@ResponseBody
	public ResponseEntity<List<Product>> list(ModelMap model) {
		model.put("products", product.getAllProducts());
		List<Product> products = product.getAllProducts();

		if (products.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(products));
	}

//	@GetMapping("/search")
//	public String listBySearch(@RequestParam String type, ModelMap model) {
//		model.put("products", cart.searchByCategory(type));
//		return "list";
//	}

	@GetMapping("/search")
	public String listBySearch(@RequestParam Map<String, String> requestParams, ModelMap model) {
		String type = requestParams.get("type") == null ? "" : requestParams.get("type");
		String category = requestParams.get("category") == null ? "" : requestParams.get("category");
		String name = requestParams.get("name") == null ? "" : requestParams.get("name");
		String min = requestParams.get("min") == null ? "" : requestParams.get("min");
		String max = requestParams.get("max") == null ? "" : requestParams.get("max");
		String[] params = { category, type, name, min, max };
		model.put("products", product.searchByCategory(params));
		return "list";
	}

	@GetMapping("/search/{id}")
	@ResponseBody
	public ResponseEntity<Product> getProduct(@PathVariable int id) {
		Product prod = product.getProductById(id);
		if (product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(prod));
	}

//	@GetMapping("/addToCart")
//	@ResponseBody
//	public  displayCart() {
//		
//		return "";
//	}

	@PostMapping("/list")
	@ResponseBody
	public ResponseEntity<Product> addToList(@RequestBody Product listProduct) {
		Product p = null;
		try {
			System.out.println(listProduct.getType().getTypeName());
			p = product.addProduct(listProduct);
			return ResponseEntity.of(Optional.of(p));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/list/{id}")
	@ResponseBody
	public ResponseEntity<Void> removeFromList(@PathVariable int id) {
		try {
			product.removeProductById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@PutMapping("/list/{id}") //need to work in product class as have added jackson and type class
	@ResponseBody
	public ResponseEntity<Product> updateFromList(@RequestBody Product listProduct, @PathVariable int id) {

		try {
			product.updateProduct(listProduct, id);
			return ResponseEntity.ok().body(listProduct);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@GetMapping("/cart")
	@ResponseBody
	public ResponseEntity<List<Item>> showCart() {		
		List<Item> cartItems = cart.showCart();
		
		if(cartItems.size()<=0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}else {
			return ResponseEntity.of(Optional.of(cartItems));
		}
	}

	@PostMapping("/cart")
	@ResponseBody
	public ResponseEntity<Product> addToCart(@RequestBody Product cartProduct) {
		Product prod = null;
		try {
			prod = cart.addProduct(cartProduct);
			return ResponseEntity.of(Optional.of(prod));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

	@DeleteMapping("/cart/{id}")
	@ResponseBody
	public ResponseEntity<Product> removeFromCart(@PathVariable int id) {
		Product prod = null;
		try {
			prod = cart.removeProduct(id);
			return ResponseEntity.of(Optional.of(prod));
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
