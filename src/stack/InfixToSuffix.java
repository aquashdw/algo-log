package stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class InfixToSuffix {
    // 스택 내부에 있을 때 우선순위
    private int inStackPriority(char operator) {
        if (operator == '+' || operator == '-') return 1;
        else if (operator == '*' || operator == '/') return 2;
        else if (operator == '(') return 0;
        else throw new IllegalArgumentException("not allowed argument");
    }

    // 스택에 들어갈 때 우선순위
    private int inComingPriority(char operator) {
        if (operator == '+' || operator == '-') return 1;
        else if (operator == '*' || operator == '/') return 2;
        else if (operator == '(') return 3;
        else throw new IllegalArgumentException("not allowed argument");
    }

    private boolean isOperator(char token) {
        return token == '(' || token == '+' || token == '-' || token == '*' || token == '/';
    }

    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        StringBuilder answerBuilder = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char next = input.charAt(i);
            if (isOperator(next)) {
                if (operatorStack.empty()) operatorStack.push(next);
                else {
                    while (inStackPriority(operatorStack.peek()) >= inComingPriority(next)) {
                        answerBuilder.append(operatorStack.pop());
                        if (operatorStack.empty()) break;
                    }
                    operatorStack.push(next);
                }
            } else if (next == ')') {
                char top = operatorStack.pop();
                while (top != '(') {
                    answerBuilder.append(top);
                    top = operatorStack.pop();
                }

            } else answerBuilder.append(next);
        }
        while (!operatorStack.empty()) {
            answerBuilder.append(operatorStack.pop());
        }
        System.out.println(answerBuilder);
    }

    public static void main(String[] args) throws IOException {
        new InfixToSuffix().solution();
    }
}
