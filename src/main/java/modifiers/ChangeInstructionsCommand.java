package modifiers;

import models.CoffeeRecipe;

public class ChangeInstructionsCommand implements Command {
    private CoffeeRecipe recipe;
    private String newInstructions;
    private String oldInstructions;

    public ChangeInstructionsCommand(CoffeeRecipe recipe, String newInstructions) {
        this.recipe = recipe;
        this.newInstructions = newInstructions;
    }

    public void execute() {
        oldInstructions = recipe.getBrewingInstructions();
        recipe.setBrewingInstructions(newInstructions);
    }

    public void undo() {
        recipe.setBrewingInstructions(oldInstructions);
    }
}