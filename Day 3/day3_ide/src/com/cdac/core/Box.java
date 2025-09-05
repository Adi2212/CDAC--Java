package com.cdac.core;

public class Box {
//state (non static data member : instance vars) - tight encapsulation
	private double width;
	private double depth;
	private double height;

	// parameterized constructor to init complete state
	public Box(double w, double d, double height) {
		this.width = w;
		this.depth = d;
		this.height = height;// this : keyword mandatory
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getDepth() {
		return depth;
	}

	public void setDepth(double depth) {
		this.depth = depth;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	// add overloaded ctor to create a cube
	public Box(double side) {
		// this.width=depth=height=side;
		/*
		 * Instead of repeating the same code , invoke another ctor of the same class -
		 * this keyword
		 */
		this(side, side, side);// calls the 1st ctor.
	}

	// add overloaded ctor to create a dummy box
	public Box() {
		this(-1);// invokes 2nd ctor
	}

	// add instance method to return box dimensions in string form
	public String getBoxDimensions() {
		return "Box dims are " + this.width + " " + this.depth + " " + this.height;
	}

	// add instance method to return box volume
	public double getVolume() {
		return this.width * this.depth * this.height;
	}

}