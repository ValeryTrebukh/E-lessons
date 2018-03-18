package task02.entity;

public class Circle extends Shape {

    private int radius;

    public Circle(String shapeColor, int radius) {
        super(shapeColor);
        this.radius = radius;
    }

    @Override
    public int calcArea() {
        return (int)(Math.PI*radius*radius);
    }

    @Override
    public String toString() {
        return "Circle: color = " + getShapeColor() + "; area = " + calcArea();
    }
}
