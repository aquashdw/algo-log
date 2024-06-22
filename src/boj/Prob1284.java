package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/10872
public class Prob1284 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        while (true) {
            String line = reader.readLine();
            if (line.equals("0")) break;
            answer.append(length(line)).append('\n');
        }
        System.out.println(answer);
    }

    private static int length(String line) {
        int length = line.length() + 1;
        length += line.chars().reduce(0, (total, item) -> {
            if (item == '1') return total + 2;
            if (item == '0') return total + 4;
            return total + 3;
        });
        return length;
    }
}
