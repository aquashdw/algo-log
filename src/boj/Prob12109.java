package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/12109
public class Prob12109 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] cites = new int[n + 1];
        Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .forEach(cite -> {
                    if (cite >= n) cites[n]++;
                    else cites[cite]++;
                });
        for (int i = n; i > 1; i--) {
            if (cites[i] >= i) {
                System.out.println(i);
                return;
            }

            cites[i - 1] += cites[i];
        }
        System.out.println(cites[1]);
    }
}
