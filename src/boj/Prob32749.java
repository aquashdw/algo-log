package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/32749
public class Prob32749 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nt = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int numLength = 1 << nt[0];
        int wordLen = numLength / (1 << nt[1]);
        String number = reader.readLine();
        String answer = number.substring(0, wordLen);
        for (int i = wordLen; i < numLength; i += wordLen) {
            String now = number.substring(i, i + wordLen);
            if (answer.compareTo(now) < 0) answer = now;
        }
        System.out.println(answer);
    }
}
