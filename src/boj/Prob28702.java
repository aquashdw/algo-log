package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/28702
public class Prob28702 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int next = 0;
        for (int i = 0; i < 3; i++) {
            String line = reader.readLine();
            if (line.chars().allMatch(Character::isDigit)) {
                next = Integer.parseInt(line) + (3 - i);
                break;
            }
        }
        StringBuilder answer = new StringBuilder();
        if (next % 3 == 0) answer.append("Fizz");
        if (next % 5 == 0) answer.append("Buzz");
        if (answer.isEmpty()) answer.append(next);
        System.out.println(answer);
    }
}
