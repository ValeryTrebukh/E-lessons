package task05;

import java.util.ArrayList;
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

        System.out.println(list);


        //task 8.4
        System.out.println(sumWithCondition(array, (x)->x/10));

        System.out.println(filterWithCondition(list, (s)-> s.startsWith("с")));

        convertStrings(list);

        System.out.println(list);

    }


    private Integer[] generate(int size) {
        Integer[] result = new Integer[size];
        for(int i = 0; i < size; i++) {
            result[i] = (int)(Math.random()*100);
        }
        return result;
    }

    //task 8.4
    private int sumWithCondition(Integer[] arr, SumFunction func) {
        int result = 0;
        for(int val : arr) {
            result += func.sum(val);
        }
        return result;
    }

    private List<String> filterWithCondition(List<String> list, FilterFunction func) {
        List<String> result = new ArrayList<>();

        for(String s : list) {
            if(func.filter(s)){
                result.add(s);
            }
        }
        return result;
    }

    private interface SumFunction {
        int sum(int val);
    }

    private interface FilterFunction {
        boolean filter(String str);
    }

    private void convertStrings(List<String> list) {

        StringConverter sc = String::toUpperCase;
        String str;
        for(int i = 0; i < list.size(); i++) {
            str = list.get(i);
            if(sc.isExist(str)) {
                list.set(i, sc.convert(str));
            }
        }
    }
}
