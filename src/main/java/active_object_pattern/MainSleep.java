package active_object_pattern;

public class MainSleep {

    public static void main(String[] args) {
        ActiveObjectEngine engine = new ActiveObjectEngine();
        engine.addCommand(new SleepCommand(() -> System.out.println("hello world"), 10, engine));
        engine.run();
    }
}
