import creators.CoffeeRecipeCreator;
import models.CoffeeRecipe;
import strategies.SearchByCategoryStrategy;
import strategies.SearchByIngredientsStrategy;
import strategies.SearchByTagsStrategy;
import strategies.SearchStrategy;

import java.util.Arrays;
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
                    modifyRecipes(scanner,recipeManagementSystem);
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
                System.out.println("Invalid strategy choice. Using default strategy: By Ingredients.");
                strategy = new SearchByIngredientsStrategy(); // Set default strategy
                break;
        }

        System.out.print("Enter search keyword: ");
        String keyword = scanner.nextLine();

        List<CoffeeRecipe> searchResults = recipeManagementSystem.searchRecipes(keyword, strategy);

        if (searchResults.isEmpty()) {
            System.out.println("No recipes found matching the search keyword.\n");
        } else {
            System.out.println("\nSearch Results:");
            for (CoffeeRecipe recipe : searchResults) {
                System.out.println("Recipe Name: " + recipe.getName());
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

    private static void modifyRecipes(Scanner scanner, RecipeManagementSystem recipeManagementSystem) {
        System.out.println("\n----- Modify Recipe -----");

        System.out.print("Enter the recipe name: ");
        String recipeName = scanner.nextLine();

        CoffeeRecipe selectedRecipe = recipeManagementSystem.getRecipeByName(recipeName);

        System.out.println("1. Ingredients");
        System.out.println("2. Brewing Instructions");
        System.out.println("3. Categories");
        System.out.println("4. Tags");
        System.out.println("Which field do you want to modify? : ");

        int fieldChoice = scanner.nextInt();
        scanner.nextLine();

        switch (fieldChoice) {
            case 1:
                recipeManagementSystem.modifyIngredients(scanner, selectedRecipe);
                break;
            case 2:
                recipeManagementSystem.modifyBrewingInstructions(scanner, selectedRecipe);
                break;
            case 3:
                recipeManagementSystem.modifyCategories(scanner, selectedRecipe);
                break;
            case 4:
                recipeManagementSystem.modifyTags(scanner, selectedRecipe);
                break;
            default:
                System.out.println("Invalid choice. Please try again.\n");
                break;
        }
    }
}


