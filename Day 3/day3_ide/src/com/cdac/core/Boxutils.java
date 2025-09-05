package com.cdac.core;

public class Boxutils {
	 public static boolean isEqual(Box box1,Box box2)
	 {
		return box1.getWidth()==box2.getWidth() && box1.getDepth() == box2.getDepth() && box1.getHeight() == box2.getHeight();
	  
	 }

}
