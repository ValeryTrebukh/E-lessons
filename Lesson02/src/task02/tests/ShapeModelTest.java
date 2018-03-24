package task02.tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import task02.entity.*;
import task02.model.ShapeModel;

import static org.junit.Assert.*;

public class ShapeModelTest {

    private Shape[] shapes;
    private ShapeModel model = new ShapeModel();
    private Shape t1, r1, c1, t2;

    @Before
    public void setUp() throws Exception {
        t1 = new Triangle(Color.BLUE, 4, 3);
        r1 = new Rectangle(Color.RED, 5, 4);
        c1 = new Circle(Color.GREEN, 5);
        t2 = new Rectangle(Color.BROWN, 3, 6);

        shapes = new Shape[]{t1, r1, c1, t2};

        model.setShapes(shapes);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void getAreaByShape() throws Exception {
        assertEquals(38, model.getAreaByShape(shapes[1]));
    }

    @Test
    public void getTotalArea() throws Exception {
        assertEquals(122, model.getTotalArea());
    }

    @Test
    public void sortByColor() throws Exception {
        Shape[] expected =  {r1, c1, t1, t2};
        model.sortByColor();
        assertArrayEquals(expected, shapes);
    }

    @Test
    public void sortByArea() throws Exception {
        Shape[] expected =  {t1, t2, r1, c1};
        model.sortByArea();
        assertArrayEquals(expected, shapes);
    }

}