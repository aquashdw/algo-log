package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/27198
public class Prob27198 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        int[] numbers = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).sorted().toArray();
        int numMax = Arrays.stream(numbers).max().orElse(0);
        int[] indices = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();

        int[] smalls = new int[numbers.length + 1];
        smalls[0] = 0;
        smalls[1] = numbers[0];
        for (int i = 2; i < smalls.length; i++) {
            smalls[i] = smalls[i - 1] + numbers[i - 1] - numbers[i - 2] - 1;
        }

        StringBuilder answer = new StringBuilder();
        int overBound = numMax - numbers.length + 1;
        for (int index : indices) {
            if (index > overBound) {
                answer.append(numMax + index - overBound).append(' ');
                continue;
            }

            int low = 0;
            int high = smalls.length - 1;
            int partition = -1;
            while (low < high) {
                int mid = (low + high) / 2;
                if (smalls[mid] >= index) {
                    high = mid;
                } else {
                    partition = mid;
                    low = mid + 1;
                }
            }

            if (partition == 0) {
                answer.append(index - 1).append(' ');
                continue;
            }

            int startNum = numbers[partition - 1];
            int smallsLeft = index - smalls[partition];
            answer.append(startNum + smallsLeft).append(' ');
        }
        System.out.println(answer);
    }
}

/*
4 10
1 2 6 10
1 2 3 4 5 6 7 8 10 11

0 3 4 5 7 8 9 11 12 13 14

4 10
2 3 6 10
1 2 3 4 5 6 7 8 9 10

0 0 2 2 3 3 3
0 1 4 5 7 8 9 11 12 13
 */

