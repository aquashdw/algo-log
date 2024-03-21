package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


// https://www.acmicpc.net/problem/1966
public class Prob1966 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < cases; i++) {
            int position = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray()[1];
            int[] docs = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            answer.append(solve(position, docs)).append('\n');
        }
        System.out.print(answer);
    }

    private static int solve(int position, int[] docs) {
        int[] sorted = Arrays.stream(docs).sorted().toArray();
        int currentImp = docs.length - 1;

        Queue<Integer> printQueue = new LinkedList<>();
        int printCount = 0;
        for (int doc: docs) printQueue.offer(doc);
        while (!printQueue.isEmpty()) {
            int next = printQueue.poll();
            if (next < sorted[currentImp]) {
                printQueue.offer(next);
                position--;
                if (position < 0)
                    position = printQueue.size() - 1;
            }
            else {
                printCount++;
                currentImp--;
                position--;
                if (position < 0)
                    return printCount;
            }
        }

        return printCount;
    }
}
