/**
 * Add or Remove products from cart, view Cart for "Customers".
 */
package com.dev_loper.ShoppingCart.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.dev_loper.ShoppingCart.Models.Item;
import com.dev_loper.ShoppingCart.Models.Product;

@Component
public class CartService {

	public static HashMap<Integer, Item> items = new HashMap<>();

	static {
		items.put(1, new Item(new Product(1, "Redmi k10", "Smartphones", "Electronics", 10000L), 1));
		items.put(2, new Item(new Product(2, "Levis winter ware", "T-shirts", "Clothing", 3500L), 1));
	}

	public Product getProductById(int id) {
		for (Map.Entry<Integer, Item> itemPair : items.entrySet()) {
			if (itemPair.getKey() == id) {
				return itemPair.getValue().getProduct();
			}
		}
		return null;
	}

	public Product addProduct(Product product) {
		if (!items.containsKey(product.getId())) {
			Item newItem = new Item(product, 1);
			items.put(product.getId(), newItem);
		} else {
			items.get(product.getId()).setQuantity(items.get(product.getId()).getQuantity() + 1);
		}
		return product;
	}

	public Product removeProduct(int id) {
		Product product = null;
//		if(isEmpty()) {
//			return product;
//		}else {
		product = getProductById(id);
//		}
		if (!items.containsKey(product.getId())) {
			product = null;
		} else {
			if (items.get(product.getId()).getQuantity() == 1) {
				items.remove(product.getId());
			} else {
				items.get(product.getId()).setQuantity(items.get(product.getId()).getQuantity() - 1);
			}
		}
		return product;
	}

	public int getTotalPrice() {
		int total = 0;
		for (Map.Entry<Integer, Item> itemPair : items.entrySet()) {
			Item item = itemPair.getValue();
			total += item.getItemPrice();
		}
		return total;
	}

	public List<Item> showCart() {
		List<Item> cartItems = new ArrayList<Item>();
		for (Map.Entry<Integer, Item> itemPair : items.entrySet()) {
			cartItems.add(itemPair.getValue());
		}
		return cartItems;
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

}