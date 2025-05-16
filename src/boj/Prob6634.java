package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/6634
public class Prob6634 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        answer.append(reader.lines().takeWhile(l -> !l.equals("end"))
                .map(l -> IntStream.range(0, 7)
                        .mapToObj(i -> IntStream.range(0, 5)
                                .mapToObj(j -> {
                                    if (j == 2) return i == 2 || i == 4 ? "o" : " ";
                                    int digit = Character.getNumericValue(l.charAt(j));
                                    return translate(digit, i);
                                })
                                .collect(Collectors.joining("  ")))
                        .collect(Collectors.joining("\n")))
                .collect(Collectors.joining("\n\n\n")));
        answer.append("\n\n\n").append("end");
        System.out.println(answer);

    }

    private static String translate(int digit, int row) {
        return switch (row) {
            case 0 -> switch (digit) {
                case 0, 2, 3, 5, 6, 7, 8, 9 -> "+---+";
                case 1 -> "    +";
                case 4 -> "+   +";
                default -> throw new IllegalStateException("Unexpected digit: " + digit);
            };
            case 1, 2 -> switch (digit) {
                case 0, 4, 8, 9 -> "|   |";
                case 1, 2, 3, 7 -> "    |";
                case 5, 6 -> "|    ";
                default -> throw new IllegalStateException("Unexpected digit: " + digit);
            };
            case 3 -> switch (digit) {
                case 0 -> "+   +";
                case 1, 7 -> "    +";
                case 2, 3, 4, 5, 6, 8, 9 -> "+---+";
                default -> throw new IllegalStateException("Unexpected digit: " + digit);
            };
            case 4, 5 -> switch (digit) {
                case 0, 6, 8 -> "|   |";
                case 1, 3, 4, 5, 7, 9 -> "    |";
                case 2 -> "|    ";
                default -> throw new IllegalStateException("Unexpected digit: " + digit);
            };
            case 6 -> switch (digit) {
                case 0, 2, 3, 5, 6, 8, 9 -> "+---+";
                case 1, 4, 7 -> "    +";
                default -> throw new IllegalStateException("Unexpected digit: " + digit);
            };
            default -> throw new IllegalStateException("Unexpected division: " + row);
        };
    }
}
