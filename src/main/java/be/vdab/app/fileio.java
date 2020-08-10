package be.vdab.app;

import java.io.File;
import java.io.IOException;

public class fileio {
    public static void main(String[] args) throws IOException {
        deleteImages(new File("."));

    }

    public static void deleteImages(File file){
        System.out.println(file.getName());
        if (file.isDirectory()){
            File[] children = file.listFiles();
            if (children != null){
                for (File child : children){
                    deleteImages(child);
                }
            }
        } else if (file.isFile() && file.getName().endsWith(".txt")){
            System.out.println("Deleting file");
            file.delete();
        }

    }
}
