package active_object_pattern;

import java.util.LinkedList;

public class ActiveObjectEngine {

    private LinkedList<Command> commands;

    public ActiveObjectEngine() {
        commands = new LinkedList<>();
    }

    public void run() {
        while (!commands.isEmpty()) {
            Command pop = commands.pop();
            pop.execute();
        }
    }

    public void addCommand(Command command) {
        commands.add(command);
    }

    public void stop() {
        commands.clear();
    }
}
