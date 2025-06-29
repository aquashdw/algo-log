package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/12603
public class Prob12603 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            answer.append("Case #").append(test + 1).append(": ");
            int credits = Integer.parseInt(reader.readLine());
            int count = Integer.parseInt(reader.readLine());
            int[] items = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[] select = {-1, -1};
            for (int i = 0; i < count - 1; i++) {
                for (int j = i + 1; j < count; j++) {
                    if (items[i] + items[j] == credits) {
                        select[0] = i + 1;
                        select[1] = j + 1;
                        break;
                    }
                }
                if (select[0] != -1) break;
            }
            answer.append(String.format("%d %d\n", select[0], select[1]));
        }
        System.out.print(answer);
    }
}
