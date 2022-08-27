package com.dev_loper.ShoppingCart.Models;

public class Item {
	
	private Product product;
	private int quantity;

	public Item(Product p, int q) {
		this.product = p;
		this.quantity = q;
	}	
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public long getItemPrice() {
		return quantity * product.getPrice();
	}

	public String getItemInfo() {
		return (quantity) + " x " + product.getName() + " Rs. " + (quantity * product.getPrice()) + "\n";
	}

}