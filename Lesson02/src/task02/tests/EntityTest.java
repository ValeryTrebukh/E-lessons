package task02.tests;

import org.junit.Test;
import org.junit.Before;
import task02.entity.*;

import static org.junit.Assert.assertEquals;

public class EntityTest {

    Shape[] shapes = new Shape[3];

    @Before
    public void setUp() throws Exception {
        shapes[0] = new Triangle(Color.BLUE, 4, 3);
        shapes[1] = new Rectangle(Color.RED, 5, 4);
        shapes[2] = new Circle(Color.BLUE, 5);
    }

    @Test
    public void testCalcTriangleArea() throws Exception {
        assertEquals(6, shapes[0].calcArea());
    }

    @Test
    public void testCalcRectangleArea() throws Exception {
        assertEquals(20, shapes[1].calcArea());
    }

    @Test
    public void testCalcCircleArea() throws Exception {
        assertEquals(78, shapes[2].calcArea());
    }

}
