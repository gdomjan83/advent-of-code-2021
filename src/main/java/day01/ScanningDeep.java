package day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ScanningDeep {
    //Link: https://adventofcode.com/2021/day/1#part1

    public int countDeep(Path path) {
        int count = 0;
        List<String> lines = readFile(path);
        for (int i = 0; i < lines.size() - 1; i++) {
            if (Integer.parseInt(lines.get(i)) < Integer.parseInt(lines.get(i + 1))) {
                count++;
            }
        }
        return count;
    }

    private List<String> readFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file.");
        }
    }

    public static void main(String[] args) {
        ScanningDeep sd = new ScanningDeep();
        System.out.println(sd.countDeep(Paths.get("src/main/resources/data.txt")));
    }
}
