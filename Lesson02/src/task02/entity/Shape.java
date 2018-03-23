package task02.entity;

public abstract class Shape implements Drawable {

    private Color shapeColor;

    Shape(Color shapeColor) {
        this.shapeColor = shapeColor;
    }

    public Color getShapeColor() {
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
