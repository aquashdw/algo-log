package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

// https://www.acmicpc.net/problem/17585
public class Prob17585 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nums = Integer.parseInt(reader.readLine());
        Boolean[] circuits = Arrays.stream(reader.readLine().split(" "))
                .map(token -> token.equals("T"))
                .toArray(Boolean[]::new);

        Stack<Boolean> stack = new Stack<>();
        Arrays.stream(reader.readLine().split(" "))
                .map(token -> token.charAt(0))
                .forEach(i -> {
                    if (i == '-') stack.push(!stack.pop());
                    else if (!Character.isAlphabetic(i)) {
                        Boolean right = stack.pop();
                        Boolean left = stack.pop();
                        switch (i) {
                            case '*' -> stack.push(left && right);
                            case '+' -> stack.push(left || right);
                            default -> throw new IllegalArgumentException();
                        }
                    }
                    else {
                        stack.push(circuits[i - 'A']);
                    }
                });

        System.out.println(stack.pop() ? 'T' : 'F');
    }
}
