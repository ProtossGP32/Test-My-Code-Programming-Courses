
import java.util.Scanner;

public class RecipeSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeBook recipeBook = new RecipeBook();

        // Part 1: Reading recipes
        System.out.print("File to read: ");
        String file = scanner.nextLine();
        System.out.printsln();
        recipeBook.readRecipes(file);

        // Show commands
        recipeBook.listCommands();

        label:
        while (true) {
            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            switch (command) {
                case "stop":
                    break label;
                case "list":
                    // Part 1: List the available recipes
                    System.out.println();
                    recipeBook.listRecipes();

                    break;
                case "find name":
                    // Part 2: Find recipes by name
                    System.out.print("Searched word: ");
                    String word = scanner.nextLine();
                    System.out.println();
                    recipeBook.findRecipes(word);

                    break;
                case "find cooking time":
                    // Part 3: Find recipes by cooking time
                    System.out.print("Max cooking time: ");
                    int maxCookingTime = Integer.parseInt(scanner.nextLine());
                    System.out.println();
                    recipeBook.findRecipesByCookingTime(maxCookingTime);

                    break;
                case "find ingredient":
                    // Part 4: Find recipes by ingredient
                    System.out.print("Ingredient: ");
                    String ingredient = scanner.nextLine();
                    System.out.println();
                    recipeBook.findRecipesByIngredient(ingredient);
                    break;

                default:
                    System.out.println("Unknown command");
                    break;
            }
            System.out.println();
        }
    }

}
