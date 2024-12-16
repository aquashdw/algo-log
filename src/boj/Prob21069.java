package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/21069
public class Prob21069 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests)
                .mapToLong(Long::parseLong)
                .mapToInt(l -> countFactors(l) + countFactors(l + 1))
                .forEach(i -> answer.append(i).append('\n'));
        System.out.print(answer);
    }

    private static int countFactors(long n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }

        int count = 0;
        for (int factor = 2; (long) factor * factor <= n; factor++) {
            if (n % factor == 0) {
                count++;
                while (n % factor == 0) n /= factor;
            }
        }
        if (n > 2) count++;
        return count;
    }
}
/*
1 = 15 = 225
2 = 25 = 625
3 = 35 = 1225
4 = 45 = 2025
5 = 55 = 3025
6 = 65 = 4225
75
85
95
105
 */

/*
1000000000000000000
9223372036854775807
 */