package task2.shapes;

import lombok.Setter;
import lombok.ToString;

import java.util.Locale;


public class Circle extends AbstractShape {
    @Setter
    private static double PI = Math.PI;
    private final Point center;
    transient private final double radius;

    public Circle(String shapeColour, Point center, double radius) {
        super(shapeColour);
        System.out.println("I am Circle Constructor!");
        validate(center, radius);
        this.center = center;
        this.radius = radius;
    }

    static void validate(Point p, double radius) {
        if (p == null) {
            throw new NullPointerException("Null center");
        }
        if (radius <= 0){
            throw new IllegalArgumentException("Invalid radius");
        }
    }


    @Override
    public void draw() {
        System.out.println("Draw a" + getShapeColour() + "circle!");
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "Circle {colour: %s, center: %s, radius: %.3f, pi: %.3f}", getShapeColour(), center, radius, PI);
    }
}
