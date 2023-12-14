package task1;

import java.io.File;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) {
        String path = "src/main/resources/task1/dostoievskyy-fedir-mykhaylovych-zlochyn-i-kara798.html";
        File file = new File(path);

        MyCustomStringReader myCustomStringReader = new MyCustomStringReader(file);
        System.out.printf("The longest string: \n%s", myCustomStringReader.getTheLongestString());
    }
}
