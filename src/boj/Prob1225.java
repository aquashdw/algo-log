package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

// https://www.acmicpc.net/problem/1225
public class Prob1225 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] strNums = reader.readLine().split(" ");
        int[][] numbers = new int[2][];
        for (int i = 0; i < 2; i++) {
            numbers[i] = strNums[i].chars().map(c -> c - '0').toArray();
        }

        BigInteger result = BigInteger.ZERO;
        for (int i = 0; i < numbers[0].length; i++) {
            for (int j = 0; j < numbers[1].length; j++) {
                result = result.add(BigInteger.valueOf(numbers[0][i] * numbers[1][j]));
            }
        }
        System.out.println(result);
    }
}
