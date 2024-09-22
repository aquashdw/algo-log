package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/4531
public class Prob4531 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> answer.append(romanToDecimal(line))
                .append('\n'));
        System.out.print(answer);
    }

    private static int romanToDecimal(String roman) {
        int i = 0;
        int decimal = 0;
        while (i < roman.length()) {
            if (roman.charAt(i) == 'I') {
                if (i + 1 < roman.length() && roman.charAt(i + 1) == 'V') {
                    decimal += 4;
                    i++;
                }
                else if (i + 1 < roman.length() && roman.charAt(i + 1) == 'X') {
                    decimal += 9;
                    i++;
                }
                else decimal++;
                i++;
            }
            else if (roman.charAt(i) == 'V') {
                decimal += 5;
                i++;
            }
            else if (roman.charAt(i) == 'X') {
                if (i + 1 < roman.length() && roman.charAt(i + 1) == 'L') {
                    decimal += 40;
                    i++;
                }
                else if (i + 1 < roman.length() && roman.charAt(i + 1) == 'C') {
                    decimal += 90;
                    i++;
                }
                else decimal += 10;
                i++;
            }
            else if (roman.charAt(i) == 'L') {
                decimal += 50;
                i++;
            }
            else if (roman.charAt(i) == 'C') {
                if (i + 1 < roman.length() && roman.charAt(i + 1) == 'D') {
                    decimal += 400;
                    i++;
                }
                else if (i + 1 < roman.length() && roman.charAt(i + 1) == 'M') {
                    decimal += 900;
                    i++;
                }
                else decimal += 100;
                i++;
            }
            else if (roman.charAt(i) == 'D') {
                decimal += 500;
                i++;
            }
            else if (roman.charAt(i) == 'M') {
                decimal += 1000;
                i++;
            }
        }
        return decimal;
    }
}
