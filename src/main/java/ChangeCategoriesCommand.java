import models.CoffeeRecipe;

import java.util.ArrayList;
import java.util.List;

public class ChangeCategoriesCommand implements Command {
    private CoffeeRecipe recipe;
    private List<String> newCategories;
    private List<String> oldCategories;

    public ChangeCategoriesCommand(CoffeeRecipe recipe, List<String> newCategories) {
        this.recipe = recipe;
        this.newCategories = newCategories;
    }

    public void execute() {
        oldCategories = new ArrayList<>(recipe.getCategories());
        recipe.setCategories(newCategories);
    }

    public void undo() {
        recipe.setCategories(oldCategories);
    }
}