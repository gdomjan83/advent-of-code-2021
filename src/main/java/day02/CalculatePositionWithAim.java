package day02;

import java.nio.file.Paths;
import java.util.List;

import static day01.ScanningDeep.readFile;

public class CalculatePositionWithAim {

    private int horizontalPosition;
    private int aim;
    private int depth;

    //Puzzle link: https://adventofcode.com/2021/day/2#part2
    public int calculatePosition(List<String> input) {

        for (String actual : input) {
            switch (getCommand(actual)[0]) {
                case "forward":
                    horizontalPosition += Integer.parseInt(getCommand(actual)[1]);
                    depth += Integer.parseInt(getCommand(actual)[1]) * aim;
                    break;
                case "up":
                    aim -= Integer.parseInt(getCommand(actual)[1]);
                    break;
                case "down":
                    aim += Integer.parseInt(getCommand(actual)[1]);
                    break;
            }
        }
        return horizontalPosition * depth;
    }

    private String[] getCommand(String commandLine) {
        return commandLine.split(" ");
    }

    public static void main(String[] args) {
        CalculatePositionWithAim calculatePositionWithAim = new CalculatePositionWithAim();
        System.out.println(calculatePositionWithAim.calculatePosition(readFile(Paths.get("src/main/resources/position.txt"))));
    }
}
