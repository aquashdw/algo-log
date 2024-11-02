package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/7805
public class Prob7805 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder answer = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            boolean[] used = new boolean[26];
            int[] sequence = line.chars().map(i -> {
                used[i - 'a'] = true;
                return i - 'a';
            }).toArray();
            Map<Integer, Integer> rank = new HashMap<>();
            int idx = 0;
            for (int i = 0; idx < line.length(); i++) {
                if (!used[i]) continue;
                rank.put(i, idx);
                idx++;
            }

            boolean[] correct = new boolean[sequence.length];
            for (int i = 0; i < sequence.length; i++) {
                if (rank.get(sequence[i]) == i) correct[i] = true;
            }

            int i = 0;
            int swaps = 0;
            while (i < sequence.length) {
                if (correct[i]) {
                    i++;
                    continue;
                }
                swaps++;
                int targetPos = rank.get(sequence[i]);
                int temp = sequence[i];
                sequence[i] = sequence[targetPos];
                sequence[targetPos] = temp;
                correct[targetPos] = true;

                if (rank.get(sequence[i]) == i) {
                    correct[i] = true;
                    i++;
                }
            }
            answer.append(swaps).append('\n');
        }
        System.out.print(answer);
    }
}
