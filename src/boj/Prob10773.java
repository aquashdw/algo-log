package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


// https://www.acmicpc.net/problem/10773
public class Prob10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(reader.readLine());

        Stack<Integer> stack = new Stack<>();
        reader.lines().limit(k)
                .mapToInt(Integer::parseInt)
                .forEach(i -> {
                    if (i == 0) stack.pop();
                    else stack.push(i);
                });

        System.out.println(stack.stream().mapToInt(i -> i).sum());
    }
}
