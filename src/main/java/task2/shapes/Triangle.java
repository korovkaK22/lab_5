package task2.shapes;

import java.util.Locale;

public class Triangle extends AbstractShape{
    Point p1,p2,p3;

    public Triangle(String shapeColour, Point p1, Point p2, Point p3) {
        super(shapeColour);
        validate(p1,p2,p3);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
    }

    /**
     * Validate input values
     *
     * @throws NullPointerException     when at least one of argument is null
     * @throws IllegalArgumentException if value is incorrect    *
     */

    static void validate(Point p1,Point p2,Point p3){
        if (p1 == null || p2 == null || p3 == null){
            throw new NullPointerException("Null Points");
        }

        double area = 0.5 * Math.abs(
                    p1.getX() * (p2.getY() - p3.getY()) +
                            p2.getX() * (p3.getY() - p1.getY()) +
                            p3.getX() * (p1.getY() - p2.getY())
            );
            if (area == 0) {
                throw new IllegalArgumentException("Illegal Points: " + p1 + p2 + p3);
        }
    }


    @Override
    public double calcArea() {
        return 0.5 * Math.abs(
                p1.getX() * (p2.getY() - p3.getY()) +
                        p2.getX() * (p3.getY() - p1.getY()) +
                        p3.getX() * (p1.getY() - p2.getY())
        );
    }

    @Override
    public void draw() {
        System.out.println("Draw a" + getShapeColour() + "triangle!");
    }

    @Override
    public String toString() {
       return String.format(Locale.US, "Triangle {colour: %s, points: %s; %s; %s}", getShapeColour(), p1,p2,p3);
    }
}
