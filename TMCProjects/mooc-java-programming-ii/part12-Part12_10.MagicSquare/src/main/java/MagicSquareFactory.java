import java.util.stream.IntStream;

public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {
        MagicSquare square = new MagicSquare(size);
        // Only populate a MagicSquare if its size is odd
        if (size % 2 != 0) {
            // Starting point:  (0, size / 2 + 1)
            // Next panel direction: (-1, 1) (Up and right)
            // If index < 0 --> index = size
            // if square[x][y] is already filled --> New position (x-1, y)
            // Initialize the starting point
            int[] coordinates = new int[2];
            coordinates[0] = 0;
            coordinates[1] = (size / 2);
            IntStream.range(1, size * size + 1)
                    .forEach(number -> {
                        //System.out.println("[" + coordinates[0] + ", " + coordinates[1] + "]: " + number);
                        // Assign the value to the current coordinates
                        square.placeValue(coordinates[0], coordinates[1], number);
                        updateNextLocation(coordinates, square);
                    });
        }
        // implement the creation of a magic square with the Siamese method algorithm here
        return square;
    }

    public static void updateNextLocation(int[] currentLocation, MagicSquare square) {
        // Next panel direction: (-1, 1) (Up and right)
        // If x_index < 0       --> x_index = size -1
        // If y_index >= size   --> y_index = 0
        // if square[x-1][y+1] is already filled --> New position (x+1, y)
        //      Here, if x_index >= size --> x_index = 0

        // Initialize direction and next location variables
        int[] moveVector = new int[2];
        moveVector[0] = -1;
        moveVector[1] = 1;
        int[] nextLocation = new int[2];

        // Temporarily check the next location
        for (int idx = 0; idx < nextLocation.length; idx++) {
            nextLocation[idx] = currentLocation[idx] + moveVector[idx];
        }
        // Fix nextLocation if it is out of bounds
        if (nextLocation[0] < 0) {
            nextLocation[0] = square.getHeight() - 1;
        }
        if (nextLocation[1] >= square.getWidth()) {
            nextLocation[1] = 0;
        }

        // Check if the next location has value or not
        while (square.readValue(nextLocation[0], nextLocation[1]) > 0) {
            nextLocation[0] = currentLocation[0] - moveVector[0];
            nextLocation[1] = currentLocation[1];
            // TODO: Check out-of-bounds value in nextLocation[0]
        }
        // Replace the coordinates with the nextLocation
        for (int idx = 0; idx < nextLocation.length; idx++) {
            currentLocation[idx] = nextLocation[idx];
        }
    }

}
