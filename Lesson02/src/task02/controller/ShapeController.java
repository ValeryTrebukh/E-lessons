package task02.controller;

import task02.entity.*;
import task02.model.ShapeModel;
import task02.view.ShapeView;

public class ShapeController {

    private ShapeModel model;
    private ShapeView view;

    public ShapeController(ShapeModel model, ShapeView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        view.print(model.getShapes());

        view.print(model.getArea());

        view.print(model.getArea(new Triangle("red", 1, 1)));
        view.print(model.getArea(new Rectangle("red", 1, 1)));
        view.print(model.getArea(new Circle("red", 1)));

        model.sortByArea();
        view.print(model.getShapes());

        model.sortByColor();
        view.print(model.getShapes());
    }

}
