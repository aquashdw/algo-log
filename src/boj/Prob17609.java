package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/17609
public class Prob17609 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            int front = 0;
            int back = line.length() - 1;
            while (front < back) {
                if (line.charAt(front) == line.charAt(back)) {
                    front++;
                    back--;
                    continue;
                }
                break;
            }


            if (front >= back) {
                answer.append(0).append('\n');
                return;
            }

            if (isPalindrome(line, front + 1, back) || isPalindrome(line, front, back - 1)) {
                answer.append(1).append('\n');
            } else answer.append(2).append('\n');
        });
        System.out.print(answer);
    }

    private static boolean isPalindrome(String word, int front, int back) {
        while (front < back) {
            if (word.charAt(front) != word.charAt(back)) return false;
            front++;
            back--;
        }
        return true;
    }
}
