package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/12458
public class Prob12458 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 1; test < tests + 1; test++) {
            answer.append("Case #").append(test).append(": ");
            long n = Long.parseLong(reader.readLine());
            int exp = 0;
            while (exp < 64 && 1L << exp <= n) {
                exp++;
            }
            exp--;
            long a = (1L << exp) - 1;
            long b = n - a;
            int bits = exp;
            long cmp = 1L;
            for (int i = 0; i < 64; i++) {
                if ((b & cmp) > 0) bits++;
                cmp <<= 1;
                if (cmp > b) break;
            }
            answer.append(bits).append('\n');
        }
        System.out.print(answer);
    }
}
/*
11 = 1011

1011 0000 3
1010 0001 3
1001 0011 4
1000 0010 2
0111 0100 4
0110 0101 4

12 = 1100

1100 0000 2
1011 0001 4
1010 0010 3
1001 0011 4
1000 0100 2
0111 0101 5
0110 0110 4

1000000000000000000
 */