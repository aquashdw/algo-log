package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


// https://www.acmicpc.net/problem/10845
public class Prob10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        LinkedList<String> queue = new LinkedList<>();
        reader.lines().skip(1).forEach(line -> {
            String[] commands = line.split(" ");
            switch (commands[0]) {
                case "push" -> queue.offer(commands[1]);
                case "pop" -> {
                    if (queue.isEmpty()) answer.append("-1\n");
                    else answer.append(queue.poll()).append('\n');
                }
                case "size" -> answer.append(queue.size()).append('\n');
                case "empty" -> answer.append(queue.isEmpty() ? "1\n" : "0\n");
                case "front" -> {
                    if (queue.isEmpty()) answer.append("-1\n");
                    else answer.append(queue.peek()).append("\n");
                }
                case "back" -> {
                    if (queue.isEmpty()) answer.append("-1\n");
                    else answer.append(queue.peekLast()).append("\n");
                }
                default -> throw new IllegalArgumentException();
            }
        });
        System.out.print(answer);
    }
}
