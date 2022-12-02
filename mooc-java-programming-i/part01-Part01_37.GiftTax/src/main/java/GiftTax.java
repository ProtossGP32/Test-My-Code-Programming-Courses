
import java.util.Scanner;

public class GiftTax {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String answer = "No tax!";
        double taxRate = 0.0;
        int minTax = 0;
        int exceedingPart = 0;
        System.out.println("Value of the gift?");
        int gift = Integer.parseInt(scan.nextLine());
        if (gift > 1000000) {
            minTax = 142100;
            taxRate = 0.17;
            exceedingPart = gift - 1000000;
        } else if (gift > 200000) {
            minTax = 22100;
            taxRate = 0.15;
            exceedingPart = gift - 200000;
        } else if (gift > 55000) {
            minTax = 4700;
            taxRate = 0.12;
            exceedingPart = gift - 55000;
        } else if (gift > 25000) {
            minTax = 1700;
            taxRate = 0.10;
            exceedingPart = gift - 25000;
        } else if (gift >= 5000) {
            minTax = 100;
            taxRate = 0.08;
            exceedingPart = gift - 5000;
        }

        if (taxRate > 0.0) {
            double taxValue = minTax + exceedingPart * taxRate;
            answer = "Tax: " + taxValue;
        }
        System.out.println(answer);
    }
}
