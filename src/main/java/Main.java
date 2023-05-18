import creators.CoffeeRecipeCreator;
import management.RecipeManagementSystem;
import models.CoffeeRecipe;
import strategies.SearchByCategoryStrategy;
import strategies.SearchByIngredientsStrategy;
import strategies.SearchByTagsStrategy;
import strategies.SearchStrategy;

import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipeManagementSystem recipeManagementSystem = new RecipeManagementSystem();

        while (true) {
            System.out.println("------------- Main Menu -------------");
            System.out.println("1. Create Coffee Recipe");
            System.out.println("2. Search Recipes");
            System.out.println("3. Rate Recipe");
            System.out.println("4. Modify Recipe");
            System.out.println("0. Exit");
            System.out.println("-------------------------------------");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    createCoffeeRecipe(scanner, recipeManagementSystem);
                    break;
                case 2:
                    searchRecipes(scanner, recipeManagementSystem);
                    break;
                case 3:
                    // Implement rate recipe functionality
                    break;
                case 4:
                    // Implement modify recipe functionality
                    break;
                case 0:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
                    break;
            }
        }
    }

    private static void createCoffeeRecipe(Scanner scanner, RecipeManagementSystem recipeManagementSystem) {
        System.out.println("\n----- Create Coffee Recipe -----");

        CoffeeRecipeCreator coffeeRecipeCreator = new CoffeeRecipeCreator(scanner);
        CoffeeRecipe coffeeRecipe = coffeeRecipeCreator.createCoffeeRecipe();

        recipeManagementSystem.saveRecipe(coffeeRecipe);

        System.out.println("Coffee Recipe created and saved successfully!\n");
    }

    private static void searchRecipes(Scanner scanner, RecipeManagementSystem recipeManagementSystem) {
        System.out.println("\n----- Search Recipes -----");

        System.out.println("Choose search strategy:");
        System.out.println("1. By Ingredients");
        System.out.println("2. By Category");
        System.out.println("3. By Tags");
        System.out.print("Enter your choice: ");

        int strategyChoice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        SearchStrategy strategy;
        switch (strategyChoice) {
            case 1:
                strategy = new SearchByIngredientsStrategy();
                break;
            case 2:
                strategy = new SearchByCategoryStrategy();
                break;
            case 3:
                strategy = new SearchByTagsStrategy();
                break;
            default:
                System.out.println("Invalid strategy choice.");
                return;
        }

        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();

        List<CoffeeRecipe> searchResults = recipeManagementSystem.searchRecipes(keyword, strategy);

        if (searchResults.isEmpty()) {
            System.out.println("No recipes found matching the search keyword.\n");
        } else {
            System.out.println("\nSearch Results:");
            for (CoffeeRecipe recipe : searchResults) {
                System.out.println("Ingredients: " + recipe.getIngredients());
                System.out.println("Brewing Instructions: " + recipe.getBrewingInstructions());
                System.out.println("Serving Size: " + recipe.getServingSize());
                System.out.println("Categories: " + recipe.getCategories());
                System.out.println("Tags: " + recipe.getTags());
                System.out.println("Impact: " + recipe.getImpact());
                System.out.println("--------------------");
            }
        }
    }

}


