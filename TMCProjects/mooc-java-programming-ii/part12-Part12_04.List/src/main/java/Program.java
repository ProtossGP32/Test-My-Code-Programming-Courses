
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your class here
        List<String> myList = new List<>();
        System.out.println("myList: " + myList);
        System.out.println("myList size: " + myList.size());
        System.out.println("myList first free index: " + myList.getFirstFreeIndex());
        System.out.println("myList contains \"hello\"? " + myList.contains("hello"));
        System.out.println();

        System.out.println("Adding \"hello\" to list...");
        myList.add("hello");
        System.out.println("myList: " + myList);
        System.out.println("myList size: " + myList.size());
        System.out.println("myList first free index: " + myList.getFirstFreeIndex());
        System.out.println();

        System.out.println("Adding \"world\" to list...");
        myList.add("world");
        System.out.println("myList contains \"hello\"? " + myList.contains("hello"));
        System.out.println("myList: " + myList);
        System.out.println("myList size: " + myList.size());
        System.out.println("myList first free index: " + myList.getFirstFreeIndex());
        System.out.println();
        System.out.println("Removing \"hello\" from list...");
        myList.remove("hello");
        System.out.println("myList contains \"hello\"? " + myList.contains("hello"));
        System.out.println("myList: " + myList);
        System.out.println("myList size: " + myList.size());
        System.out.println("myList first free index: " + myList.getFirstFreeIndex());
        System.out.println();

        System.out.println("Adding \"goodbye\" to list...");
        myList.add("goodbye");
        System.out.println("myList: " + myList);
        System.out.println("myList first free index: " + myList.getFirstFreeIndex());
        System.out.println("myList size: " + myList.size());
        System.out.println();


    }

}
