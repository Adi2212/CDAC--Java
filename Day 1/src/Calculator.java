// Write Java program for the following - 
// It should  run till user enters any other option than add or sub or multiply or divide
// Prompt user to enter the input operation : (add|subtract|multiply|divide) & 2 numbers(double)
// Display the result of the operation.
// Use Scanner for accepting all inputs from user. 
import java.util.Scanner;
class Calculator{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        boolean flag=false;
        while(!flag){
            System.out.println("Enter operation (add|subtract|multiply|divide) or any other key to exit:");
            String operation=sc.next();
            switch (operation) {
                case "add":
                System.out.println("Enter two numbers:");
                System.out.println("Result:"+(sc.nextDouble()+sc.nextDouble()));
                    break;

                case "subtract":
                System.out.println("Enter two numbers:");
                System.out.println("Result:"+(sc.nextDouble()-sc.nextDouble()));
                    break;
                
                case "multiply":
                System.out.println("Enter two numbers:");
                System.out.println("Result:"+(sc.nextDouble()*sc.nextDouble()));
                    break;

                case "divide":
                System.out.println("Enter two numbers:");
                System.out.println("Result:"+(sc.nextDouble()/sc.nextDouble()));
                    break;

                default:
                flag=true;
                System.out.println("Exiting the calculator. Goodbye!");
                    break;
            }
        }
    }
}