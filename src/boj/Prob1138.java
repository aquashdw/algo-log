package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1138
public class Prob1138 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] line = new int[n];
        for (int i = 0; i < n; i++) {
            int higher = info[i];
            int count = 0;
            int nextIdx;
            for (nextIdx = 0; count < higher; nextIdx++) {
                if (line[nextIdx] == 0) count++;
            }
            while (line[nextIdx] != 0) nextIdx++;
            line[nextIdx] = i + 1;
        }
        System.out.println(String.join(" ", Arrays.stream(line).mapToObj(String::valueOf).toArray(String[]::new)));
    }
}
