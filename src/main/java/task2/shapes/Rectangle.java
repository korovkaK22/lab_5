package task2.shapes;

import java.util.Arrays;
import java.util.Locale;

public class Rectangle extends AbstractShape{

    private final Point p1;
    private final Point p2;
    private final Point p3;
    private final Point p4;

    public Rectangle(String shapeColour, Point p1, Point p2, Point p3, Point p4) {
        super(shapeColour);
        validate(p1,p2,p3,p4);
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
    }

    /**
     * Validate input values
     *
     * @throws NullPointerException     when at least one of argument is null
     * @throws IllegalArgumentException if value is incorrect    *
     */

    static void validate(Point p1,Point p2,Point p3,Point p4){
        if (p1 == null || p2 == null || p3 == null || p4 == null){
            throw new NullPointerException("Null Point");
        }

        if (p1.equals(p2) || p1.equals(p3) || p1.equals(p4)){
            throw new NullPointerException("Zero Rectangle");
        }

        double diag1 = distance(p1, p3);
        double diag2 = distance(p2, p4);
        double diag3 = distance(p1, p2);
        double diag4 = distance(p3, p4);

        if (!((Math.abs(diag1 - diag2) < 1e-6) || (Math.abs(diag3 - diag4) < 1e-6))){
            throw new IllegalArgumentException("Can't make rectangle. Invalid Points: ");
        }
    }


    @Override
    public void draw() {
        System.out.println("Draw a" + getShapeColour() + "rectangle!");
    }

    @Override
    public double calcArea() {
        double[] distances = {
                distance(p1, p2),
                distance(p1, p3),
                distance(p1, p4),
                distance(p2, p3),
                distance(p2, p4),
                distance(p3, p4)
        };

        Arrays.sort(distances);

        return distances[0] * distances[2];
    }

    private static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }


    @Override
    public String toString() {
        return String.format(Locale.US, "Rectangle {colour: %s, points: %s; %s; %s; %s}", getShapeColour(), p1,p2,p3,p4);
    }
}
