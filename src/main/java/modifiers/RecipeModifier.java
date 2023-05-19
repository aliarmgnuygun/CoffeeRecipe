package modifiers;

import java.util.Stack;

public class RecipeModifier {
    private Command command;
    private Stack<Command> commandHistory;

    public RecipeModifier() {
        commandHistory = new Stack<>();
    }

    public void setCommand(Command command) {
        this.command = command;
    }

    public void executeCommand() {
        if (command != null) {
            command.execute();
            commandHistory.push(command);
        }
    }

    public void undoCommand() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            lastCommand.undo();
        }
    }
}

