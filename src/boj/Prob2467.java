package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2467
public class Prob2467 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();

        int front = 0;
        int back = n - 1;
        long min = numbers[front] + numbers[back];

        int minFront = front;
        int minBack = back;
        while (front != back) {
            long sum = numbers[front] + numbers[back];
            if (Math.abs(sum) < Math.abs(min)) {
                min = sum;
                minFront = front;
                minBack = back;
            }
            if (sum == 0) break;
            else if (sum < 0) front++;
            else back--;
        }

        System.out.println(String.format("%d %d", numbers[minFront], numbers[minBack]));
    }
}
