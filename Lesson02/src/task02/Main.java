package task02;

import task02.controller.ShapeController;
import task02.model.ShapeModel;
import task02.view.ShapeView;

public class Main {
    public static void main(String[] args) {
        ShapeModel model = new ShapeModel();
        ShapeView view = new ShapeView();
        ShapeController controller = new ShapeController(model, view);

        controller.run();
    }
}
