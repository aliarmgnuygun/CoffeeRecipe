package strategies;

import models.CoffeeRecipe;

import java.util.ArrayList;
import java.util.List;

public class SearchByCategoryStrategy implements SearchStrategy {
    @Override
    public List<CoffeeRecipe> search(List<CoffeeRecipe> recipes, String keyword) {
        List<CoffeeRecipe> searchResults = new ArrayList<>();

        for (CoffeeRecipe recipe : recipes) {
            if (recipe.getCategories().contains(keyword)) {
                searchResults.add(recipe);
            }
        }

        return searchResults;
    }
}
