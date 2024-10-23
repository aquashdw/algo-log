package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/27569
public class Prob27569 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nk[0];
        long k = nk[1];
        long remainder = 0;
        long shift = 10;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (i == shift) shift *= 10;
            remainder = (remainder * shift + i) % k;
            if (remainder == 0) count++;
        }

        System.out.println(count);
    }
}
