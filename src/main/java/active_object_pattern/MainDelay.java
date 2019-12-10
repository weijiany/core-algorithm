package active_object_pattern;

public class MainDelay {

    public static void main(String[] args) {
        ActiveObjectEngine engine = new ActiveObjectEngine();

        engine.addCommand(new DelayCommand(10, 'A', engine));
        engine.addCommand(new DelayCommand(20, 'B', engine));
        engine.addCommand(new DelayCommand(30, 'C', engine));

        engine.addCommand(new SleepCommand(engine::stop, 1000, engine));

        engine.run();
    }
}
