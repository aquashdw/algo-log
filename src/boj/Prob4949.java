package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


// https://www.acmicpc.net/problem/4949
public class Prob4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder answerBuilder = new StringBuilder();
        while (!(line = reader.readLine()).equals(".")) {
            Stack<Character> stack = new Stack<>();
            boolean fail = false;
            for (char letter : line.toCharArray()) {
                if (letter == '(' || letter == '[')
                    stack.push(letter);
                else if (letter == ')') {
                    if (stack.empty() || stack.peek() != '(') {
                        fail = true;
                        break;
                    }
                    else
                        stack.pop();
                }
                else if (letter == ']') {
                    if (stack.empty() || stack.peek() != '[') {
                        fail = true;
                        break;
                    }
                    else
                        stack.pop();
                }
            }
            if (!fail && stack.empty())
                answerBuilder.append("yes");
            else answerBuilder.append("no");
            answerBuilder.append('\n');
        }
        System.out.println(answerBuilder);
    }
}
