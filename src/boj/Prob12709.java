package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/12709
public class Prob12709 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            answer.append("Case #").append(test + 1).append(": ");
            int k = Integer.parseInt(reader.readLine());
            char[] origin = reader.readLine().toCharArray();
            char[] permed = new char[origin.length];
            int min = Integer.MAX_VALUE;
            for (int[] perm : perms(k)) {
                for (int i = 0; i < origin.length / k; i++) {
                    int start = i * k;
                    for (int j = 0; j < k; j++) {
                        permed[start + j] = origin[start + perm[j]];
                    }
                }

                char now = permed[0];
                int changed = 1;
                for (int i = 1; i < permed.length; i++) {
                    if (permed[i] != now) {
                        changed++;
                        now = permed[i];
                    }
                }
                min = Math.min(min, changed);
            }
            answer.append(min).append('\n');
        }
        System.out.print(answer);
    }

    private static List<int[]> perms(int k) {
        List<int[]> perms = new ArrayList<>();
        makePerm(k, 0, new int[k], new boolean[k], perms);
        return perms;
    }

    private static void makePerm(int k, int now, int[] perm, boolean[] used, List<int[]> perms) {
        if (now == k) {
            perms.add(perm.clone());
            return;
        }
        for (int i = 0; i < k; i++) {
            if (!used[i]) {
                used[i] = true;
                perm[now] = i;
                makePerm(k, now + 1, perm, used, perms);
                used[i] = false;
            }
        }
    }
}
