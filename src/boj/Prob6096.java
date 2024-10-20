package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/6096
public class Prob6096 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int total = nk[0];
        int minSpace = nk[1];
        // every place can be cows or bulls
        if (minSpace == 0) {
            System.out.println(IntStream.range(0, total).reduce(1, (prev, ignore) -> (prev * 2) % 5000011));
            return;
        }
        // only one bull can be there
        if (minSpace > total - 2) {
            System.out.println(total + 1);
            return;
        }

        // dp keeps track of how many sequences ends with bull in position i
        // + how many sequences before
        // i == 0 -> no bulls, i == total -> last animal is bull
        int[] dp = new int[total + 1];
        // to be able to put at least two bulls, we need:
        // front bull + back bull + space between
        // until that space is secured, only one bull can be placed,
        // hence only one sequence is possible
        dp[0] = 1;
        for (int i = 1; i < minSpace + 2; i++) {
            dp[i] = (dp[i - 1] + 1) % 5000011;
        }

        // after more than minSpace + 2 space is secured,
        // the sequences available are the sum of all sequences available
        // with the (currentSpace - minSpace) amount of spaces
        for (int i = minSpace + 2; i < total + 1; i++) {
            dp[i] = (dp[i - 1] + dp[i - minSpace - 1]) % 5000011;
        }
        System.out.println(dp[total]);
    }
}
/*
2 1
CC
BC
CB

3 1
CCC
BCC
CBC
CCB
BCB

4 1
CCCC
BCCC
CBCC
CCBC, BCBC
CCCB, BCCB, CBCB

5 2
CCCCC
BCCCC
CBCCC
CCBCC
CCCBC
BCCBC
CCCCB
BCCCB
CBCCB

5 1
CCCCC
BCCCC
CBCCC
CCBCC
BCBCC
CCCBC
BCCBC
XBCBC
CCCCB
BCCCB
XBCCB
XXBCB
XXBCB
 */
