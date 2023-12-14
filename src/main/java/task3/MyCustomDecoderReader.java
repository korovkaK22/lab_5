package task3;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;

public class MyCustomDecoderReader extends FilterReader {
    private final int key;

    public MyCustomDecoderReader(Reader in, char keyChar) {
        super(in);
        this.key = keyChar;
    }

    @Override
    public int read() throws IOException {
        int c = super.read();
        return (c == -1) ? c : c - key;
    }
}