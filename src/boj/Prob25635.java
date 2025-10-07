package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/25635
public class Prob25635 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[] rides = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong)
                .sorted()
                .toArray();

        if (n == 1) {
            System.out.println(1);
            return;
        }
        long sum = Arrays.stream(rides, 0, n - 1).sum();
        if (rides[n - 1] - sum < 2) System.out.println(sum + rides[n - 1]);
        else System.out.println((2 * sum) + 1);
    }
}
