package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5692
public class Prob5692 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        reader.lines().takeWhile(line -> !line.equals("0"))
                .forEach(line -> {
                    int sum = 0;
                    int base = line.length();
                    for (int i = 0; i < line.length(); i++) {
                        int digit = line.charAt(i) - '0';
                        int fact = 1;
                        for (int j = 1; j <= base - i; j++) {
                            fact *= j;
                        }
                        sum += digit * fact;
                    }
                    answer.append(sum).append('\n');
                });
        System.out.print(answer);
    }

}
