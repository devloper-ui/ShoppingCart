/**
 * Add, Remove, Update, Delete Products. For "Seller".
 */
package com.dev_loper.ShoppingCart.Services;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.dev_loper.ShoppingCart.Models.Product;
import com.dev_loper.ShoppingCart.Models.Smartphones;
import com.dev_loper.ShoppingCart.Models.Tshirts;
import com.dev_loper.ShoppingCart.Models.Washingmachines;

@Component
public class ProductService {
	private static List<Product> products = new ArrayList<Product>();
//how to get class name in typename
	static {
		// id,name,type,category,price
		products.add(new Product(1, "Redmi k10", new Smartphones("Smartphones", "6.5 inches", "sanpdragon 680", "4 GB","32 GB", "64MP + 2MP"), "Electronics", 10000L));
		products.add(new Product(2, "Levis winter ware", new Tshirts("Tshirts", "red", "XL"), "Clothing", 3500L));
		products.add(new Product(3, "LG P300", new Washingmachines("Washingmachine", "P300", "cross-functional", "4 stars", "6kg", "Normal spin", "800rpm"), "Electronics", 18000L));
		products.add(new Product(4, "Redmi k10 plus", new Smartphones("Smartphones", "6.5 inches", "MediaTek helio G90",  "4 GB","64 GB", "64MP + 2MP"), "Electronics", 12000L));
		products.add(new Product(5, "Realme 9 pro plus", new Smartphones("Smartphones", "6.5 inches", "sanpdragon 778G",  "4 GB","32 GB", "64MP + 12MP + 2MP"), "Electronics", 25000L));
	}

	public List<Product> getAllProducts() {
		return products;
	}

	public Product getProductById(int id) {
		Product product = null;
		try {
			product = products.stream().filter(prod -> prod.getId() == id).findFirst().orElse(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;

	}

	public Product addProduct(Product product) {
		products.add(product);
		return product;
	}

	public void removeProductById(int id) {
		try {
			products = products.stream().filter(prod -> prod.getId() != id).collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Exception in removeProductById method of Cart class" + e);
		}
	}

	public Product updateProduct(Product product, int id) {
		try {
			products = products.stream().map(p -> {
				if (p.getId() == id) {
					p.setName(product.getName());
					p.setCategory(product.getCategory());
					p.setType(product.getType());
					p.setPrice(product.getPrice());
				}
				return p;
			}).collect(Collectors.toList());
		} catch (Exception e) {
			System.out.println("Exception in getProductById method of Cart class" + e);
		}

		return product;
	}
//	public long getTotalPrice(List<Product> products) {
//		long totalPrice = 0;
//		for(Product product : products) {
//			totalPrice += product.getPrice();
//		}
//		return totalPrice;
//	}

	public List<Product> searchByCategory(String[] keys) {
		List<Product> listOfCateogory = new ArrayList<Product>();
		List<Product> listOfType = new ArrayList<Product>();
		List<Product> listOfName = new ArrayList<Product>();
		List<Product> listByPrice = new ArrayList<Product>();
		long min = 0, max = 0;
		if (!keys[0].equals(""))
			for (Product product : products) {
//			if(product.getType().equals(type)) {
//				System.out.println(product);
//				list.add(product);
//			}
				Pattern pattern = Pattern.compile(keys[0].toLowerCase());
				Matcher match = pattern.matcher(product.getCategory().toLowerCase());
				if (match.find()) {
					listOfCateogory.add(product);
				}
			}
		if (!keys[1].equals("")) {
			for (Product product : products) {
				Pattern pattern = Pattern.compile(keys[1].toLowerCase());
				Matcher match = pattern.matcher(product.getType().getTypeName().toLowerCase());
				if (match.find()) {
					listOfType.add(product);
				}

			}
			return listOfType;
		}
		if (!keys[2].equals("")) {
			for (Product product : products) {
				Pattern pattern = Pattern.compile(keys[2].toLowerCase());
				Matcher match = pattern.matcher(product.getName().toLowerCase());
				if (match.find()) {
					listOfName.add(product);
				}

			}
			return listOfName;
		}
		if (!keys[4].equals("")) {
			if (!keys[3].equals(""))
				min = Long.parseLong(keys[3]);
			max = Long.parseLong(keys[4]);
			for (Product product : products) {
				if (product.getPrice() >= min && product.getPrice() <= max)
					listByPrice.add(product);
			}
			return listByPrice;
		}
		return listOfCateogory;
	}

}
