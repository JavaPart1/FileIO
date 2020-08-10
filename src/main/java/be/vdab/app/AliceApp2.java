package be.vdab.app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class AliceApp2 {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        ArrayList<String> alLines = new ArrayList<>();
        ArrayList<String> alWords = new ArrayList<>();
        String[] lnWords = new String[1000];
        try (BufferedReader bfrdr = new BufferedReader(new FileReader("alice.txt"))){
            String line;
            line = bfrdr.readLine();
            while (line != null){
                alLines.add(line);
                System.out.println(line);
                lnWords = line.split(" ");
                for (String sL: lnWords
                     ) {
                    alWords.add(sL.toLowerCase());
                }
                line = bfrdr.readLine();
            }
            System.out.println("file ingelzezn");
            String srWord = "alice";
            int alCount = 0;

            for (String sLine : alWords) {
                //System.out.println(sLine);
                if (sLine.contains(srWord)){
                    alCount++;
                }
            }
            System.out.println("alice count : " + alCount);
        }
    }
}
