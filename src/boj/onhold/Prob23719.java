package boj.onhold;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/23791
public class Prob23719 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] korean = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] western = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int rank = 0;
        int kIdx = 0;
        int wIdx = 0;
        while (kIdx < n && wIdx < n) {
            if (korean[kIdx] < western[wIdx]) {
                korean[kIdx] = rank;
                rank++;
                kIdx++;
            }
            else {
                western[wIdx] = rank;
                rank++;
                wIdx++;
            }
        }
        while (kIdx < n) {
            korean[kIdx] = rank;
            rank++;
            kIdx++;
        }
        while (wIdx < n) {
            western[wIdx] = rank;
            rank++;
            wIdx++;
        }

        int queries = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int[] query : reader.lines().limit(queries).map(line -> Arrays.stream(line.split(" "))
                .mapToInt(Integer::parseInt)
                .toArray()).collect(Collectors.toList())) {
            int kRange = query[0];
            int wRange = query[1];
            int k = query[2];

            // 한식 꼴등이 양식 1등보다 더 앞선다.
            if (korean[0] > western[wRange - 1]) {
                // k가 양식 갯수보다 크면 한식에서 그 차이만큼
                if (k > wRange) {
                    answer.append(String.format("%d %d%n", 1, k - wRange));
                }
                // 아니면 양식에서 k 만큼
                else {
                    answer.append(String.format("%d %d%n", 2, k));
                }
                continue;
            }
            // 위 경우에서 한식과 양식을 바꾸면 끝
            if (western[0] > korean[kRange - 1]) {
                if (k > kRange) {
                    System.out.printf("%d %d%n", 2, k - wRange);
                }
                else {
                    System.out.printf("%d %d%n", 1, k);
                }
                continue;
            }

            int front = 0;
            int back = Math.max(korean[kRange - 1], western[wRange - 1]);
            kIdx = 0;
            wIdx = 0;
            while (front < back) {
                int midFood = (front + back) / 2;
                if (korean[kIdx] <= midFood) for (; kIdx < korean.length; kIdx++) {
                    if (korean[kIdx] > midFood) break;
                }
                else for (; kIdx > 0; kIdx--) {
                    if (korean[kIdx] <= midFood) {
                        if (korean[kIdx] == midFood) kIdx++;
                        break;
                    }
                }
                if (western[wIdx] <= midFood) for (; wIdx < western.length; wIdx++) {
                    if (western[wIdx] > midFood) break;
                }
                else for (; wIdx > 0; wIdx--) {
                    if (western[wIdx] <= midFood) {
                        if (western[wIdx] == midFood) wIdx++;
                        break;
                    }
                }
                int count = kIdx + wIdx;
                if (count > k) {
                    back = midFood;
                }
                else if (count < k) {
                    front = midFood;
                }
                else break;
            }
            if (kIdx == 0) {
                answer.append(String.format("%d %d%n", 2, wIdx));
                continue;
            }
            if (wIdx == 0) {
                answer.append(String.format("%d %d%n", 1, kIdx));
                continue;
            }
            int kFood = korean[kIdx - 1];
            int wFood = western[wIdx - 1];
            if (kFood > wFood) {
                answer.append(String.format("%d %d%n", 1, kIdx));
            }
            else {
                answer.append(String.format("%d %d%n", 2, wIdx));
            }
        }
        System.out.print(answer);
    }
}
/*
6
1 2 3 4 5 6
7 8 9 10 11 12
2
3 3 3
3 3 4

7
1 5 10 15 18 20 30
2 3 8 11 14 40 50
4
4 4 1
4 4 2
4 4 7
4 4 8

7
1 5 10 15 18 20 30
2 3 8 11 14 40 50
1
3 4 7

 */