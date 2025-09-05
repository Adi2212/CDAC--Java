import java.util.Scanner;
class TestPoint {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter x & y cordinate for point 1:");
        Point2D p1 = new Point2D(sc.nextInt(), sc.nextInt());
        System.out.println("point 1 coordinate :"+p1.show());

        System.out.println("Enter x & y cordinate for point 2:");
        Point2D p2 = new Point2D(sc.nextInt(), sc.nextInt());
        System.out.println("point 1 coordinate :"+p1.show());

        System.out.println("comparing points...");
        if(p1.isEqual(p2)){
            System.out.println("Both points have same coordinates..");
        }
        else
        System.out.println("Both point having different coordinate.");
        System.out.println("the distance between points is: "+p1.calculateDistance(p2));

        sc.close(); 
    }
}
