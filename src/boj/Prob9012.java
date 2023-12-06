package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/9012
public class Prob9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            if (isVPS(reader.readLine()))
                answerBuilder.append("YES");
            else answerBuilder.append("NO");
            answerBuilder.append('\n');
        }
        System.out.print(answerBuilder);
    }

    public static boolean isVPS(String line) {
        Stack<Character> stack = new Stack<>();
        for (Character letter : line.toCharArray()) {
            if (letter == '(')
                stack.push(letter);
            else {
                if (stack.empty())
                    return false;
                else stack.pop();
            }
        }
        return stack.empty();
    }
}
