package task05;


@FunctionalInterface
public interface StringConverter {

    String convert(String str);

    default boolean isExist(String str) {
        return str != null && !str.isEmpty();
    }
}
