package com.cdac.tester;
import java.util.Scanner;

import com.cdac.core.Box;
import com.cdac.core.Boxutils;
class TestBox
{
  public static void main(String[] args) {
  //create scanner class instance to wrap console i/public
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter side of a cube");
  Box cube1=new Box(sc.nextDouble());
  System.out.println("Enter side of a cube");
  Box cube2=new Box(sc.nextDouble());
//  System.out.println(cube.getBoxDimensions());
//  System.out.println(cube.getVolume());
  //to test ctor chaining - create dummy box , where all dims are inited to -1
//  Box dummyBox=new Box();
//  System.out.println(dummyBox.getBoxDimensions());
  System.out.println(Boxutils.isEqual(cube1, cube2)?"box are equal.":"box are differnt size..");
  sc.close();
  }
}