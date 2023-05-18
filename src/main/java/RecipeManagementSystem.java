import models.CoffeeRecipe;
import strategies.SearchStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RecipeManagementSystem {
    private List<CoffeeRecipe> recipeList;
    private RecipeModifier recipeModifier;

    public RecipeManagementSystem() {
        recipeList = new ArrayList<>();

    }

    public void saveRecipe(CoffeeRecipe coffeeRecipe) {
        recipeList.add(coffeeRecipe);
    }

    public List<CoffeeRecipe> searchRecipes(String keyword, SearchStrategy strategy) {
        List<CoffeeRecipe> searchResults = new ArrayList<>();

        for (CoffeeRecipe recipe : recipeList) {
            if (recipe.getIngredients().contains(keyword) ||
                    recipe.getBrewingInstructions().contains(keyword) ||
                    recipe.getCategories().contains(keyword) ||
                    recipe.getTags().contains(keyword)) {
                searchResults.add(recipe);
            }
        }

        return searchResults;
    }

    public CoffeeRecipe getRecipeByName(String recipeName) {
        for (CoffeeRecipe recipe : recipeList) {
            if (recipe.getName().equalsIgnoreCase(recipeName)) {
                return recipe;
            }
        }
        return null; // Recipe not found
    }

    public void modifyIngredients(Scanner scanner, CoffeeRecipe recipe) {

        List<String> existingIngredients = recipe.getIngredients();

        System.out.println("Do you want to add or remove ingredients?");
        System.out.println("1. Add");
        System.out.println("2. Remove");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character


        if (choice == 1) {
            System.out.println("Enter the new ingredients (one ingredient per line, empty line to finish):");

            String ingredient = scanner.nextLine();
            while (!ingredient.isEmpty()) {
                existingIngredients.add(ingredient);
                ingredient = scanner.nextLine();
            }

            System.out.println("Ingredients modified successfully!\n");
        } else if (choice == 2) {
            System.out.println("Enter the ingredients to remove (one ingredient per line, empty line to finish):");

            String ingredient = scanner.nextLine();
            while (!ingredient.isEmpty()) {
                existingIngredients.remove(ingredient);
                ingredient = scanner.nextLine();
            }

            System.out.println("Ingredients modified successfully!\n");
        } else {
            System.out.println("Invalid choice. Please enter '1' or '2'.\n");
        }
    }
    public void modifyTags(Scanner scanner, CoffeeRecipe recipe) {
        List<String> existingTags = recipe.getTags();

        System.out.println("Do you want to add or remove tags?");
        System.out.println("1. Add");
        System.out.println("2. Remove");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Enter up to three new tags (one tag per line, empty line to finish):");

            String tag = scanner.nextLine();
            while (!tag.isEmpty() && existingTags.size() < 3) {
                existingTags.add(tag);
                tag = scanner.nextLine();
            }

            System.out.println("Tags modified successfully!\n");
        } else if (choice == 2) {
            System.out.println("Enter the tags to remove (one tag per line, empty line to finish):");

            String tag = scanner.nextLine();
            while (!tag.isEmpty()) {
                existingTags.remove(tag);
                tag = scanner.nextLine();
            }

            System.out.println("Tags modified successfully!\n");
        } else {
            System.out.println("Invalid choice. Please enter '1' or '2'.\n");
        }
    }

    public void modifyBrewingInstructions(Scanner scanner, CoffeeRecipe recipe) {
        System.out.println("Enter the new brewing instructions:");
        String modifiedInstructions = scanner.nextLine();

        recipe.setBrewingInstructions(modifiedInstructions);
        System.out.println("Brewing instructions modified successfully!\n");
    }

    public void modifyCategories(Scanner scanner, CoffeeRecipe recipe) {
        List<String> existingCategories = recipe.getCategories();

        System.out.println("Do you want to add or remove categories?");
        System.out.println("1. Add");
        System.out.println("2. Remove");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == 1) {
            System.out.println("Enter up to three new categories (one category per line, empty line to finish):");

            String category = scanner.nextLine();
            while (!category.isEmpty() && existingCategories.size() < 3) {
                existingCategories.add(category);
                category = scanner.nextLine();
            }

            System.out.println("Categories modified successfully!\n");
        } else if (choice == 2) {
            System.out.println("Enter the categories to remove (one category per line, empty line to finish):");

            String category = scanner.nextLine();
            while (!category.isEmpty()) {
                existingCategories.remove(category);
                category = scanner.nextLine();
            }

            System.out.println("Categories modified successfully!\n");
        } else {
            System.out.println("Invalid choice. Please enter '1' or '2'.\n");
        }
    }
}
