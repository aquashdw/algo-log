package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/32616
public class Prob32616 {
    private static int k;
    private static long[] weights;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        k = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray()[1];
        weights = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();

        long low = 1;
        long high = 1_000_000_000_000_000L;
        while (low + 1 <= high) {
            long mid = (low + high) / 2;
            if (possible(mid)) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        System.out.println(high);
    }

    private static boolean possible(long minWeight) {
        int startUps = 1;
        long partWeight = 0;
        for (long weight : weights) {
            if (weight > minWeight) return false;
            if (partWeight + weight <= minWeight) {
                partWeight += weight;
                continue;
            }

            partWeight = weight;
            startUps++;
            if (startUps > k) return false;
        }

        return true;
    }
}
