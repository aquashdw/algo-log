package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11509
public class Prob11509 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] heights = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int arrows = 0;
        int[] flying = new int[1000001];
        for (int i = 0; i < n; i++) {
            if (flying[heights[i]] == 0) {
                arrows++;
                flying[heights[i]]++;
            }
            flying[heights[i]]--;
            flying[heights[i] - 1]++;
        }
        System.out.println(arrows);
    }
}
