package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

// https://www.acmicpc.net/problem/3986
public class Prob3986 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());
        int goodWords = 0;
        for (int i = 0; i < N; i++) {
            String word = reader.readLine();
            Stack<Character> charStack = new Stack<>();
            for (char c : word.toCharArray()) {
                if (charStack.empty() || charStack.peek() != c) charStack.push(c);
                else if (charStack.peek() == c) charStack.pop();
            }
            if (charStack.empty()) goodWords++;
        }
        System.out.println(goodWords);
    }
}
