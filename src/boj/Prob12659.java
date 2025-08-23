package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/12659
public class Prob12659 {
    private static final String target = "welcome to code jam";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            String line = reader.readLine();
            int[][] dp = new int[line.length()][target.length()];
            dp[0][0] = line.charAt(0) == target.charAt(0) ? 1 : 0;
            for (int i = 1; i < line.length(); i++) {
                dp[i][0] = dp[i - 1][0];
                if (line.charAt(i) == target.charAt(0)) {
                    dp[i][0]++;
                }
            }
            for (int i = 1; i < line.length(); i++) {
                for (int j = 1; j < target.length(); j++) {
                    dp[i][j] = dp[i - 1][j];
                    if (line.charAt(i) == target.charAt(j)) {
                        dp[i][j] += dp[i - 1][j - 1];
                    }
                    dp[i][j] %= 10000;
                }
            }
            answer.append(String.format("Case #%d: %04d%n", test + 1, dp[line.length() - 1][target.length() - 1]));
        }
        System.out.println(answer);
    }
}
/*

asdf
aaaaasssdddfff
dp[i]: i번째 글자까지 사용할 예정인데
dp[j]: 패턴의 j번째 글자까지는 만들어 볼거다

dp[i][j]를 만들때
일단 i-1번째 까지 사용했을 때 j번째 까지 만든 경우를 센다. dp[i-1][j]

여기에 만약 i번째 글자가 j번째 패턴글자와 동일하다면
i-1번째 까지 사용했을 때 j-1번째 까지 만든 경우만큼, dp[i-1][j-1]
i번째 글자를 사용하면서 j번째 패턴까지 만들어낼 수 있다.

 */
