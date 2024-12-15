package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

// https://www.acmicpc.net/problem/2314
public class Prob2314 {
    private static class Node {
        private int digit;
        private String binary;
        private int moves;

        public Node(int digit, String binary, int moves) {
            this.digit = digit;
            this.binary = binary;
            this.moves = moves;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder originBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            reader.readLine().chars().mapToObj(c -> c == 'P' ? '0' : '1').forEach(originBuilder::append);
        }
        String origin = originBuilder.toString();
        reader.readLine();
        StringBuilder targetBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            reader.readLine().chars().mapToObj(c -> c == 'P' ? '0' : '1').forEach(targetBuilder::append);
        }
        String target = targetBuilder.toString();
        int first = Integer.parseInt(origin, 2);
        int targetDigit = Integer.parseInt(target, 2);
        Set<Integer> visited = new HashSet<>();
        visited.add(first);
        Queue<Node> toVisit = new LinkedList<>();
        toVisit.add(new Node(first, origin, 0));
        int answer = Integer.MAX_VALUE;
        while (!toVisit.isEmpty()) {
            Node node = toVisit.poll();
            if (node.digit == targetDigit) {
                answer = node.moves;
                break;
            }
            char[] rep = node.binary.toCharArray();
            for (int i = 0; i < 3; i++) {
                if (rep[i] != rep[i + 1]) {
                    Node next = createNode(rep, i, i + 1, node.moves);
                    if (!visited.contains(next.digit)) {
                        visited.add(next.digit);
                        toVisit.add(next);
                    }
                }
                if (rep[i + 4] != rep[i + 5]) {
                    Node next = createNode(rep, i + 4, i + 5, node.moves);
                    if (!visited.contains(next.digit)) {
                        visited.add(next.digit);
                        toVisit.add(next);
                    }
                }
                if (rep[i + 8] != rep[i + 9]) {
                    Node next = createNode(rep, i + 8, i + 9, node.moves);
                    if (!visited.contains(next.digit)) {
                        visited.add(next.digit);
                        toVisit.add(next);
                    }
                }
                if (rep[i + 12] != rep[i + 13]) {
                    Node next = createNode(rep, i + 12, i + 13, node.moves);
                    if (!visited.contains(next.digit)) {
                        visited.add(next.digit);
                        toVisit.add(next);
                    }
                }
                int offset = i * 4;
                if (rep[offset] != rep[offset + 4]) {
                    Node next = createNode(rep, offset, offset + 4, node.moves);
                    if (!visited.contains(next.digit)) {
                        visited.add(next.digit);
                        toVisit.add(next);
                    }
                }
                if (rep[offset + 1] != rep[offset + 5]) {
                    Node next = createNode(rep, offset + 1, offset + 5, node.moves);
                    if (!visited.contains(next.digit)) {
                        visited.add(next.digit);
                        toVisit.add(next);
                    }
                }
                if (rep[offset + 2] != rep[offset + 6]) {
                    Node next = createNode(rep, offset + 2, offset + 6, node.moves);
                    if (!visited.contains(next.digit)) {
                        visited.add(next.digit);
                        toVisit.add(next);
                    }
                }
                if (rep[offset + 3] != rep[offset + 7]) {
                    Node next = createNode(rep, offset + 3, offset + 7, node.moves);
                    if (!visited.contains(next.digit)) {
                        visited.add(next.digit);
                        toVisit.add(next);
                    }
                }
            }

        }
        System.out.println(answer);
    }



    private static Node createNode(char[] rep, int swapA, int swapB, int moves) {
        char temp = rep[swapA];
        rep[swapA] = rep[swapB];
        rep[swapB] = temp;
        String next = new String(rep);
        int digit = Integer.parseInt(next, 2);
        Node result = new Node(digit, next, moves + 1);
        temp = rep[swapA];
        rep[swapA] = rep[swapB];
        rep[swapB] = temp;
        return result;
    }
}

/*
LLLL
LLLP
LLLL
PLLL

PLLL
PLLL
LLLL
LLLL
 */