
public class MainProgram {

    public static void main(String[] args) {
        // write your test code here
        int[] array = {3, 1, 5, 99, 3, 12};
        System.out.println("Smallest: " + MainProgram.smallest(array));
        System.out.println("Index of the smallest number: " + MainProgram.indexOfSmallest(array));
        System.out.println("Index of the smallest number from 2: " + MainProgram.indexOfSmallestFrom(array, 2));

        MainProgram.sort(array);
    }

    public static int smallest(int[] array) {
        int smallestFound = array[0];
        for (int number : array) {
            if (number < smallestFound) {
                smallestFound = number;
            }
        }

        return smallestFound;
    }

    public static int indexOfSmallest(int[] array) {
        int smallestFound = array[0];
        int smallestIndex = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] < smallestFound) {
                smallestFound = array[i];
                smallestIndex = i;
            }
        }

        return smallestIndex;
    }

    public static int indexOfSmallestFrom(int[] table, int startIndex) {
        if (startIndex >= 0 && startIndex < table.length) {
            int smallestFound = table[startIndex];
            int smallestIndex = startIndex;
            for (int i = startIndex; i < table.length; i++) {
                if (table[i] < smallestFound) {
                    smallestFound = table[i];
                    smallestIndex = i;
                }
            }

            return smallestIndex;
        }
        return -1;
    }

    public static void swap(int[] array, int index1, int index2) {
        if (index1 >= 0 && index1 < array.length && index1 >= 0 && index2 < array.length && index1 != index2) {
            int aux = array[index1];
            array[index1] = array[index2];
            array[index2] = aux;
        }
    }

    public static String printArray(int[] array) {
        String arrayString = "[";
        for (int i = 0; i < array.length; i++) {
            arrayString += array[i];
            if (i < array.length - 1) {
                arrayString += ", ";
            } else {
                arrayString += "]";
            }
        }

        return arrayString;
    }

    /**
     * Sort the given array in ascending order
     */
    public static void sort(int[] array) {
        System.out.println(MainProgram.printArray(array));
        for (int i = 0; i < array.length; i++) {
            // Examine the sub-arrays starting from the current index and search the index of the smallest value
            int smallestFrom = MainProgram.indexOfSmallestFrom(array, i);
            if (smallestFrom != i) {
                MainProgram.swap(array, i, smallestFrom);
            }
            System.out.println(MainProgram.printArray(array));
        }
    }
}
