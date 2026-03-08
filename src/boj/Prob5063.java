package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/5063
public class Prob5063 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(n).forEach(line -> {
            int[] outcome = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int stay = outcome[0];
            int advertise = outcome[1] - outcome[2];
            if (stay == advertise) answer.append("does not matter\n");
            else if (stay > advertise) answer.append("do not advertise\n");
            else answer.append("advertise\n");
        });
        System.out.print(answer);
    }
}
