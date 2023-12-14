package task3;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        char codingChar = 'a';
        String path = "src/main/resources/task3";
        String sourceFile = path + "/OdaJava.txt";
        String codedFile = path + "/CodedOdaJava.txt";
        String decodedFile = path + "/DecodedOdaJava.txt";

        // з sourceFile читається кожен символ, і через MyCustomCoderWriter записується в файл codedFile
        //Потім з кодованого файлу читається файл, і виводиться


        // Кодуємо з sourceFile в codedFile
        try (FileReader fr = new FileReader(sourceFile);
             FileWriter fw = new FileWriter(codedFile);
             MyCustomCoderWriter coder = new MyCustomCoderWriter(fw, codingChar)) {

            int c;
            while ((c = fr.read()) != -1) {
                coder.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Декодуємо з codedFile в decodedFile
        try (FileReader fr = new FileReader(codedFile);
             FileWriter fw = new FileWriter(decodedFile);
             MyCustomDecoderReader decoder = new MyCustomDecoderReader(fr, codingChar)) {

            int c;
            while ((c = decoder.read()) != -1) {
                fw.write(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Читаємо з decodedFile і виводимо
        try (FileReader fr = new FileReader(decodedFile)) {
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

