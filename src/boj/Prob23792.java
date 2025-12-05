package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/23792
public class Prob23792 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] foods = new int[3][];
        for (int i = 0; i < 3; i++) {
            foods[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }

        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        reader.lines().limit(tests).forEach(line -> {
            int[] query = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int k = query[3];
            int[] found = {-1, -1};
            for (int i = 0; i < 3; i++) {
                int[] target = foods[i];
                int low = 0;
                int high = query[i] - 1;
                while (low <= high) {
                    int mid = (low + high) / 2;
                    int count = mid + 1;
                    count += IntStream.range(i + 1, i + 3)
                            .map(idx -> idx % 3)
                            .map(idx -> {
                                return -Arrays.binarySearch(foods[idx], 0, query[idx], target[mid]) - 1;
                            })
                            .sum();
                    if (count == k) {
                        found[0] = i + 1;
                        found[1] = mid + 1;
                        break;
                    } else if (count > k) {
                        high = mid - 1;
                    } else {
                        low = mid + 1;
                    }
                }
                if (found[0] != -1) break;
            }
            answer.append(found[0]).append(" ").append(found[1]).append('\n');
        });
        System.out.print(answer);
    }
}
