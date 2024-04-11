package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/11399
public class Prob11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nums = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .sorted()
                .toArray();

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i] * (n - i);
        }
        System.out.println(sum);
    }

}
