package task02.entity;

public abstract class Shape implements Drawable {

    private String shapeColor;

    Shape(String shapeColor) {
        this.shapeColor = shapeColor;
    }

    public String getShapeColor() {
        return shapeColor;
    }

    @Override
    public String draw() {
        return "The new shape has been created.";
    }

    public abstract int calcArea();

    @Override
    public String toString() {
        return "Abstract shape of " + getShapeColor() + "color";
    }
}
