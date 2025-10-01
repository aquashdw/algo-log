package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/5930
public class Prob5930 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] notes = reader.lines().limit(n).mapToInt(Integer::parseInt).toArray();
        int c = Integer.parseInt(reader.readLine());
        int[] chord = reader.lines().limit(c).mapToInt(Integer::parseInt).sorted().toArray();
        int base = chord[0];
        for (int i = 0; i < c; i++) {
            chord[i] -= base;
        }
        int count = 0;
        Queue<Integer> indices = new LinkedList<>();
        for (int i = 0; i < n - c + 1; i++) {
            int[] partial = Arrays.stream(notes, i, i + c).sorted().toArray();
            boolean same = true;
            for (int j = 1; j < c; j++) {
                if (partial[j] - partial[0] != chord[j]) {
                    same = false;
                    break;
                }
            }
            if (same) {
                count++;
                indices.offer(i + 1);
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append(count).append('\n');
        for (int idx : indices) answer.append(idx).append('\n');
        System.out.print(answer);
    }
}
