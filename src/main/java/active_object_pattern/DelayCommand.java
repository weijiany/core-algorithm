package active_object_pattern;

public class DelayCommand implements Command {

    private int delayMillis;
    private char c;
    private ActiveObjectEngine engine;

    public DelayCommand(int delayMillis, char c, ActiveObjectEngine engine) {
        this.delayMillis = delayMillis;
        this.c = c;
        this.engine = engine;
    }

    @Override
    public void execute() {
        System.out.print(c);

        engine.addCommand(new SleepCommand(this, delayMillis, engine));
    }
}
