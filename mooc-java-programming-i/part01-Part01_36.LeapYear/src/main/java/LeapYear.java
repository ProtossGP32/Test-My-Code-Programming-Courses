
import java.util.Scanner;

public class LeapYear {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String leapYear = "not ";
        System.out.println("Give a year:");
        int year = Integer.parseInt(scan.nextLine());
        // Two options for leap year:
        // First: divisible by 4 but not divisible by 100
        // Second: divisible by 100 and 400
        if ((year % 4 == 0) && (year % 100 != 0) || (year % 100 == 0) && (year % 400 == 0)) {
            leapYear = "";
        }
        System.out.println("The year is " + leapYear + "a leap year.");
    }
}
