package com.dev_loper.ShoppingCart.Models;

public class Smartphones extends Type {

	private String screenSize;
	private String processor;
	private String ram;
	private String rom;
	private String camera;

	public Smartphones(String typeName, String screenSize, String processor, String ram, String rom, String camera) {
		super(typeName);
		this.screenSize = screenSize;
		this.processor = processor;
		this.ram = ram;
		this.rom = rom;
		this.camera = camera;
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

	public String getCamera() {
		return camera;
	}

	public void setCamera(String camera) {
		this.camera = camera;
	}

}
