package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/25802
public class Prob25802 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] firstTwo = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] thisFibo = Arrays.copyOf(firstTwo, firstTwo.length);
        int next = (thisFibo[0] + thisFibo[1]) % 10;
        thisFibo[0] = thisFibo[1];
        thisFibo[1] = next;
        int count = 3;
        while (thisFibo[0] != firstTwo[0] || thisFibo[1] != firstTwo[1]) {
            next = (thisFibo[0] + thisFibo[1]) % 10;
            thisFibo[0] = thisFibo[1];
            thisFibo[1] = next;
            count++;
        }
        System.out.println(count);
    }
}
