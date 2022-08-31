package com.dev_loper.ShoppingCart.Models;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonSubTypes;

@JsonTypeInfo (use = JsonTypeInfo.Id.NAME, include = As.PROPERTY, property = "typeName", visible=true)
//picking up typename as a name for object to be created like smartphones, laptop etc;
@JsonSubTypes ({@JsonSubTypes.Type (value = Smartphones.class, name = "Smartphones"), @JsonSubTypes.Type (value = Tshirts.class, name = "Tshirts"), @JsonSubTypes.Type (value = Washingmachines.class, name = "Washingmachines")})
//name must be an exact match of child class names.
public class Type {
	
	String typeName;
	
	public Type(String typeName) {
		this.typeName = typeName;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}	
	
}