package task03;

import java.util.Arrays;
import java.util.List;

public class Runner {
    public void run() {
        Integer[] array = generate(15);
        System.out.println(Arrays.toString(array));
        Arrays.sort(array, (a, b) -> b - a);
        System.out.println(Arrays.toString(array));

        String[] str = ("Мы живем почти ничего не понимая в устройстве мира " +
                "Не задумываемся над тем какой механизм порождает солнечный свет " +
                "который обеспечивает наше существование не думаем о гравитации " +
                "которая удерживает нас на Земле не давая ей сбросить нас в пространство").split(" ");

        System.out.println(Arrays.toString(str));

        List<String> list = Arrays.asList(str);

        list.sort((s1, s2) -> s2.compareTo(s1));

        System.out.println(Arrays.toString(list.toArray()));

    }


    private Integer[] generate(int size) {
        Integer[] result = new Integer[size];
        for(int i = 0; i < size; i++) {
            result[i] = (int)(Math.random()*100);
        }
        return result;
    }
}
