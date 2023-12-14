package task2.shapes;


import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Locale;

public abstract class AbstractShape implements IDrawable, Serializable {
    protected String shapeColour;

    public AbstractShape(String shapeColour) {
        System.out.println("I am AbstractShape Constructor!");
        validate(shapeColour);
        this.shapeColour = shapeColour;
    }




    /**
     * Validate input values
     *
     * @throws NullPointerException     when at least one of argument is null
     * @throws IllegalArgumentException if value is incorrect    *
     */

    private void validate(String shapeColour) {
        if (shapeColour == null) {
            throw new IllegalArgumentException("shapeColour is null");
        }
        if (shapeColour.trim().length() == 0) {
            throw new IllegalArgumentException("shapeColour length is zero");
        }
    }

    /**
     * Just calculate area;
     */

    abstract public double calcArea();


    public String getShapeColour() {
        return shapeColour;
    }

    public void setShapeColour(String shapeColour) {
        this.shapeColour = shapeColour;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "AbstractShape {colour: %s, area: %5.3f}", getShapeColour(), calcArea());
    }

}
