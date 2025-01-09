package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

// https://www.acmicpc.net/problem/1068
public class Prob1068 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<List<Integer>> childrenList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            childrenList.add(new ArrayList<>());
        }
        int[] parents = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int remove = Integer.parseInt(reader.readLine());
        int root = 0;
        for (int i = 0; i < n; i++) {
            if (parents[i] == -1) {
                root = i;
                continue;
            }
            if (parents[i] == remove || i == remove) continue;
            childrenList.get(parents[i]).add(i);
        }
        if (remove == root) {
            System.out.println(0);
            return;
        }

        Stack<Integer> toVisit = new Stack<>();
        toVisit.add(root);
        int count = 0;
        while (!toVisit.isEmpty()) {
            List<Integer> children = childrenList.get(toVisit.pop());
            if (children.isEmpty()) {
                count++;
                continue;
            }
            toVisit.addAll(children);
        }
        System.out.println(count);
    }
}
