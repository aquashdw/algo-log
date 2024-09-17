package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/23284
public class Prob23284 {
    private static StringBuilder answer = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        boolean[] visited = new boolean[n + 1];
        int usedMax = 0;
        int[] arr = new int[n];
        dfs(n, 0, usedMax, visited, arr);
        System.out.print(answer);
    }

    private static void dfs(int n, int nextIdx, int usedMax, boolean[] visited, int[] arr) {
        if (nextIdx == n) {
            answer.append(Arrays.stream(arr)
                            .mapToObj(String::valueOf)
                            .collect(Collectors.joining(" ")))
                    .append('\n');
            return;
        }
        for (int i = 1; i < n + 1; i++) {
            if (visited[i]) continue;
            if (i > usedMax) {
                visited[i] = true;
                arr[nextIdx] = i;
                dfs(n, nextIdx + 1, i, visited, arr);
                visited[i] = false;
            }
            else {
                boolean valid = true;
                for (int j = i + 1; j < usedMax; j++) {
                    if (!visited[j]) {
                        valid = false;
                        break;
                    }
                }
                if (valid) {
                    visited[i] = true;
                    arr[nextIdx] = i;
                    dfs(n, nextIdx + 1, usedMax, visited, arr);
                    visited[i] = false;
                }
            }
        }
    }
}


/*
5
1 2 3 4 5  // 1p p 2p p 3p p 4p p 5p p
1 2 3 5 4  // 1p p 2p p 3p p 4p 5p p p
1 2 4 3 5  // 1p p 2p p 3p 4p p p 5p p
1 2 4 5 3  // 1p p 2p p 3p 4p p 5p p p
1 2 5 4 3  // 1p p 2p p 3p 4p 5p p p p
1 2 5 3 4 X
1 3 2 4 5  // 1p p 2p 3p p p 4p p 5p p
1 3 2 5 4  // 1p p 2p 3p p p 4p 5p p p
1 3 4 2 5  // 1p p 2p 3p p 4p p p 5p p
1 3 4 5 2  // 1p p 2p 3p p 4p p 5p p p
1 3 5 2 4 X
1 3 5 4 2  // 1p p 2p 3p p 4p 5p p p p
1 4 2 3 5 X
1 4 2 5 3 X
1 4 3 2 5  // 1p p 2p 3p 4p p p p 5p p
1 4 3 5 2  // 1p p 2p 3p 4p p p 5p p p
1 4 5 2 3 X
1 4 5 3 2  // 1p p 2p 3p 4p p 5p p p p
1 5 2 3 4 X
1 5 2 4 3 X
1 5 3 2 4 X
1 5 3 4 2 X
1 5 4 2 3 X
1 5 4 3 2  // 1p p 5p 4p 3p 2p p p p p
 */