package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1362
public class Prob1362 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String line;
        int testCase = 0;
        while (!(line = reader.readLine()).equals("0 0")) {
            testCase++;
            int[] start = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int good = start[0];
            int now = start[1];
            boolean rip = false;
            while (!(line = reader.readLine()).equals("# 0")) {
                String[] split = line.split(" ");
                char action = split[0].charAt(0);
                int value = Integer.parseInt(split[1]);

                if (action == 'E') now -= value;
                else if (action == 'F') now += value;

                if (now <= 0) rip = true;
            }

            answer.append(testCase);
            if (rip) answer.append(" RIP");
            else if (now > good / 2 && now < good * 2) answer.append(" :-)");
            else answer.append(" :-(");
            answer.append('\n');
        }
        System.out.print(answer);
    }
}
