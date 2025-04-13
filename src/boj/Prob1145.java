package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1145
public class Prob1145 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int product = 1;
        while (true) {
            int count = 0;
            for (int number : numbers) {
                if (number > product) continue;
                if (product % number == 0) count++;
                if (count == 3) break;
            }
            if (count == 3) break;
            product++;
        }
        System.out.println(product);
    }
}
