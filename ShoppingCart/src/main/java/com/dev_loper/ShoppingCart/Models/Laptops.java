package com.dev_loper.ShoppingCart.Models;

public class Laptops extends Type {
	
	private String screenSize;
	private String processor;
	private String ram;
	private String rom;
	private String operatingSystem;
	
	public Laptops(String typeName, String screenSize, String processor, String ram, String rom, String operatingSystem) {
		super(typeName);
		this.screenSize = screenSize;
		this.processor = processor;
		this.ram = ram;
		this.rom = rom;
		this.operatingSystem = operatingSystem;
	}

	public String getScreenSize() {
		return screenSize;
	}

	public void setScreenSize(String screenSize) {
		this.screenSize = screenSize;
	}

	public String getProcessor() {
		return processor;
	}

	public void setProcessor(String processor) {
		this.processor = processor;
	}

	public String getRam() {
		return ram;
	}

	public void setRam(String ram) {
		this.ram = ram;
	}

	public String getRom() {
		return rom;
	}

	public void setRom(String rom) {
		this.rom = rom;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	

}
