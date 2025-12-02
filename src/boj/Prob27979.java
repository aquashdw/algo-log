package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/27979
public class Prob27979 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] balls = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] rightOrder = Arrays.stream(Arrays.copyOf(balls, n))
                .sorted()
                .toArray();

        int nextIdx = n - 1;
        int out = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (balls[i] == rightOrder[nextIdx]) nextIdx--;
            else out++;
        }
        System.out.println(out);
    }
}
