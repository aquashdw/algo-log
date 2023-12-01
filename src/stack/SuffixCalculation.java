package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class SuffixCalculation {
    // 연산자에 따라 값을 계산하는 메소드
    public int calculate(int left, int right, char operator) {
        switch (operator) {
            case '+':
                return left + right;
            case '-':
                return left - right;
            case '*':
                return left * right;
            case '/':
                return left / right;
            default:
                throw new IllegalArgumentException("invalid operator");
        }
    }

    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        Stack<Integer> digitStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char token = input.charAt(i);

            // 현재 문자가 숫자라면
            if (Character.isDigit(token)) {
                // 스택에 넣어준다.
                digitStack.push(token - '0');  // ascii code
            } else {
                // 스택에 나중에 들어간게 우변이니, 먼저 나오는게 우변이다..
                int rightOperand = digitStack.pop();
                int leftOperand = digitStack.pop();
                // 계산한다.
                digitStack.push(calculate(leftOperand, rightOperand, token));
            }
        }
        System.out.println(digitStack.pop());
    }

    public static void main(String[] args) throws IOException {
        new SuffixCalculation().solution();
    }
}
