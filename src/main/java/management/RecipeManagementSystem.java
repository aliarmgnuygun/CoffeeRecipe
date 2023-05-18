package management;

import models.CoffeeRecipe;

import java.util.ArrayList;
import java.util.List;

public class RecipeManagementSystem {
    private List<CoffeeRecipe> recipeList;

    public RecipeManagementSystem() {
        recipeList = new ArrayList<>();
    }

    public void saveRecipe(CoffeeRecipe coffeeRecipe) {
        recipeList.add(coffeeRecipe);
    }

    public List<CoffeeRecipe> searchRecipes(String keyword) {
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
}
