package be.vdab.app;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {
    public static void main(String[] args) {
        try(
                BufferedReader bf = new BufferedReader(
                        new FileReader("alice.txt")
                );
                BufferedReader bf2 = new BufferedReader(
                        new FileReader("alice - kopie.txt")
                );
                ZipOutputStream zipStream = new ZipOutputStream(
                        new FileOutputStream("archive2.zip"));
                PrintStream streamWriter = new PrintStream(zipStream)) {
// File one
            ZipEntry entryOne = new ZipEntry("alice.txt");
            zipStream.putNextEntry(entryOne);
            String line;
            while ((line = bf.readLine()) != null){
                streamWriter.println(line); // Write output using any stream (here PrintStream)

            }
            streamWriter.println("Contents of file one"); // Write output using any stream (here PrintStream)
// File two
            ZipEntry entryTwo = new ZipEntry("alice - kopie.txt");
            zipStream.putNextEntry(entryTwo);
            streamWriter.println("Contents of file two");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
