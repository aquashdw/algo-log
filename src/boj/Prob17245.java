package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/17245
public class Prob17245 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] room = new int[n][];
        long computers = 0;
        for (int i = 0; i < n; i++) {
            room[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            computers += Arrays.stream(room[i]).mapToLong(Long::valueOf).sum();
        }
        long required = computers / 2 + (computers % 2 == 1 ? 1 : 0);
        int low = 0;
        int high = 10000000;
        while (low < high) {
            int mid = (low + high) / 2;
            long operational = 0;
            for (int[] row : room) {
                operational += Arrays.stream(row)
                        .map(i -> Math.min(i, mid))
                        .mapToLong(Long::valueOf)
                        .sum();
            }
            if (operational >= required) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        System.out.println(high);
    }
}
