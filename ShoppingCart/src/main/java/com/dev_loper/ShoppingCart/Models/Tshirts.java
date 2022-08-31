package com.dev_loper.ShoppingCart.Models;

public class Tshirts extends Type {

	private String color;
	private String size;

	public Tshirts(String typeName, String color, String size) {
		super(typeName);
		this.color = color;
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
