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

        view.print(model.getTotalArea());

        view.print(model.getAreaByShape(new Triangle(Color.RED, 1, 1)));
        view.print(model.getAreaByShape(new Rectangle(Color.RED, 1, 1)));
        view.print(model.getAreaByShape(new Circle(Color.RED, 1)));

        model.sortByArea();
        view.print(model.getShapes());

        model.sortByColor();
        view.print(model.getShapes());
    }

}
