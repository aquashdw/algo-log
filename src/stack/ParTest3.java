package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParTest3 {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Stack<Character> charStack = new Stack<>();

        // 여기는 어떻게 해도 큰 상관은 없지만 속도가 신경쓰인다면
        for (int i = 0; i < input.length(); i++) {
            // 어쨋든 문자열 문자 하나씩
            char next = input.charAt(i);

            // 가장 최근에 들어온 문자가 top과 동일할 경우
            if (!charStack.empty() && charStack.peek() == next) {
                charStack.pop();
            }
            else charStack.push(next);
        }
        // 순회 끝나고 스택이 비어있는지 확인해보자.
        return charStack.size();
    }

/*
ABCCB
NNNASBBSNV
UKJWHGGHNFTCRRCTWLALX
*/

    public static void main(String[] args) throws IOException {
        System.out.println(new ParTest3().solution());
    }
}
