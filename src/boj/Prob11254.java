package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// https://www.acmicpc.net/problem/11254
public class Prob11254 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int n = Integer.parseInt(reader.readLine());
            int[] boxes = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Stack<Integer> hold = new Stack<>();
            int out = 0;
            int next = 0;
            while (out < n) {
                if (!hold.isEmpty() && hold.peek() == out + 1) {
                    out++;
                    hold.pop();
                    continue;
                }

                if (next < n) {
                    int now = boxes[next];
                    if (now == out + 1) {
                        out++;
                        next++;
                        continue;
                    }
                    if (hold.isEmpty() || hold.peek() > now) {
                        hold.push(now);
                        next++;
                        continue;
                    }
                }

                break;
            }

            answer.append(out == n ? "yes" : "no").append('\n');
        }
        System.out.print(answer);
    }
}
