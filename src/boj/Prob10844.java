package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/18244
public class Prob10844 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        long[][] dp = new long[Math.max(n + 1, 3)][11];
        IntStream.range(1, 10).forEach(i -> dp[0][i] = 1);
        for (int i = 1; i < 3; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = dp[i - 1][j + 1] + dp[i - 1][(j + 10) % 11];
            }
        }

        for (int i = 3; i < n + 1; i++) {
            for (int j = 0; j < 10; j++) {
                dp[i][j] = dp[i - 1][j + 1] + dp[i - 1][(j + 10) % 11];
//                if (j - 3 >= 0) {
//                    dp[i][j] -= dp[i - 3][j - 3];
//                }
//                if (j + 3 < 10) {
//                    dp[i][j] -= dp[i - 3][j + 3];
//                }
                dp[i][j] %= 1_000_000_000;
            }
        }

        System.out.println(Arrays.stream(dp[n - 1]).sum() % 1_000_000_000);
    }
}


/*

3
101
121
123

4
210
212
232
234

4
321
323
343
345

4
432
434
454
456

4
543
545
565
567

4
654
656
676
678

4
765
767
787
789

3
876
878
898

2
987
989




9876 X
9878
9898

8765 X
8767
8787
8789
8987
8989

7654 X
7656
7676
7678
7876
7878
7898

6543 X
6545
6565
6567
6765
6767
6787
6789 X

5432 X
5434
5454
5456
5654
5656
5676
5678 X

4321 X
4323
4343
4345
4543
4545
4565
4567 X

3210 X
3212
3232
3234
3432
3434
3454
3456 X

2102
2121
2123
2321
2323
2343
2345 X

1010
1012
1210
1212
1232
1234 X

0101
0121
0123 X

01010
01012
01210
01212
01232 X

01010
01012
01210
01212
01232 X
01234 X





 */