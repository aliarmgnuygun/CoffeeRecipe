package factories;

import models.CoffeeRecipe;

import java.util.List;

public class CoffeeRecipeFactory {
    public CoffeeRecipe createRecipe(List<String> ingredients, String brewingInstructions, int servingSize,
                                     List<String> categories, List<String> tags) {
        CoffeeRecipe coffeeRecipe = new CoffeeRecipe(ingredients, brewingInstructions, servingSize, categories, tags);
        return coffeeRecipe;
    }
}

