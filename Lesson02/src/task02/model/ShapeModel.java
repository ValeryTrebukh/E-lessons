package task02.model;

import task02.entity.Shape;
import task02.utils.Generator;

import java.util.Arrays;
import java.util.Comparator;

public class ShapeModel {

    private int totalArea;

    private Shape[] shapes;

    public ShapeModel() {
        shapes = Generator.generate(12);
    }

    public int getTotalArea() {

        if (totalArea == 0) {
            for(Shape sh : shapes) {
                totalArea += sh.calcArea();
            }
        }
        return totalArea;
    }


    public int getAreaByShape(Shape shape) {

        int result = 0;

        for(Shape sh : shapes) {
            if(shape.getClass()==sh.getClass()) {
                result += sh.calcArea();
            }
        }
        return result;
    }


    public void sortByColor() {
        Arrays.sort(shapes, Comparator.comparing(Shape::getShapeColor));
    }


    public void sortByArea() {
        Arrays.sort(shapes, Comparator.comparing(Shape::calcArea));
    }


    public Shape[] getShapes() {
        return shapes;
    }

    // for testing purpose only
    public void setShapes(Shape[] shapes) {
        this.shapes = shapes;
    }
}
