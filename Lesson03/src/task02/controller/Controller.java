package task02.controller;

import task02.carriage.Train;
import task02.carriage.*;
import task02.utils.Helper;
import task02.view.View;


public class Controller {

    private Train<Passenger> train;
    private View view = new View();

    public void run() {

        int len = Math.abs(Helper.requestInt("Enter train length"));

        len = len > 9 ? 9 : len;

        train = makeTrain(len);

        while(true) {
            switch (Helper.requestInt("Select from menu: 1 - show\t2 - sort\t3 - count payloads\t4 - find carriage\t0 - EXIT")) {
                case 1:
                    view.print(train.getCarriages());
                    break;
                case 2:
                    train.sort();
                    break;
                case 3:
                    view.print(train.calcPass(), train.calcLug());
                    break;
                case 4:
                    view.print(train.find(Helper.requestInt("Enter number passengers")));
                    break;
                case 0:
                    System.exit(0);
                default:
                    break;
            }
        }
    }


    private static Train<Passenger> makeTrain(int len) {

        Train<Passenger> result = new Train<>(len);

        for (int i = 0; i < len; i++) {
            Passenger p = requestPassengerCarriage();

            if(p != null) {
                result.addCarriage(p);
            }
        }

        return result;
    }


    private static Passenger requestPassengerCarriage() {

        Passenger p;

        switch (Helper.requestInt("ENTER CARRIAGE TYPE: 1 - COMMON\t2 - ELITE\t3 - VIP\t4 - RESTAURANT")) {
            case 1:
                p = new PassRedNeck();

                p.addPassengers(Helper.requestInt("Enter number of passengers"));

                return p;

            case 2:
                p = new PassElite();

                p.addPassengers(Helper.requestInt("Enter number of passengers"));

                p.addLuggage(Helper.requestInt("Enter number of luggage items"));

                return p;

            case 3:
                p =  new PassVip();

                p.addPassengers(Helper.requestInt("Enter number of passengers"));

                p.addLuggage(Helper.requestInt("Enter number of luggage items"));

                return p;

            case 4:
                return new Restaurant();

            default:
                return null;
        }
    }
}
