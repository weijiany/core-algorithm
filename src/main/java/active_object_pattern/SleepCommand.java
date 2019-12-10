package active_object_pattern;

public class SleepCommand implements Command {

    private Command wakeCommand;
    private long delayMillis;
    private long startTime;
    private ActiveObjectEngine engine;
    private boolean started = false;

    public SleepCommand(Command wakeCommand, int delayMillis, ActiveObjectEngine engine) {
        this.wakeCommand = wakeCommand;
        this.delayMillis = delayMillis;
        this.engine = engine;
    }

    @Override
    public void execute() {
        long currentTime = System.currentTimeMillis();
        if (!started) {
            startTime = currentTime;
            started = true;
            engine.addCommand(this);
        }
        else if (currentTime - startTime < delayMillis)
            engine.addCommand(this);
        else
            wakeCommand.execute();
    }
}
