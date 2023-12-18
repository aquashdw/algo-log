package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/2473
public class Prob2473 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        long[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();

        long min = Long.MAX_VALUE;
        long[] answer = new long[3];
        for (int i = 0; i < n - 2; i++) {
            int front = i + 1;
            int back = n - 1;
            while (front != back) {
                long sum = numbers[front] + numbers[back] + numbers[i];
                if (Math.abs(min) > Math.abs(sum)) {
                    answer[0] = numbers[i];
                    answer[1] = numbers[front];
                    answer[2] = numbers[back];
                    min = sum;
                }
                if (sum == 0) break;
                else if (sum < 0) front++;
                else back--;
            }
        }

        System.out.printf("%d %d %d%n", answer[0], answer[1], answer[2]);
    }
}
