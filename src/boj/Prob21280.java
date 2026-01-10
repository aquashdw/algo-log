package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/21280
public class Prob21280 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] lectures = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int empty = 0;
        int missed = 0;
        for (int i = 1; i < n; i++) {
            if (lectures[i] > lectures[i - 1]) missed += lectures[i] - lectures[i - 1];
            else if (lectures[i - 1] > lectures[i]) empty += lectures[i - 1] - lectures[i];
        }
        System.out.printf("%d %d%n", empty, missed);
    }

}
