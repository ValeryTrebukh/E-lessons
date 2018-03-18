package task03;

public class MyEnumTest extends MyEnumBase {

    private MyEnumTest(String name) {
        super(name);
    }

    public MyEnumTest(String... args) {
        super(args);

        for(String s : args) {
            new MyEnumTest(s);
        }
    }
}
