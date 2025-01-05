package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/2723
public class Prob2723 {
    private static final long[][] ncr = new long[12][12];
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Arrays.fill(ncr[0], 1);
        ncr[0][0] = 1;
        ncr[1][0] = 1;
        ncr[1][1] = 1;
        for (int i = 2; i < 12; i++) {
            ncr[i][0] = 1;
            ncr[i][1] = i;
            for (int j = 2; j < i; j++) {
                ncr[i][j] = ncr[i][j - 1] * (i - j + 1) / j;
            }
            ncr[i][i] = 1;
        }
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).mapToInt(Integer::parseInt).forEach(buttons -> {
            long count = count(buttons);
            answer.append(count).append('\n');
        });
        System.out.print(answer);
    }

    private static long count(int left) {
        if (left == 0) return 1;
        long count = 0;
        for (int i = 1; i < left + 1; i++) {
            count += ncr[left][i];
            if (left - i > 0) count += ncr[left][i] * count(left - i);
        }
        return count;
    }
}
/*
nCr
3C2 = 3 * 2 / 2 * 1
 */

/*
3
1 : 3 - (1), (2), (3)
2 : 3 - (1,2), (2,3), (3,1)
1 - 1 : 6 - (1)(2), (1)(3), (2)(1), (2)(3), (3)(1), (3)(2)
1 - 1 - 1 : 6 - (1)(2)(3), (1)(3)(2), (2)(1)(3), (2)(3)(1), (3)(1)(2), (3)(2)(1)
2 - 1 : 3
1 - 2 : 3
3 : 1
 */
