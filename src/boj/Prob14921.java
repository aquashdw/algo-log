package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14921
public class Prob14921 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] liquids = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int front = 0;
        int back = liquids.length - 1;
        int minSum = liquids[front] + liquids[back];
        int minDiff = Integer.MAX_VALUE;
        while (front < back) {
            int sum = liquids[front] + liquids[back];
            if (Math.abs(sum) < minDiff) {
                minSum = sum;
                minDiff = Math.abs(sum);
            }

            if (sum > 0) {
                back--;
            }
            else if (sum < 0) {
                front++;
            }
            else {
                break;
            }
        }
        System.out.println(minSum);
    }
}
