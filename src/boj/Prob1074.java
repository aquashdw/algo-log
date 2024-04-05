package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1074
public class Prob1074 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = info[0];
        int side = 1;
        for (int i = 0; i < n; i++) {
            side *= 2;
        }
        int r = info[1];
        int c = info[2];
        System.out.println(count(r, c, side, 0));
    }

    private static int count(int r, int c, int side, int count) {
        if (side == 2) {
            if (r == 0 && c == 0) return count;
            else if (r == 0 && c == 1) return count + 1;
            else if (r == 1 && c == 0) return count + 2;
            else return count + 3;
        }
        int half = side / 2;
        if (r < half && c < half) {
            return count(r, c, half, count);
        } else if (r < half) {
            int cells = half * half;
            return count(r, c - half, half, count + cells);
        } else if (c < half) {
            int cells = half * half;
            return count(r - half, c, half, count + cells * 2);
        } else {
            int cells = half * half;
            return count(r - half, c - half, half, count + cells * 3);
        }
    }
}
