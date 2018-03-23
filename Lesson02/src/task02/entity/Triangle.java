package task02.entity;

public class Triangle extends Shape {

    private int base;
    private int height;

    public Triangle(Color shapeColor, int height, int base) {
        super(shapeColor);
        this.height = height;
        this.base = base;
    }

    @Override
    public int calcArea() {
        return base*height/2;
    }

    @Override
    public String toString() {
        return "Triangle: color = " + getShapeColor() + "; area = " + calcArea();
    }
}
