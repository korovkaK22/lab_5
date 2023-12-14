package task2;

import task2.shapes.AbstractShape;
import task2.shapes.Circle;
import task2.shapes.Point;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        AbstractShape circle = new Circle("red", new Point(0,0), 4.0);
        System.out.printf("Serialized circle: %s\n", circle);

        // Серіалізація об'єкта Circle
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src/main/resources/task2/circle"))) {
            out.writeObject(circle);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Змінюємо статичну змінну і змінну нашого об'єкту
        circle.setShapeColour("blue");
        Circle.setPI(22);
        System.out.printf("Changed circle: %s\n", circle);

        // Десеріалізація об'єкта Circle
        Circle deserializedCircle = null;
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src/main/resources/task2/circle"))) {
            deserializedCircle = (Circle) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        System.out.printf("Deserialized circle: %s\n", deserializedCircle);

    }
}
