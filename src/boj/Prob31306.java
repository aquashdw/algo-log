package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

// https://www.acmicpc.net/problem/31306
public class Prob31306 {
    private static final Set<Character> agreed = Set.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[2];
        reader.readLine().chars().forEach(ch -> {
            if (agreed.contains((char) ch)) {
                count[0]++;
                count[1]++;
            }
            if (ch == 'y') count[1]++;
        });
        System.out.printf("%d %d%n", count[0], count[1]);
    }

}
