package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/27161
public class Prob27161 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        boolean reverse = false;
        int now = 0;
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            String[] input = reader.readLine().split(" ");
            String type = input[0];
            int hour = Integer.parseInt(input[1]);
            boolean hourglass = type.equals("HOURGLASS");
            boolean hitNow = now + 1 == hour;
            answer.append(now + 1).append(' ');
            answer.append(hitNow && !hourglass ? "YES\n" : "NO\n");
            reverse = reverse != (hourglass && !hitNow);
            now += reverse ? -1 : 1;
            now = (now + 12) % 12;
        }
        System.out.print(answer);
    }
}
