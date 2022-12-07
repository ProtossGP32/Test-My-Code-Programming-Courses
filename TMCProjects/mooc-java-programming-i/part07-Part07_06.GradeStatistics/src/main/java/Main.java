
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Grade grade = new Grade();

        // Write your program here -- consider breaking the program into 
        // multiple classes.
        System.out.println("Enter point totals, -1 stops:");
        while (true) {
            int points = Integer.parseInt(scanner.nextLine());
            if (points == -1) {
                break;
            }
            grade.addPoints(points);
        }
        // Part 1: Point averages
        System.out.println("Point average (all): " + grade.averagePoints());

        // Part 2: Point average for points giving a passing grade
        double averagePassingPoints = grade.averagePassingPoints();
        String avgString;
        if (averagePassingPoints <= 0) {
            avgString = "-";
        } else {
            avgString = String.valueOf(averagePassingPoints);
        }
        System.out.println("Point average (passing): " + avgString);

        // Part 3: Pass percentage
        System.out.println("Pass percentage: " + grade.passPercentage());

        // Pass 4: Grade distribution
        System.out.println("Grade distribution:");
        System.out.println(grade.gradeDistribution());

    }
}
