import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }

    public static List<String> readFile(String name){
        try {
            Path fileName = Paths.get("src/Day2/data.txt");
            return Files.readAllLines(fileName);
        } catch (IOException e) {
            return Collections.emptyList();
        }
    }
}