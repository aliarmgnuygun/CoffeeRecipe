package strategies;

import models.CoffeeRecipe;

import java.util.ArrayList;
import java.util.List;

public class SearchByTagsStrategy implements SearchStrategy {
    @Override
    public List<CoffeeRecipe> search(List<CoffeeRecipe> recipes, String keyword) {
        List<CoffeeRecipe> searchResults = new ArrayList<>();

        for (CoffeeRecipe recipe : recipes) {
            if (recipe.getTags().contains(keyword)) {
                searchResults.add(recipe);
            }
        }

        return searchResults;
    }
}