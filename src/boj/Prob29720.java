package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/29720
public class Prob29720 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nmk = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int mostNeed = nmk[1] * nmk[2];
        int leastNeed = mostNeed - nmk[1] + 1;
        System.out.printf("%d %d%n", Math.max(nmk[0] - mostNeed, 0), nmk[0] - leastNeed);
    }
}
