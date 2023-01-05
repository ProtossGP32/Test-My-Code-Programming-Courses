import java.util.Arrays;

public class Program {

    public static void main(String[] args) {
        // Test your method here
        int rows = 2;
        int columns = 3;
        int[][] matrix = new int[rows][columns];
        matrix[0][1] = 5;
        matrix[1][0] = 3;
        matrix[1][2] = 7;
        System.out.println(arrayAsString(matrix));

        // Matrix test
        int[][] matrix2 = {
                {3, 2, 7, 6},
                {2, 4, 1, 0},
                {3, 2, 1, 0}
        };

        System.out.println(arrayAsString(matrix2));
    }

    public static String arrayAsString(int[][] array) {
        // Initialize a StringBuilder
        StringBuilder stringBuilder = new StringBuilder();
        // Use Arrays.stream to traverse all values
        Arrays.stream(array)
            .forEach(row -> {
                Arrays.stream(row)
                    .forEach(value -> {
                        stringBuilder.append(value);
                    });
                stringBuilder.append("\n");
        });

        return stringBuilder.toString();
    }

}
