package task02.utils;

import task02.entity.*;

public class Generator {

    private static Color[] colors = Color.values();


    private static Color getColor() {
        return colors[(int)(Math.random()*colors.length)];
    }


    public static Shape[] generate(int size) {
        Shape[] result = new Shape[size];

        for(int i = 0; i < size; i++) {
            int rnd = (int)(Math.random()*3);

            if(rnd == 0) {
                result[i] = createRectangle();
            } else if (rnd == 1) {
                result[i] = createTriangle();
            } else {
                result[i] = createCircle();
            }
        }

        return result;
    }


    private static Rectangle createRectangle() {
        int height = (int)(Math.random()*15 + 1);
        int width = (int)(Math.random()*20 + 1);

        return new Rectangle(getColor(), height, width);
    }


    private static Triangle createTriangle() {
        int height = (int)(Math.random()*20 + 1);
        int base = (int)(Math.random()*20 + 1);

        return new Triangle(getColor(), height, base);
    }


    private static Circle createCircle() {
        int radius = (int)(Math.random()*10 + 1);

        return new Circle(getColor(), radius);
    }
}
