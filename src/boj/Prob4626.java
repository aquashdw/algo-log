package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/4626
public class Prob4626 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int[] input = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int top = input[0];
            int bot = input[1];
            top %= bot;
            int base = 1;
            if (bot % 7 == 0) {
                base = bot / 7;
            } else {
                base *= bot;
                top *= 7;
            }
            int idx = 0;
            int[] digits = new int[input[3] + 1];
            while (idx < input[3] + 1) {
                digits[idx] = top / base;
                top %= base;
                top *= 7;
                idx++;
            }
            answer.append(String.format(
                    "Problem set %d: %d / %d, base 7 digits %d through %d: %s%n",
                    test + 1,
                    input[0], input[1],
                    input[2], input[3],
                    Arrays.stream(digits).skip(input[2]).mapToObj(String::valueOf).
                            collect(Collectors.joining(""))
            ));
        }
        System.out.print(answer);
    }

}
