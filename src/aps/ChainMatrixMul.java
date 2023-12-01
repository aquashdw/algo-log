package aps;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


// 11049
public class ChainMatrixMul {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int matrixCount = Integer.parseInt(reader.readLine());
        int[][] matrices = new int[matrixCount][];
        for (int i = 0; i < matrixCount; i++) {
            StringTokenizer matrixToken = new StringTokenizer(reader.readLine());
            matrices[i] = new int[]{
                    Integer.parseInt(matrixToken.nextToken()),
                    Integer.parseInt(matrixToken.nextToken())
            };
        }

        int[][] dp = new int[matrixCount][matrixCount];

        for (int i = 1; i < matrixCount; i++) {
            for (int j = 0; j < matrixCount - i; j++) {
                dp[j][j + i] = Integer.MAX_VALUE;
                for (int k = j; k < i + j; k++) {
                    dp[j][j + i] = Math.min(
                            dp[j][j + i],
                            dp[j][k] + dp[k + 1][j + i] + matrices[j][0] * matrices[j + i][1] * matrices[k][1]
                    );
                }
            }
        }

        return dp[0][matrixCount - 1];
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new ChainMatrixMul().solution());
    }
}
