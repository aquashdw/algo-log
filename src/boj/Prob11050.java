package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/11050
public class Prob11050 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = nk[0];
        int k = Math.min(nk[1], nk[0] - nk[1]);
        int top = 1;
        int bot = 1;
        for (int i = 0; i < k; i++) {
            top *= n - i;
            bot *= 1 + i;
        }
        System.out.println(top / bot);
    }
}
