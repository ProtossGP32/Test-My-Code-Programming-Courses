import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeBook {
    private ArrayList<Recipe> recipes;

    public RecipeBook() {
        this.recipes = new ArrayList<>();
    }

    public void add(Recipe newRecipe) {
        this.recipes.add(newRecipe);
    }

    public ArrayList<Recipe> getRecipes() {
        return recipes;
    }

    public void readRecipes(String filename) {
        try (Scanner recipesScanner = new Scanner(Paths.get(filename))) {
            String recipeName = "";
            int cookingTime = 0;
            ArrayList<String> ingredients = new ArrayList<>();
            while (recipesScanner.hasNextLine()) {
                // Don't use the recipesScanner.hasNextLine() as condition for the while as we need to create a recipe
                // when reading the last line
                String line = recipesScanner.nextLine();

                if (!line.isEmpty()) {
                    // Read recipe info
                    // First line - name
                    // Second line - cooking time
                    // Third line until empty line - ingredients
                    if (recipeName.isEmpty()) {
                        // We are at the start of the recipe reading
                        recipeName = line;
                    } else if (cookingTime == 0) {
                        cookingTime = Integer.parseInt(line);
                    } else {
                        ingredients.add(line);
                    }
                }
                // Check if we are at the end of a recipe or the file. Both conditions save the recipe
                if (line.isEmpty() || !recipesScanner.hasNextLine()) {
                    // Current recipe has ended
                    // Include current recipe to the recipesBook only if all values are initialized
                    if (!recipeName.isEmpty() && cookingTime != 0 && !ingredients.isEmpty()) {
                        this.add(new Recipe(recipeName, cookingTime, ingredients));
                    }
                    // Restart the values
                    recipeName = "";
                    cookingTime = 0;
                    ingredients = new ArrayList<>();
                }
            }
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }

    public void listRecipes() {
        System.out.println("Recipes:");
        for (Recipe recipe : this.recipes) {
            System.out.println(recipe);
        }
    }

    public void findRecipes(String word) {
        System.out.println("Recipes:");
        for (Recipe recipe : this.recipes) {
            if (recipe.getName().contains(word)) {
                System.out.println(recipe);
            }
        }
    }

    public void findRecipesByCookingTime(int maxCookingTime) {
        System.out.println("Recipes:");
        for (Recipe recipe : this.recipes) {
            if (recipe.getCookingTime() <= maxCookingTime) {
                System.out.println(recipe);
            }
        }
    }

    public void findRecipesByIngredient(String ingredient) {
        System.out.println("Recipes:");
        for (Recipe recipe : this.recipes) {
            if (recipe.containsIngredient(ingredient)) {
                System.out.println(recipe);
            }
        }
    }

    public void listCommands() {
        System.out.println("Commands:");
        System.out.println("list - lists the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking time");
        System.out.println("find ingredient - searches recipes by ingredient");
        System.out.println();
    }
}
