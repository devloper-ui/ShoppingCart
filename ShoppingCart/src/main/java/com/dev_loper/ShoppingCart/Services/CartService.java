/**
 * Add or Remove products from cart, view Cart for "Customers".
 */
package com.dev_loper.ShoppingCart.Services;

import java.util.HashMap;
import java.util.Map;

import com.dev_loper.ShoppingCart.Models.Item;
import com.dev_loper.ShoppingCart.Models.Product;

class CartService {

	HashMap<Integer, Item> items = new HashMap<>();

	public Product getProductById(int id) {
		for (Map.Entry<Integer, Item> itemPair : items.entrySet()) {
			if (itemPair.getKey() == id) {
				return itemPair.getValue().getProduct();
			}
		}
		return null;
	}

	public void addProduct(Product product) {
		if (!items.containsKey(product.getId())) {
			Item newItem = new Item(product, 1);
			items.put(product.getId(), newItem);
		} else {
			items.get(product.getId()).setQuantity(items.get(product.getId()).getQuantity() + 1);
		}
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
			items.get(product.getId()).setQuantity(items.get(product.getId()).getQuantity() - 1);
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

	public String viewCart() {
		if (items.isEmpty()) {
			return "Cart is empty";
		}

		String itemizedList = "";
		int cart_total = getTotalPrice();

		for (Map.Entry<Integer, Item> itemPair : items.entrySet()) {
			Item item = itemPair.getValue();
			itemizedList += (item.getItemInfo());
		}

		return itemizedList + "\n Total Amount : Rs. " + (cart_total) + '\n';
	}

	public boolean isEmpty() {
		return items.isEmpty();
	}

}