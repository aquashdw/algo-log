package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2487
public class Prob2487 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] inShuffle = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] shuffle = new int[n + 1];
        if (n >= 0) System.arraycopy(inShuffle, 0, shuffle, 1, n);
        boolean[] visited = new boolean[n + 1];
        int result = 1;
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                int cycle = 0;
                for (int j = i; !visited[j]; j = shuffle[j]) {
                    visited[j] = true;
                    cycle++;
                }
                result = result / gcd(result, cycle) * cycle;
            }
        }
        System.out.println(result);
    }

    private static int gcd(int x, int y) {
        while (y > 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        return x;
    }
}
