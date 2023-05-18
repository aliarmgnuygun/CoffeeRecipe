package modifiers;

public class RecipeModifier {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command != null) {
            command.execute();
        }
    }

    public void undoCommand() {
        if (command != null) {
            command.undo();
        }
    }
}
