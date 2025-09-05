//4.1 Write Java program - 
// Display food menu to user. User will select items from menu along with the quantity. (eg 1. Dosa 2. Samosa 3. Idli ... 0 . Generate Bill ) Assign fixed prices to food items(hard code the prices)
// When user enters 'Generate Bill' option(0) , display total bill & exit.
import java.util.Scanner;
class GenerateBill{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        double totalBill=0;
          System.out.printf("Menu:\n 1. Dosa - rs 50\n 2. Samosa - rs20\n 3. Idli - rs. 30\n 0. Generate Bill\n");
          
        while(true){
            System.out.println("Enter your choice:");
            int choice=sc.nextInt();
            if(choice==0){
                break;
            }
            System.out.println("Enter quantity:");
            int quantity=sc.nextInt();
            switch(choice){
                case 1:
                    totalBill+=50*quantity;
                    break;
                case 2:
                    totalBill+=20*quantity;
                    break;
                case 3:
                    totalBill+=30*quantity;
                    break;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
        System.out.println("Total Bill is: "+totalBill);
    }
}
