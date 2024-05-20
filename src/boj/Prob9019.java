package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/9019
public class Prob9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            answer.append(solve(input[0], input[1])).append('\n');
        }
        System.out.print(answer);
    }

    private static String solve(int source, int target) {
        StringBuilder[] visitRoute = new StringBuilder[10000];
        visitRoute[source] = new StringBuilder();
        Queue<Integer> toVisit = new LinkedList<>();
        toVisit.offer(source);
        while (!toVisit.isEmpty()) {
            int now = toVisit.poll();
            if (now == target) break;

            int resultD = (now * 2) % 10000;
            if (visitRoute[resultD] == null) {
                visitRoute[resultD] = new StringBuilder();
                visitRoute[resultD].append(visitRoute[now]).append('D');
                toVisit.offer(resultD);
            }

            int resultS = now == 0 ? 9999 : now - 1;
            if (visitRoute[resultS] == null) {
                visitRoute[resultS] = new StringBuilder();
                visitRoute[resultS].append(visitRoute[now]).append('S');
                toVisit.offer(resultS);
            }

            int resultL = (now % 1000) * 10 + now / 1000;
            if (visitRoute[resultL] == null) {
                visitRoute[resultL] = new StringBuilder();
                visitRoute[resultL].append(visitRoute[now]).append('L');
                toVisit.offer(resultL);
            }

            int resultR = (now % 10) * 1000 + now / 10;
            if (visitRoute[resultR] == null) {
                visitRoute[resultR] = new StringBuilder();
                visitRoute[resultR].append(visitRoute[now]).append('R');
                toVisit.offer(resultR);
            }
        }
        return visitRoute[target].toString();
    }
}
