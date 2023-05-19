package creators;

import models.CoffeeRecipe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CoffeeRecipeCreator {
    private Scanner scanner;

    public CoffeeRecipeCreator(Scanner scanner) {
        this.scanner = scanner;
    }

    public CoffeeRecipe createCoffeeRecipe() {
        System.out.print("Enter recipe name: ");
        String name = scanner.nextLine();

        System.out.print("Enter the ingredients (comma-separated): ");
        String[] ingredientsArray = scanner.nextLine().split(",");
        List<String> ingredients = new ArrayList<>();
        for (String ingredient : ingredientsArray) {
            ingredients.add(ingredient.trim());
        }

        System.out.print("Enter the brewing instructions: ");
        String brewingInstructions = scanner.nextLine();

        System.out.print("Enter the serving size: ");
        String servingSize = scanner.nextLine();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter the categories (up to 3, comma-separated): ");
        String[] categoriesArray = scanner.nextLine().split(",");
        List<String> categories = new ArrayList<>();
        for (String category : categoriesArray) {
            categories.add(category.trim());
        }

        System.out.print("Enter the tags (up to 3, comma-separated): ");
        String[] tagsArray = scanner.nextLine().split(",");
        List<String> tags = new ArrayList<>();
        for (String tag : tagsArray) {
            tags.add(tag.trim());
        }

        return new CoffeeRecipe(name,ingredients, brewingInstructions, servingSize, categories, tags);
    }
}
