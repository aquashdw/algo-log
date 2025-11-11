package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/3441
public class Prob3441 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String line;
        while (!(line = reader.readLine()).equals("end")) {
            String[] tokens = line.split(" ");
            String[] commands = tokens[0].split("-");
            String command = commands[0];
            int base = Integer.parseInt(commands[1]);
            String number = tokens[1];
            if (command.equals("to")) answer.append(to(base, number)).append('\n');
            else answer.append(from(base, number)).append('\n');
        }
        System.out.print(answer);
    }

    private static String to(int radix, String numStr) {
        int number = Integer.parseInt(numStr);
        radix = -radix;
        StringBuilder negativeBase = new StringBuilder();
        while (number != 0) {
            int remainder = number % radix;
            number = number / radix;
            if (remainder < 0) {
                remainder += -radix;
                number += 1;
            }
            negativeBase.append(remainder);
        }
        if (negativeBase.isEmpty()) return "0";
        negativeBase.reverse();
        return negativeBase.toString();
    }

    private static int from(int radix, String number) {
        int numIdx = number.length() - 1;
        int base = 1;
        int result = 0;
        while (numIdx >= 0) {
            int remainder = (number.charAt(numIdx) - '0') % radix;

            result += remainder * base;
            base *= -radix;
            numIdx--;
        }
        return result;
    }
}
