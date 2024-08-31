package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/17123
public class Prob17123 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int[] nm = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int[][] matrix = new int[nm[0]][];
            for (int j = 0; j < nm[0]; j++) {
                matrix[j] = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();
            }

            int[] rowSums = new int[nm[0]];
            int[] colSums = new int[nm[0]];
            for (int j = 0; j < nm[0]; j++) {
                rowSums[j] = Arrays.stream(matrix[j]).sum();
            }
            for (int j = 0; j < nm[0]; j++) {
                int colSum = 0;
                for (int k = 0; k < nm[0]; k++) {
                    colSum += matrix[k][j];
                }
                colSums[j] = colSum;
            }

            for (int j = 0; j < nm[1]; j++) {
                int[] operation = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt)
                        .toArray();

                int startY = operation[0] - 1;
                int startX = operation[1] - 1;
                int endY = operation[2];
                int endX = operation[3];
                int operand = operation[4];

                int xDiff = endX - startX;
                for (int k = startY; k < endY; k++) {
                    rowSums[k] += xDiff * operand;
                }

                int yDiff = endY - startY;
                for (int k = startX; k < endX; k++) {
                    colSums[k] += yDiff * operand;
                }
            }

            answer.append(Arrays.stream(rowSums)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "))).append('\n');
            answer.append(Arrays.stream(colSums)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(" "))).append('\n');

        }
        System.out.println(answer.toString().trim());
    }
}
