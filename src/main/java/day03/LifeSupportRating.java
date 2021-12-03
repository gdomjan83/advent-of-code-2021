package day03;

import static day01.ScanningDeep.readFile;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class LifeSupportRating {
    //https://adventofcode.com/2021/day/3#part2

    private List<String> input = new ArrayList<>();

    public int computeLifeSupport() {
        String oxygenRatingBinary = getOxyenRating(readFile(Paths.get("src/main/resources/power_input.txt")));
        String cO2RatingBinary = getCO2Rating(readFile(Paths.get("src/main/resources/power_input.txt")));

        return Integer.parseInt(oxygenRatingBinary, 2) * Integer.parseInt(cO2RatingBinary, 2);
    }

    private OnesAndZeroes countOnesAndZeroes(List<String> input, int characterAt) {
        OnesAndZeroes onesAndZeroes = new OnesAndZeroes();
        for (int j = 0; j < input.size(); j++) {
            if (input.get(j).charAt(characterAt) == '0') {
                onesAndZeroes.setCountZero(onesAndZeroes.getCountZero() + 1);
            } else {
                onesAndZeroes.setCountOne(onesAndZeroes.getCountOne() + 1);
            }
        }
        return onesAndZeroes;
    }

    private void removeLines(List<String> input, int characterAt, char characterToRemove) {
        List<String> toBeRemoved = new ArrayList<>();
        for (String actual : input) {
            if (actual.charAt(characterAt) == characterToRemove) {
                toBeRemoved.add(actual);
            }
        }
        input.removeAll(toBeRemoved);
    }

    private String getOxyenRating(List<String> input) {
        for (int i = 0; i < input.get(0).length(); i++) {
            OnesAndZeroes onesAndZeroes = countOnesAndZeroes(input, i);
            if (onesAndZeroes.getCountOne() >= onesAndZeroes.getCountZero()) {
                removeLines(input, i, '0');
                if (input.size() == 1) {
                    return input.get(0);
                }
            } else {
                removeLines(input, i, '1');
                if (input.size() == 1) {
                    return input.get(0);
                }
            }
        }
        return input.get(0);
    }

    private String getCO2Rating(List<String> input) {
        for (int i = 0; i < input.get(0).length(); i++) {
            OnesAndZeroes onesAndZeroes = countOnesAndZeroes(input, i);
            if (onesAndZeroes.getCountOne() >= onesAndZeroes.getCountZero()) {
                removeLines(input, i, '1');
                if (input.size() == 1) {
                    return input.get(0);
                }
            } else {
                removeLines(input, i, '0');
                if (input.size() == 1) {
                    return input.get(0);
                }
            }
        }
        return input.get(0);
    }

    public static void main(String[] args) {
        LifeSupportRating lifeSupportRating = new LifeSupportRating();

        System.out.println(lifeSupportRating.computeLifeSupport());
    }
}
