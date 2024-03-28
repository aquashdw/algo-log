package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


// https://www.acmicpc.net/problem/10989
public class Prob10989 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());
        int[] count = new int[10001];
        reader.lines().limit(n)
                .mapToInt(Integer::parseInt)
                .forEach(i -> count[i]++);
        for (int i = 1; i < 10001; i++) {
            while (count[i] > 0) {
                answer.append(i).append('\n');
                count[i]--;
            }
        }
        System.out.print(answer);
    }
}
