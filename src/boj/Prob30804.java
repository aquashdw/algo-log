package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/30804
public class Prob30804 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] fruits = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int first = fruits[0];
        int second = -1;
        int front = 0;
        int back = 0;
        int max = 0;
        while (back < n) {
            if (fruits[back] == first || fruits[back] == second) {
                back++;
                continue;
            }
            if (second == -1) {
                second = fruits[back];
                back++;
                continue;
            }
            max = Math.max(max, back - front);
            first = fruits[back];
            second = fruits[back - 1];
            front = back;
            while (front > -1) {
                if (fruits[front] == first || fruits[front] == second) {
                    front--;
                    continue;
                }
                front++;
                break;
            }
        }
        if (fruits[n - 1] == first || fruits[n - 1] == second)
            max = Math.max(max, n - front);
        System.out.println(max);
    }
}
