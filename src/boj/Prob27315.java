package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// https://www.acmicpc.net/problem/27315
public class Prob27315 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int n = nm[0];
        int m = nm[1];
        if (n < m) {
            System.out.println(-1);
            return;
        }
        long[][] problems = new long[n][];
        for (int i = 0; i < n; i++) {
            problems[i] = Arrays.stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong).toArray();
        }
        long[] skills = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        skills[0] *= 2;

        Queue<long[]> solvable = new PriorityQueue<>((probA, probB) -> {
            if (probA[2] == 1 && probB[2] == 1) return 0;
            if (probA[2] == 1) return -1;
            if (probB[2] == 1) return 1;
            long probAImpl = probA[1] / (probA[3] == 1 ? 2 : 1);
            long probBImpl = probB[1] / (probB[3] == 1 ? 2 : 1);
            return Long.compare(probAImpl, probBImpl);
        });
        Queue<long[]> unsolvable = new PriorityQueue<>((probA, probB) -> {
            long probAIdea = probA[0] * (probA[3] == 1 ? 1 : 2);
            long probBIdea = probB[0] * (probB[3] == 1 ? 1 : 2);
            return Long.compare(probAIdea, probBIdea);
        });

        for (long[] problem : problems) {
            long reqIdea = problem[0] * (problem[3] == 1 ? 1 : 2);
            if (skills[0] >= reqIdea) solvable.add(problem);
            else unsolvable.add(problem);
        }

        int right = 0;
        long wrongs = 0;
        while (!solvable.isEmpty()) {
            long[] problem = solvable.poll();
            if (problem[2] != 1) {
                long impl = problem[1] / (problem[3] == 1 ? 2 : 1);
                wrongs += Math.max(0, impl - skills[1]);
            }
            right++;
            if (right == m) break;

            skills[0] += 2;
            skills[1]++;
            while (!unsolvable.isEmpty() && (unsolvable.peek()[0] * (unsolvable.peek()[3] == 1 ? 1 : 2)) <= skills[0]) {
                solvable.offer(unsolvable.poll());
            }
        }
        System.out.println(right >= m ? wrongs : -1);

    }
}
