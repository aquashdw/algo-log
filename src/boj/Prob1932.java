package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


// https://www.acmicpc.net/problem/1932
public class Prob1932 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] numbers = new int[n][n];
        for (int i = 0; i < n; i++) {
            int[] row = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            System.arraycopy(row, 0, numbers[i], 0, i + 1);
            /*for (int j = 0; j < i + 1; j++) {
                numbers[i][j] = row[j];
            }*/
        }

        int[][] memory = new int[n][n];
        memory[0][0] = numbers[0][0];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i + 1; j++) {
                int current = numbers[i][j];
                if (j == 0) memory[i][j] = current + memory[i - 1][j];
                else if (j == i) memory[i][j] = current + memory[i - 1][j - 1];
                else memory[i][j] = current + Math.max(memory[i - 1][j], memory[i - 1][j - 1]);
            }
        }

        int[] lastRow = memory[n - 1];
        System.out.println(Arrays.stream(lastRow).max().getAsInt());
    }
}
