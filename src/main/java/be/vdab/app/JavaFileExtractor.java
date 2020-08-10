package be.vdab.app;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

public class JavaFileExtractor extends SimpleFileVisitor<Path> {
        public final List<Path> basket = new ArrayList<>();
        public static void main(String[] args) throws IOException {
            JavaFileExtractor v = new JavaFileExtractor();
            //Files.walkFileTree(Paths.get("C:/Users/TVuser/Users/TVuser"), v); // Start at current directory
            Files.walkFileTree(Paths.get("C:/Users","TVuser","Documents","HD Documentories"), v);
                    // Start at current directory
            for (Path bskt: v.basket
                 ) {
                System.out.println(bskt);
            }
            //System.out.println(v.basket);
        }
        public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
                throws IOException {
            if(dir.getFileName().equals(Paths.get("Mijn afbeeldingen"))) {
                return FileVisitResult.SKIP_SUBTREE; // Skip target (build) folder altogether
            }
            return FileVisitResult.CONTINUE;
        }
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws
                IOException {
            if(file.getFileName().toString().endsWith(".mkv")) {
                basket.add(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }
