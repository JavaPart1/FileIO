package be.vdab.app;

import java.io.*;

public class aliceApp {
    public static void main(String[] args) throws IOException {
        try (DataInputStream finput = new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream("alice.txt")))){
            int value;
            while ((value = finput.read()) != -1)
                System.out.println(finput.read());


        }

    }
}
