package modifiers;

import models.CoffeeRecipe;

import java.util.List;

public class ChangeIngredientsCommand implements Command {
    private CoffeeRecipe recipe;
    private List<String> newIngredients;
    private List<String> oldIngredients;

    public ChangeIngredientsCommand(CoffeeRecipe recipe, List<String> newIngredients) {
        this.recipe = recipe;
        this.newIngredients = newIngredients;
    }

    public void execute() {
        oldIngredients = recipe.getIngredients();
        recipe.setIngredients(newIngredients);
    }

    public void undo() {
        recipe.setIngredients(oldIngredients);
    }
}

