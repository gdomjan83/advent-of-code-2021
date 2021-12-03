package day03;

import static day01.ScanningDeep.readFile;

import java.nio.file.Paths;
import java.util.List;

public class ComputePower {
    private List<String> input = readFile(Paths.get("src/main/resources/power_input.txt"));

    public int computingPower() {
        String gammaBinary = getGammaBinaryString(input);
        int gamma = Integer.parseInt(gammaBinary, 2);

        String epsilonBinary = getEpsilonBinaryString(input);
        int epsilon = Integer.parseInt(epsilonBinary, 2);

        return gamma * epsilon;
    }


    private String getGammaBinaryString(List<String> input) {
        StringBuilder sb = new StringBuilder();
        int lengthOfLine = input.get(0).length();
        for (int i = 0; i < lengthOfLine; i++) {
            OnesAndZeroes onesAndZeroes = countOnesAndZeroes(input, i, lengthOfLine);
            appendOneOrZeroForGamma(sb, onesAndZeroes);
        }
        return new String(sb);
    }

    private String getEpsilonBinaryString(List<String> input) {
        StringBuilder sb = new StringBuilder();
        int lengthOfLine = input.get(0).length();
        for (int i = 0; i < lengthOfLine; i++) {
            OnesAndZeroes onesAndZeroes = countOnesAndZeroes(input, i, lengthOfLine);
            appendOneOrZeroForEpsilon(sb, onesAndZeroes);
        }
        return new String(sb);
    }

    private OnesAndZeroes countOnesAndZeroes(List<String> input, int characterAt, int lengthOfLine) {
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

    private void appendOneOrZeroForGamma(StringBuilder sb, OnesAndZeroes onesAndZeroes) {
        if (onesAndZeroes.getCountOne() > onesAndZeroes.getCountZero()) {
            sb.append("1");
        }
        if (onesAndZeroes.getCountOne() < onesAndZeroes.getCountZero()) {
            sb.append("0");
        }
    }

    private void appendOneOrZeroForEpsilon(StringBuilder sb, OnesAndZeroes onesAndZeroes) {
        if (onesAndZeroes.getCountOne() < onesAndZeroes.getCountZero()) {
            sb.append("1");
        }
        if (onesAndZeroes.getCountOne() > onesAndZeroes.getCountZero()) {
            sb.append("0");
        }
    }

    public static void main(String[] args) {
        ComputePower computePower = new ComputePower();

        System.out.println(computePower.computingPower());
    }


}
