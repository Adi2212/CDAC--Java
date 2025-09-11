/*
 * Accept DoB of employee from user, store it in Date class instance
 * 
 *  Display the same.
 * 
 */
package date_handling;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in)) {
			System.out.println("Enter Emp's DoB ");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			Date date=sdf.parse(sc.nextLine());
			
			System.out.println(date);
			
			System.out.println(sdf.format(date));
		} //JVM - sc.close()
		catch(Exception e){
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
