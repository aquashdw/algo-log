package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/9855
public class Prob9855 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        StringBuilder answer = new StringBuilder();
        int testCase = 1;
        while (!(line = reader.readLine()).equals("0 0 0")) {
            int[] info = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int[][] tables = {
                    IntStream.range(0, info[0]).map(i -> -1).toArray(),
                    IntStream.range(0, info[1]).map(i -> -1).toArray(),
            };

            int inserted = 0;
            while (inserted < info[2]) {
                int[] nextNums = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                for (int num : nextNums) {
                    int tableIdx = 0;
                    int[] table = tables[tableIdx];
                    int resident = num;

                    while (table[resident % table.length] != -1) {
                        int temp = table[resident % table.length];
                        table[resident % table.length] = resident;
                        resident = temp;
                        tableIdx++;
                        table = tables[tableIdx % 2];
                    }

                    table[resident % table.length] = resident;
                }

                inserted += nextNums.length;
            }

            answer.append(String.format("Case %d:%n", testCase));
            for (int i = 0; i < 2; i++) {
                if (Arrays.stream(tables[i]).allMatch(hash -> hash == -1)) continue;
                answer.append(String.format("Table %d%n", i + 1));
                int[] table = tables[i];
                for (int j = 0; j < table.length; j++) {
                    if (table[j] == -1) continue;
                    answer.append(String.format("%d:%d%n", j, table[j]));
                }
            }
            testCase++;
        }
        System.out.print(answer);

    }
}
