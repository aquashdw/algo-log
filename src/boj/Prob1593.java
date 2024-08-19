package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/1593
public class Prob1593 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int letters = Integer.parseInt(reader.readLine().split(" ")[0]);
        int[] letterCount = new int[128 - 'A'];
        reader.readLine().chars().forEach(c -> {
            letterCount[c - 'A']++;
        });
        int[] compareArr = new int[128 - 'A'];

        String source = reader.readLine();
        int count = 0;
        int subSize = 0;
        for (int i = 0; i < source.length(); i++) {
            char now = source.charAt(i);
            compareArr[now - 'A']++;
            subSize++;
            if (subSize == letters) {
                if (Arrays.equals(letterCount, compareArr)) {
                    count++;
                }
                subSize--;
                compareArr[source.charAt(i - subSize) - 'A']--;
            }
        }
        System.out.println(count);
    }
}
