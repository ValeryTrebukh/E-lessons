package task03;

import java.util.Arrays;

public class Example {

    public void run() {
        new MyEnumTest("ZERO", "FIRST", "SECOND", "SECOND", "THIRD");


        System.out.println(Arrays.toString(MyEnumTest.values()));

        MyEnumTest mt = (MyEnumTest)MyEnumTest.valueOf("SECOND");

        System.out.println(mt);
        System.out.println(mt.name());
        System.out.println(mt.toString());
        System.out.println(mt.ordinal());
        System.out.println((MyEnumTest.valueOf("THIRD")).ordinal());

        MyEnumTest mt2 = (MyEnumTest)MyEnumTest.valueOf("SECOND");

        System.out.println(mt.equals(mt2));
    }

}
