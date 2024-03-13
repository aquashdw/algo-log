package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


// https://www.acmicpc.net/problem/10828
public class Prob10828 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        Stack<String> stack = new Stack<>();
        reader.lines().skip(1).forEach(line -> {
            String[] commands = line.split(" ");
            switch (commands[0]) {
                case "push" -> stack.push(commands[1]);
                case "pop" -> {
                    if (stack.empty()) answer.append("-1\n");
                    else answer.append(stack.pop()).append('\n');
                }
                case "size" -> answer.append(stack.size()).append('\n');
                case "empty" -> answer.append(stack.empty() ? "1\n" : "0\n");
                case "top" -> {
                    if (stack.empty()) answer.append("-1\n");
                    else answer.append(stack.peek()).append('\n');
                }
                default -> throw new IllegalArgumentException();
            }
        });
        System.out.print(answer);
    }
}
