package com.dev_loper.ShoppingCart.Models;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;

@Component
public class Cart {
	private static List<Product> products = new ArrayList<Product>();
	
	static {
		//                       id,name,type,category,price
		products.add(new Product(1,"Redmi k10","Smartphones","Electronics",10000L));
		products.add(new Product(2,"Levis winter ware","T-shirts","Clothing",3500L));
		products.add(new Product(3,"LG P300","Washing Machine","Electronics",18000L));
		products.add(new Product(4,"Redmi k10 plus","Smartphones","Electronics",12000L));
		products.add(new Product(5,"Realme 9 pro plus","Smartphones","Electronics",25000L));
	}
	
	public List<Product> getAllProducts(){
		return products;
	}
	
	public long getTotalPrice(List<Product> products) {
		long totalPrice = 0;
		for(Product product : products) {
			totalPrice += product.getPrice();
		}
		return totalPrice;
	}
	
	public List<Product> searchByCategory(String[] keys){
		List<Product> listOfCateogory = new ArrayList<Product>();
		List<Product> listOfType = new ArrayList<Product>();
		List<Product> listOfName = new ArrayList<Product>();
		List<Product> listByPrice = new ArrayList<Product>();
		long min = 0, max = 0;
		if(!keys[0].equals(""))
			for(Product product : products) {
//			if(product.getType().equals(type)) {
//				System.out.println(product);
//				list.add(product);
//			}
			 Pattern pattern = Pattern.compile(keys[0].toLowerCase());		        
		     Matcher match = pattern.matcher(product.getCategory().toLowerCase());
		     if(match.find()) {
		    	 listOfCateogory.add(product);
		     }
		}
		if(!keys[1].equals("")) {
			for(Product product : products) {
				 Pattern pattern = Pattern.compile(keys[1].toLowerCase());		        
			     Matcher match = pattern.matcher(product.getType().toLowerCase());
			     if(match.find()) {
			    	 listOfType.add(product);
			     }
			     
			}
			return listOfType;
		}
		if(!keys[2].equals("")) {
			for(Product product : products) {
				 Pattern pattern = Pattern.compile(keys[2].toLowerCase());		        
			     Matcher match = pattern.matcher(product.getName().toLowerCase());
			     if(match.find()) {
			    	 listOfName.add(product);
			     }
			     
			}
			return listOfName;
		}
		if(!keys[4].equals("")) {
		    if(!keys[3].equals(""))min = Long.parseLong(keys[3]);
		    max = Long.parseLong(keys[4]);
			for(Product product : products) {
				if(product.getPrice()>=min && product.getPrice()<=max)
					listByPrice.add(product);
			}
			return listByPrice;
		}
		return listOfCateogory;
	}
	
}
