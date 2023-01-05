
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class MagicSquare {

    private int[][] square;

    // ready constructor
    public MagicSquare(int size) {
        if (size < 2) {
            size = 2;
        }

        this.square = new int[size][size];
    }

    // implement these three methods
    public ArrayList<Integer> sumsOfRows() {
        ArrayList<Integer> sumOfRows = new ArrayList<>();
        Arrays.stream(this.square)
                .forEach(row -> {
                    // Use streams to sum all values of each row and
                    // add them to the results array
                    sumOfRows.add(Arrays.stream(row)
                            .sum());
                });
        return sumOfRows;
    }

    public ArrayList<Integer> sumsOfColumns() {
        ArrayList<Integer> sumOfColumns = new ArrayList<>();
        // In order to access the columns, we have to take into account
        // the index that each value has inside each row

        // Streams approach:
        // We are working with squares, so columns length shall always be the same
        int columnsLength = this.square[0].length;
//        for (int column = 0; column < columnsLength; column++ ) {
//            int finalColumn = column;
//            sumOfColumns.add(IntStream.range(0, this.square.length)
//                    .map(i -> this.square[i][finalColumn])
//                    .sum()
//            );
//        }
        // Second streams approach: double IntStream
        IntStream.range(0, columnsLength)
                .forEach(column -> {
                    sumOfColumns.add(IntStream.range(0, this.square.length)
                            .map(i -> this.square[i][column])
                            .sum()
                    );
                });

        return sumOfColumns;
    }

    /**
     * Return an array with the sum of the square's diagonals
     * First one is the diagonal starting at (0, 0) and ending at (Z, Z)
     * Second one is the diagonal starting at (Z, 0) and ending at (0, Z)
     * @return An array with the sum of the square's diagonals
     */
    public ArrayList<Integer> sumsOfDiagonals() {
        // Atomic variables are classes specifically designed to be used
        // when concurrency access appears
        AtomicInteger firstDiagonalSum = new AtomicInteger();
        AtomicInteger secondDiagonalSum = new AtomicInteger();
        ArrayList<Integer> sumOfDiagonals = new ArrayList<>();

        IntStream.range(0, this.square.length)
                .forEach(x -> {
                    // Define the second coordinate
                    int y = this.square.length - x - 1;
                    firstDiagonalSum.addAndGet(this.square[x][x]);
                    secondDiagonalSum.addAndGet(this.square[y][x]);
                });
        // Save the results
        sumOfDiagonals.add(firstDiagonalSum.get());
        sumOfDiagonals.add(secondDiagonalSum.get());
        return sumOfDiagonals;
    }

    // ready-made helper methods -- don't touch these
    public boolean isMagicSquare() {
        return sumsAreSame() && allNumbersDifferent();
    }

    public ArrayList<Integer> giveAllNumbers() {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                numbers.add(square[row][col]);
            }
        }

        return numbers;
    }

    public boolean allNumbersDifferent() {
        ArrayList<Integer> numbers = giveAllNumbers();

        Collections.sort(numbers);
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i - 1) == numbers.get(i)) {
                return false;
            }
        }

        return true;
    }

    public boolean sumsAreSame() {
        ArrayList<Integer> sums = new ArrayList<>();
        sums.addAll(sumsOfRows());
        sums.addAll(sumsOfColumns());
        sums.addAll(sumsOfDiagonals());

        if (sums.size() < 3) {
            return false;
        }

        for (int i = 1; i < sums.size(); i++) {
            if (sums.get(i - 1) != sums.get(i)) {
                return false;
            }
        }

        return true;
    }

    public int readValue(int x, int y) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return - 1;
        }

        return this.square[y][x];
    }

    public void placeValue(int x, int y, int value) {
        if (x < 0 || y < 0 || x >= getWidth() || y >= getHeight()) {
            return;
        }

        this.square[y][x] = value;
    }

    public int getWidth() {
        return this.square.length;
    }

    public int getHeight() {
        return this.square.length;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int row = 0; row < square.length; row++) {
            for (int col = 0; col < square[row].length; col++) {
                result.append(square[row][col]).append("\t");
            }

            result.append("\n");
        }

        return result.toString();
    }
}
