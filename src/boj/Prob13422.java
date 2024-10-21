package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/13422
public class Prob13422 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        while (tests > 0) {
            tests--;
            int[] info = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int houses = info[0];
            int rob = info[1];
            int ceiling = info[2];
            int[] money = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (houses == rob) {
                answer.append(Arrays.stream(money).sum() < ceiling ? 1 : 0).append('\n');
                continue;
            }
            int count = 0;
            int robSum = Arrays.stream(money, 0, rob).sum();
            if (robSum < ceiling) count++;
            for (int i = 1; i < houses; i++) {
                robSum -= money[i - 1];
                robSum += money[(i + rob - 1) % houses];
                if (robSum < ceiling) count++;
            }

            answer.append(count).append('\n');
        }
        System.out.print(answer);
    }
}
