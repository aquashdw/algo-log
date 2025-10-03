package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/4304
public class Prob4304 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder answer = new StringBuilder();
        while (!(line = reader.readLine()).equals("0")) {
            String[] info = line.split(": ");
            int n = Integer.parseInt(info[0]);
            int[] perm = Arrays.stream(info[1].split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] inverse = new int[n];
            for (int i = 0; i < n; i++) {
                inverse[perm[i]] = i;
            }

            boolean success = true;
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 1; j < n - 1; j++) {
                    int diff = perm[j] - perm[i];
                    int target = perm[j] + diff;
                    if (target >= n || target < 0) continue;
                    int k = inverse[target];
                    if (k > j) {
                        success = false;
                        break;
                    }
                }
                if (!success) break;
            }
            answer.append(success ? "yes" : "no").append('\n');
        }
        System.out.print(answer);
    }
}
