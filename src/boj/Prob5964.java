package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/5964
public class Prob5964 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] pars = reader.lines().limit(n).mapToInt(Integer::parseInt).toArray();
        Stack<Long> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (pars[i] == 0) {
                stack.push(0L);
                continue;
            }
            long last = stack.pop();
            if (last == 0) {
                stack.push(1L);
                continue;
            }
            while (stack.peek() != 0) {
                last = (last + stack.pop()) % 12345678910L;
            }
            stack.pop();
            stack.push((last * 2) % 12345678910L);
        }
        System.out.println(stack.stream().mapToLong(Long::longValue).reduce(0L, (sum, next) -> (sum + next) % 12345678910L));
    }
}
