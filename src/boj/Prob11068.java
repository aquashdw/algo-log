package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/11068
public class Prob11068 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).mapToInt(Integer::parseInt)
                .forEach(num -> {
                    List<Integer> digits = new ArrayList<>();
                    for (int i = 2; i < 65; i++) {
                        int number = num;
                        digits.clear();
                        while (number > 0) {
                            digits.add(number % i);
                            number /= i;
                        }
                        boolean success = true;
                        for (int j = 0; j < digits.size() / 2; j++) {
                            if (digits.get(j) != digits.get(digits.size() - 1 - j)) {
                                success = false;
                                break;
                            }
                        }
                        if (success) {
                            answer.append(1).append('\n');
                            return;
                        }
                    }
                    answer.append(0).append('\n');
                });
        System.out.print(answer);
    }
}
