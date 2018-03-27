package task0502.controller;

import task0502.view.View;
import task0502.model.Translator;
import task0502.utils.Helper;

public class Controller {

    private Translator tr = new Translator();
    private View view = new View();

    public void run() {

        while (true) {
            view.printMenu();
            switch (Helper.requestInt()) {
                case 1:
                    tr.addPairOfWords();
                    break;
                case 2:
                    view.printMessage("Enter english phrase.");
                    view.printMessage(tr.translateEngToRus(Helper.requestString()));
                    break;
                case 0:
                    System.exit(0);
            }
        }
    }
}
