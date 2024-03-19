package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;


// https://www.acmicpc.net/problem/1874
public class Prob1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder answer = new StringBuilder();
        int[] array = reader.lines().limit(n)
                .mapToInt(Integer::parseInt)
                .toArray();
        int pushNext = 1;
        for (int num: array) {
            // 다음 숫자가 다음에 넣은것보다 크면 그 숫자까지 넣었다가 빼야 한다.
            if (num > pushNext) {
                for (int i = pushNext; i < num; i++) {
                    answer.append("+\n");
                    stack.push(i);
                }
                // 마지막 숫자를 넣었다가 뺀다.
                answer.append("+\n-\n");
                pushNext = num + 1;
            }
            // 다음 숫자가 다음에 넣을것과 같으면 넣었다 뺀다.
            else if (num == pushNext) {
                answer.append("+\n-\n");
                pushNext += 1;
            }
            // 나머지는 스택에서 빼야 되는 경우들 뿐인데,
            // 스택이 비었거나 다음 숫자가 틀릴 경우 NO
            else if (stack.isEmpty() || num > stack.peek()) {
                System.out.println("NO");
                return;
            }
            // 아니면 뺀다.
            else {
                stack.pop();
                answer.append("-\n");
            }
        }
        System.out.print(answer);
    }
}
