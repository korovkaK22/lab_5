package task3;

import java.io.FilterWriter;
import java.io.IOException;
import java.io.Writer;

public class MyCustomCoderWriter extends FilterWriter {
    private final int key;

    public MyCustomCoderWriter(Writer out, char keyChar) {
        super(out);
        this.key = keyChar;
    }

    @Override
    public void write(int c) throws IOException {
        super.write(c + key);
    }

}