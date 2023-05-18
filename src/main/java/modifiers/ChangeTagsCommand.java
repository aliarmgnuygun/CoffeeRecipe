package modifiers;

import models.CoffeeRecipe;

import java.util.ArrayList;
import java.util.List;

public class ChangeTagsCommand implements Command {
    private CoffeeRecipe recipe;
    private List<String> newTags;
    private List<String> oldTags;

    public ChangeTagsCommand(CoffeeRecipe recipe, List<String> newTags) {
        this.recipe = recipe;
        this.newTags = newTags;
    }

    public void execute() {
        oldTags = new ArrayList<>(recipe.getTags());
        recipe.setTags(newTags);
    }

    public void undo() {
        recipe.setTags(oldTags);
    }
}