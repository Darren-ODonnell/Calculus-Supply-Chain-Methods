import java.util.Scanner;

public class InventoryControl {
    //Demand Annually
    double d = 1800;
    //Order Cost
    double c = 18;
    //Quantity
    double q;
    //Production Rate Annually
    double r;
    //Holding cost per unit annually
    double h = 2;
    //Percentage of holding cost
    double hp = 25;
    //Discount for discount model;
    double discount;
    //h after getting percent
    double hByHp;

    public InventoryControl(){

        //Basic Model
       // basicModel();
        //Discount Model
        discountModel();
        //Gradual Replenishment Model
        //Shortage Model
    }

    private void discountModel() {
        double totalDiscount;
        Scanner scan = new Scanner(System.in);
        //basicModel();
        System.out.println("Input quantity to get discount (q):");
        q = scan.nextDouble();
        scan.nextLine();
        System.out.println("Input discount in %:");
        discount = scan.nextDouble();
        scan.nextLine();
        System.out.println("h: " + h);
        System.out.println("Discount: " + (h = (h) * (100-discount)));
        System.out.println("h: " + h);
        totalDiscount = d * (h * hp / 100);


        System.out.println("h: " + h);
        double hDiscount = (h = h * hp/100);
        double minTC = calculateMinTC(h,q,d,c);

        System.out.println("Total Discount: " + totalDiscount);
        System.out.println("Discounted h: " + hDiscount);
        System.out.println("MinTC: " + minTC);
        System.out.println("Total Annual Cost: " + (minTC - hDiscount));
    }

    public void basicModel(){
        inputData();
        q = calculateEOQ(c,d,h);
        System.out.println("EOQ = " + q);
        System.out.println("MinTC = " + calculateMinTC(h,q,d,c));
    }
    public void inputData(){
        Scanner scan = new Scanner(System.in);

        System.out.println("Input Annual Demand (d): ");
        d = scan.nextDouble();
        scan.nextLine();
        System.out.println("Input Order Cost (c): ");
        c = scan.nextDouble();
        scan.nextLine();
        System.out.println("Input Annual Production Rate (r): ");
        r = scan.nextDouble();
        scan.nextLine();
        System.out.println("Input Quantity ( Q / EOQ ). If not given, enter 0");
        q = scan.nextDouble();
        scan.nextLine();
        System.out.println("Input Annual Holding Cost (h): ");
        h = scan.nextDouble();
        scan.nextLine();
        System.out.println("Input % of Holding Cost");
        hp = scan.nextDouble();
        scan.nextLine();
        h *= (hp/100);

    }
    public double calculateEOQ(double c, double d, double h){
        double answer = 2 * (c) * (d) / (h);
                answer = Math.sqrt(answer);

        return answer;
    }

    public double calculateMinTC(double h, double q, double d, double c){
        double answer = ((h) * (q / 2)) + ((d * c)/q);
        return answer;
    }
    public static void main(String[] args) {
        new InventoryControl();
    }
}
