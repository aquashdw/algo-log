package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class ParTest1 {
    public boolean solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Stack<Character> charStack = new Stack<>();

        // 여기는 어떻게 해도 큰 상관은 없지만 속도가 신경쓰인다면
        for (int i = 0; i < input.length(); i++) {
            // 어쨋든 문자열 문자 하나씩
            char next = input.charAt(i);
            // 여는 괄호일때는 무지성 push
            if (next == '(') {
                charStack.push(next);
            }
            // 닫는 괄호일때는
            else if (next == ')'){
                // pop 할게 없으면 틀렸다
                if (charStack.empty()) return false;
                // pop 하자
                char top = charStack.pop();
                // 괄호 맞는지 검사
                if (top != '(') return false;
            }
        }
        // 순회 끝나고 스택이 비어있는지 확인해보자.
        return charStack.empty();
    }
/*
()()((()))
((()(())()))((())(()()
*/

    public static void main(String[] args) throws IOException {
        System.out.println(new ParTest1().solution());
    }
}
