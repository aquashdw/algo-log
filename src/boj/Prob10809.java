package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/10809
public class Prob10809 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String target = reader.readLine();
        int[] array = new int[26];
        Arrays.fill(array, -1);
        for (int i = 0; i < target.length(); i++) {
            int index = target.charAt(i) - 'a';
            if (array[index] == -1)
                array[index] = i;
        }

        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            answerBuilder.append(array[i]);
            answerBuilder.append(" ");
        }

        System.out.println(answerBuilder);
    }
}
