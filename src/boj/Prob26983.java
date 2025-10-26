package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/26983
public class Prob26983 {
    private static int n;
    private static int min = 49;
    private static String[] sequences;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        sequences = reader.lines().limit(n).toArray(String[]::new);
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            used[i] = true;
            dfs(i, used, 1, new StringBuilder(sequences[i]));
            used[i] = false;
        }
        System.out.println(min);
    }

    private static void dfs(int before, boolean[] used, int count, StringBuilder dna) {
        if (dna.length() > min) return;
        if (count == n) {
            min = dna.length();
            return;
        }

        for (int i = 0; i < n; i++) {
            if (used[i]) continue;
            String now = sequences[i];
            int overlap = 0;
            for (int j = Math.min(dna.length(), now.length()); j > 0; j--) {
                if (dna.toString().endsWith(now.substring(0, j))) {
                    overlap = j;
                    break;
                }
            }
            used[i] = true;
            dna.append(now.substring(overlap));
            dfs(i, used, count + 1, dna);
            used[i] = false;
            dna.delete(dna.length() - (now.length() - overlap), dna.length());
        }
    }
}
