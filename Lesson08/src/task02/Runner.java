package task02;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Runner {

    public void run() throws IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchMethodException, NoSuchFieldException {
        Class<UnaryArithmeticOperation> cl = UnaryArithmeticOperation.class;

        Constructor<UnaryArithmeticOperation> con = cl.getConstructor(double.class);

        UnaryArithmeticOperation u = con.newInstance(55.0);

        System.out.println(u.toString());

        Field field = cl.getDeclaredField("value");
        field.setAccessible(true);

        System.out.println(field.get(u));

        Method method = cl.getMethod("incrementValue");

        method.invoke(u);

        System.out.println(u.toString());
    }
}
