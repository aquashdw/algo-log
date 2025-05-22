package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://www.acmicpc.net/problem/2841
public class Prob2841 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] guitar = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        List<Stack<Integer>> strings = new ArrayList<>(7);
        strings.add(null);
        for (int i = 1; i < 7; i++) {
            strings.add(new Stack<>());
            strings.get(i).push(-1);
        }
        int count = 0;
        for (int i = 0; i < guitar[0]; i++) {
            int[] melody = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            Stack<Integer> string = strings.get(melody[0]);
            if (string.peek() == melody[1]) continue;

            while (string.peek() > melody[1]) {
                string.pop();
                count++;
            }

            if (string.peek() < melody[1]) {
                string.push(melody[1]);
                count++;
            }
        }
        System.out.println(count);
    }
}
