package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/6568
public class Prob6568 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int[] memory = new int[32];
        while (true) {
            String line = null;
            for (int i = 0; i < 32; i++) {
                if ((line = reader.readLine()) == null) break;
                memory[i] = Integer.parseInt(line, 2);
            }
            if (line == null) break;

            int adder = 0;
            int pc = 0;
            while (true) {
                int operator = memory[pc] / 32;
                int operand = memory[pc] % 32;
                if (operator == 7) break;
                pc = (pc + 1) % 32;

                switch (operator) {
                    case 0 -> memory[operand] = adder;
                    case 1 -> adder = memory[operand];
                    case 2 -> { if (adder == 0) pc = operand; }
                    case 3 -> {}
                    case 4 -> adder = (((adder - 1) % 256) + 256) % 256;
                    case 5 -> adder = (adder + 1) % 256;
                    case 6 -> pc = operand;
                    default -> throw new IllegalStateException("Unexpected value: " + operator);
                }
            }
            answer.append(String.format("%8s%n", Integer.toBinaryString(adder)).replace(' ', '0'));
        }
        System.out.println(answer);
    }
}
