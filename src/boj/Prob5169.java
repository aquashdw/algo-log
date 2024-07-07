package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5169
public class Prob5169 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int[] info = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] amounts = new int[info[0]];
            for (int j = 0; j < info[1]; j++) {
                int[] transaction = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                amounts[transaction[0] - 1] += transaction[1];
            }
            int max = amounts[0];
            int maxIdx = 0;
            int next = 0;
            for (int j = 1; j < info[0]; j++) {
                if (max < amounts[j]) {
                    next = max;
                    max = amounts[j];
                    maxIdx = j;
                }
                else if (next < amounts[j]) {
                    next = amounts[j];
                }
            }
            answer.append(String.format("Data Set %d:\n", i + 1));
            answer.append(max > next * 2 ? maxIdx + 1 : "No suspect.").append("\n\n");
//            System.out.println(max > next * 2 ? maxIdx + 1 : "No suspect.");
        }
        System.out.print(answer);
    }
}
