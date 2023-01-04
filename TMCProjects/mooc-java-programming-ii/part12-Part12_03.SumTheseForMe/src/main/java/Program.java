
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your method here
        int[] numbers = {3, -1, 8, 4};

        System.out.println(sum(numbers, 0, 0, 0, 0));       // Expected: 0
        System.out.println(sum(numbers, 0, 0, 0, 10));      // Expected: 0
        System.out.println(sum(numbers, 0, 1, 0, 10));      // Expected: 3
        System.out.println(sum(numbers, 0, 1, -10, 10));    // Expected: 3
        System.out.println(sum(numbers, -1, 999, -10, 10)); // Expected: 14

    }

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {
        // Only applicable if array is not empty
        // toWhere value defines the first excluded index, it isn't used in the sum
        int sum = 0;
        if (array.length > 0) {
            // Fix the lower and upper limits
            fromWhere = Math.max(0, fromWhere);
            toWhere = Math.min(toWhere, array.length);

            sum = 0;
            for (int i = fromWhere; i < toWhere; i++) {
                if (array[i] >= smallest && array[i] <= largest) {
                    sum += array[i];
                }
            }
        }
        return sum;
    }
}
