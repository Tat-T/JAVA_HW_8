package geometry.test;

import geometry.model.*;
import org.example.geometry.model.*;
import org.junit.Test;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class ShapeTest {

    @Test
    public void testTriangleArea() {
        Shape triangle = new Triangle(10, 5);
        assertEquals(25.0, triangle.calculateArea(), 0.001);
    }

    @Test
    public void testRectangleArea() {
        Shape rectangle = new Rectangle(4, 6);
        assertEquals(24.0, rectangle.calculateArea(), 0.001);
    }

    @Test
    public void testSquareArea() {
        Shape square = new Square(5);
        assertEquals(25.0, square.calculateArea(), 0.001);
    }

    @Test
    public void testRhombusArea() {
        Shape rhombus = new Rhombus(8, 6);
        assertEquals(24.0, rhombus.calculateArea(), 0.001);
    }
}
