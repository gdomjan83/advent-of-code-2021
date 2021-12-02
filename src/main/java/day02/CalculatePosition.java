package day02;

import java.nio.file.Paths;
import java.util.List;

import static day01.ScanningDeep.readFile;

public class CalculatePosition {
    private int horizontalPosition;
    private int depth;

    //Puzzle link: https://adventofcode.com/2021/day/2
    public int calculatePosition(List<String> input) {

        for (String actual : input) {
            switch (getCommand(actual)[0]) {
                case "forward":
                    horizontalPosition += Integer.parseInt(getCommand(actual)[1]);
                    break;
                case "up":
                    depth -= Integer.parseInt(getCommand(actual)[1]);
                    break;
                case "down":
                    depth += Integer.parseInt(getCommand(actual)[1]);
                    break;
            }
        }
        return horizontalPosition * depth;
    }

    private String[] getCommand(String commandLine) {
        return commandLine.split(" ");
    }

    public static void main(String[] args) {
        CalculatePosition calculatePosition = new CalculatePosition();
        System.out.println(calculatePosition.calculatePosition(readFile(Paths.get("src/main/resources/position.txt"))));
    }
}
