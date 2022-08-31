package com.dev_loper.ShoppingCart.Models;

public class Product {

	private int id;
	private String name;
	private Type type;
	private String category;
	private long price;

	public Product(int id, String name, Type type, String category, long price) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
		this.category = category;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", type=" + type + ", category=" + category + ", price=" + price
				+ "]";
	}

}
