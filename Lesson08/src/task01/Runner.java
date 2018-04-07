package task01;

import java.lang.reflect.Field;
import java.util.Scanner;

public class Runner {



    public void run() throws NoSuchFieldException, IllegalAccessException {
        String str = "predefined string";

        System.out.println(str);

        Class<?> cl = String.class;
        Field field = cl.getDeclaredField("value");
        field.setAccessible(true);
        field.set(str,"new string".toCharArray());

        System.out.println(str);

        System.out.print(" > ");
        Scanner sc = new Scanner(System.in);

        str = sc.nextLine();
        System.out.println(str);

        field.set(str,(str + " re-defined").toCharArray());

        System.out.println(str);
    }
}
