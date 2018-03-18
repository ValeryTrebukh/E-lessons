package task03;

import java.io.Serializable;

public abstract class MyEnumBase implements Comparable, Serializable {

    private static int next = 0;

    private String name;
    private int ordinal;

    private static MyEnumBase[] values;


    protected MyEnumBase(String name){
        this.name = name;
        this.ordinal = next;
        add(this);
    }


    protected MyEnumBase(String... args) {
        values = new MyEnumBase[args.length];
    }

    private void add(MyEnumBase e) {
        if(contains(e)) {
            return;
        }
        values[next++] = e;
    }

    private boolean contains(MyEnumBase e) {
        for(MyEnumBase b : values) {
            if(b != null && b.name.equals(e.name)) {
                return true;
            }
        }
        return false;
    }

    public static MyEnumBase[] values() {
        if(values.length != next) {
            MyEnumBase[] result = new MyEnumTest[next];
            System.arraycopy(values, 0, result, 0, next);
            return result;
        }
        return values;
    }

    public final String name() {
        return name;
    }


    public final int ordinal() {
        return ordinal;
    }


    public String toString() {
        return name;
    }


    public final boolean equals(Object other) {
        return super.equals(other);
    }


    public final int hashCode() {
        return super.hashCode();
    }


    protected final Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }


    public final int compareTo(Object o) {
        MyEnumBase obj = (MyEnumBase)o;
        return this.ordinal - obj.ordinal;
    }


    public final Class getDeclaringClass() {
        return super.getClass();
    }


    public static MyEnumBase valueOf(String name) {

        if (name == null) throw new NullPointerException();

        for(MyEnumBase b : values) {
            if (b!=null && b.name.equals(name)) {
                return b;
            }
        }
        throw new IllegalArgumentException();
    }
}
