//4.0 Accept 5 doubles from user (scanner) Print it's average.
import java.util.Scanner;
class PrintAvg{
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        double sum=0;
        for(int i=1;i<=5;i++){
            System.out.println("Enter number "+i+":");
            sum=sum+sc.nextDouble();;
        }
        double avg=sum/5;
        System.out.println("Average is: "+avg);
    }
}