package task0501;

import java.util.List;
import java.util.Set;

public class Runner {

    public void run() {

        int number, lowerLimit, upperLimit;

        System.out.println("Enter number");
        number = Helper.getInt();

        System.out.println("Enter first limit");
        lowerLimit = Helper.getInt();

        System.out.println("Enter second limit");
        upperLimit = Helper.getInt();

        lowerLimit = lowerLimit < upperLimit ? lowerLimit : upperLimit;

        upperLimit = lowerLimit < upperLimit ? upperLimit : lowerLimit;

        List<Integer> list = Generator.getList(number, lowerLimit, upperLimit);
        System.out.print("Created list:\t");
        System.out.println(list);

        Set<Integer> set = Generator.getSet(number, lowerLimit, upperLimit);
        if(!set.isEmpty()) {
            System.out.print("Created set:\t");
            System.out.println(set);
        } else {
            System.out.println("Not enough elements to create set of required length.");
        }

    }
}
