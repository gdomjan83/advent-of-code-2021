package day01;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import static day01.ScanningDeep.readFile;

public class ScannigThreeMeasurement {
    //Link: https://adventofcode.com/2021/day/1#part2

    public int countDeepByThree(Path path) {
        int count = 0;
        List<String> lines = readFile(path);
        for (int i = 0; i <= lines.size() - 4; i++) {
            int sum1 = Integer.parseInt(lines.get(i)) + Integer.parseInt(lines.get(i + 1)) + Integer.parseInt(lines.get(i + 2));
            int sum2 = Integer.parseInt(lines.get(i + 1)) + Integer.parseInt(lines.get(i + 2)) + Integer.parseInt(lines.get(i + 3));
            if (sum1 < sum2) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ScannigThreeMeasurement stm = new ScannigThreeMeasurement();
        System.out.println(stm.countDeepByThree(Paths.get("src/main/resources/data.txt")));
    }
}
