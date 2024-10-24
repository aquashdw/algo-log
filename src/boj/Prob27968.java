package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/27968
public class Prob27968 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int m = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray()[0];
        long[] candyRounds = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();

        long[] candySums = new long[candyRounds.length];
        candySums[0] = candyRounds[0];
        for (int i = 1; i < candySums.length; i++) {
            candySums[i] = candySums[i - 1] + candyRounds[i];
        }

        StringBuilder answer = new StringBuilder();
        reader.lines().limit(m).mapToLong(Long::parseLong).forEach(wanted -> {
            int front = 0;
            int back = candySums.length - 1;
            int mid = Integer.MIN_VALUE;
            while (front <= back) {
                mid = (front + back) / 2;
                if (candySums[mid] == wanted) {
                    break;
                }

                if (candySums[mid] > wanted) {
                    back = mid - 1;
                } else if (candySums[mid] < wanted) {
                    front = mid + 1;
                }
            }
            if (candySums[mid] < wanted) {
                if (mid < candySums.length - 1) answer.append(mid + 2).append('\n');
                else answer.append("Go away!\n");
            }
            else answer.append(mid + 1).append('\n');
        });
        System.out.print(answer);
    }
}
