package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

// https://www.acmicpc.net/problem/6873
public class Prob6873 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Deque<String> stack = new ArrayDeque<>();
        reader.lines().takeWhile(line -> !line.equals("SCHOOL"))
                .forEach(stack::push);

        StringBuilder answer = new StringBuilder();
        while (stack.size() > 1) {
            String direction = stack.pop();
            String street = stack.pop();
            answer.append("Turn ")
                    .append(direction.equals("R") ? "LEFT" : "RIGHT")
                    .append(" onto ")
                    .append(street)
                    .append(" street.\n");
        }

        answer.append("Turn ")
                .append(stack.pop().equals("R") ? "LEFT" : "RIGHT")
                .append(" into your HOME.\n");

        System.out.print(answer);

    }

}
