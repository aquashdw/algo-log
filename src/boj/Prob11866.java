package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


// https://www.acmicpc.net/problem/11866
public class Prob11866 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < nk[0]; i++) {
            queue.add(i + 1);
        }
        List<Integer> josephus = new ArrayList<>(nk[0]);
        int i = 0;
        while (!queue.isEmpty()) {
            i++;
            int now = queue.poll();
            if (i != nk[1]) queue.add(now);
            else {
                josephus.add(now);
                i = 0;
            }
        }
        StringBuilder answer = new StringBuilder();
        answer.append('<');
        answer.append(josephus.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", ")));
        answer.append('>');
        System.out.println(answer);
    }
}
