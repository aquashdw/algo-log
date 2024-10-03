package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/12607
public class Prob12607 {
    private static final int[] keyMap = {
            2, 2, 2,
            3, 3, 3,
            4, 4, 4,
            5, 5, 5,
            6, 6, 6,
            7, 7, 7, 7,
            8, 8, 8,
            9, 9, 9, 9,
    };

    private static final int[] hitMap = {
            2, 22, 222,
            3, 33, 333,
            4, 44, 444,
            5, 55, 555,
            6, 66, 666,
            7, 77, 777, 7777,
            8, 88, 888,
            9, 99, 999, 9999,
    };

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            answer.append("Case #").append(i + 1).append(": ");
            reader.readLine().chars().reduce(-1, (lastPress, digit) -> {
                int thisPress;
                if (digit == ' ') thisPress = 0;
                else thisPress = keyMap[digit - 'a'];

                if (thisPress == lastPress) answer.append(' ');
                answer.append(digit == ' ' ? 0 : hitMap[digit - 'a']);
                return thisPress;
            });

//            int lastPress = -1;
//            for (char digit : reader.readLine().toCharArray()) {
//                int thisPress;
//                if (digit == ' ') thisPress = 0;
//                else thisPress = keyMap[digit - 'a'];
//
//                if (thisPress == lastPress) answer.append(' ');
//                lastPress = thisPress;
//                answer.append(digit == ' ' ? 0 : hitMap[digit - 'a']);
//            }
            answer.append('\n');
        }
        System.out.print(answer);
    }
}
