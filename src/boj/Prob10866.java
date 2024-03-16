package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;


// https://www.acmicpc.net/problem/10866
public class Prob10866 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        LinkedList<String> queue = new LinkedList<>();
        reader.lines().skip(1).forEach(line -> {
            String[] commands = line.split(" ");
            switch (commands[0]) {
                case "push_front" -> queue.offerFirst(commands[1]);
                case "push_back" -> queue.offerLast(commands[1]);
                case "pop_front" -> {
                    if (queue.isEmpty()) answer.append("-1\n");
                    else answer.append(queue.pollFirst()).append('\n');
                }
                case "pop_back" -> {
                    if (queue.isEmpty()) answer.append("-1\n");
                    else answer.append(queue.pollLast()).append('\n');
                }
                case "size" -> answer.append(queue.size()).append('\n');
                case "empty" -> answer.append(queue.isEmpty() ? "1\n" : "0\n");
                case "front" -> {
                    if (queue.isEmpty()) answer.append("-1\n");
                    else answer.append(queue.peekFirst()).append("\n");
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
