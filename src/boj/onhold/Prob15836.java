package boj.onhold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/15836
public class Prob15836 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> inputLines = new ArrayList<>();
        reader.lines().takeWhile(line -> !line.startsWith("0 0 0 0")).forEach(inputLines::add);
        StringBuilder answer = new StringBuilder();
        int testCase = 0;
        for (int i = 0; i < inputLines.size(); i++) {
            answer.append(String.format("Case #%d:%n", ++testCase));
            int[] dims = Arrays.stream(inputLines.get(i).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (dims[1] != dims[2]) {
                i += dims[0] + dims[2];
                answer.append("undefined\n");
                continue;
            }
            i++;
            int fI1 = i;
            int[][] a = new int[dims[0]][];
            IntStream.range(0, dims[0]).forEach(idx -> a[idx] = Arrays.stream(inputLines.get(fI1 + idx).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray());

            int fI2 = i + dims[0];
            int[][] b = new int[dims[2]][];
            IntStream.range(0, dims[2]).forEach(idx -> b[idx] = Arrays.stream(inputLines.get(fI2 + idx).split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray());
            i += dims[0] + dims[2] - 1;
            int[][] product = new int[dims[0]][dims[3]];
            for (int j = 0; j < dims[0]; j++) {
                answer.append("| ");
                for (int k = 0; k < dims[3]; k++) {
                    int sum = 0;
                    for (int l = 0; l < dims[1]; l++) {
                        sum += a[j][l] * b[l][k];
                    }
                    product[j][k] = sum;
                }
                answer.append(String.join(" ", Arrays.stream(product[j])
                        .mapToObj(String::valueOf)
                        .toArray(String[]::new)));
                answer.append(" |\n");
            }
        }

        System.out.print(answer);
    }
}


/*
2 3 3 2
1 2 3
3 2 1
4 5
6 7
8 9
2 3 2 3
1 2 3
3 2 1
4 5 6
7 8 9
2 3 2 3
1 2 3
3 2 1
4 5 6
7 8 9
2 3 3 2
1 2 3
3 2 1
4 5
6 7
8 9
0 0 0 0
 */