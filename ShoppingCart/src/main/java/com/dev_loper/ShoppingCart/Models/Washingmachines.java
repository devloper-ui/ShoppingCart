package com.dev_loper.ShoppingCart.Models;

public class Washingmachines extends Type {

	private String modelName;
	private String functionType;
	private String energyRating;
	private String washingCapacity;
	private String washingMethod;
	private String maxSpinSpeed;
	
	public Washingmachines(String typeName, String modelName, String functionType, String energyRating,
			String washingCapacity, String washingMethod, String maxSpinSpeed) {
		super(typeName);
		this.modelName = modelName;
		this.functionType = functionType;
		this.energyRating = energyRating;
		this.washingCapacity = washingCapacity;
		this.washingMethod = washingMethod;
		this.maxSpinSpeed = maxSpinSpeed;
	}

	public String getModelName() {
		return modelName;
	}

	public void setModelName(String modelName) {
		this.modelName = modelName;
	}

	public String getFunctionType() {
		return functionType;
	}

	public void setFunctionType(String functionType) {
		this.functionType = functionType;
	}

	public String getEnergyRating() {
		return energyRating;
	}

	public void setEnergyRating(String energyRating) {
		this.energyRating = energyRating;
	}

	public String getWashingCapacity() {
		return washingCapacity;
	}

	public void setWashingCapacity(String washingCapacity) {
		this.washingCapacity = washingCapacity;
	}

	public String getWashingMethod() {
		return washingMethod;
	}

	public void setWashingMethod(String washingMethod) {
		this.washingMethod = washingMethod;
	}

	public String getMaxSpinSpeed() {
		return maxSpinSpeed;
	}

	public void setMaxSpinSpeed(String maxSpinSpeed) {
		this.maxSpinSpeed = maxSpinSpeed;
	}
		
}
