package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11811
public class Prob11811 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] nums = new int[n][];
        for (int i = 0; i < n; i++) {
            nums[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i] = array[i] | nums[i][j];
            }
        }
        System.out.println(String.join(" ", Arrays.stream(array).mapToObj(String::valueOf).toArray(String[]::new)));
    }
}
