import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        // insert test code here
        int[] array = {3, 1, 5, 99, 3, 12};
        Main.sort(array);
        System.out.println(Arrays.toString(array));

        String[] stringArray = {"a", "z", "b"};
        Main.sort(stringArray);
        System.out.println(Arrays.toString(stringArray));

        ArrayList<Integer> integersArray = new ArrayList<>(Arrays.asList(1, 99, 50));
        Main.sortIntegers(integersArray);
        System.out.println(integersArray);

        ArrayList<String> stringsArray = new ArrayList<>(Arrays.asList("fu", "man", "chu"));
        Main.sortStrings(stringsArray);
        System.out.println(stringsArray);
    }

    public static void sort(int[] array) {
        Arrays.sort(array);
    }

    public static void sort(String[] array) {
        Arrays.sort(array);
    }

    public static void sortIntegers(ArrayList<Integer> integers) {
        Collections.sort(integers);
    }

    public static void sortStrings(ArrayList<String> strings) {
        Collections.sort(strings);
    }

}
