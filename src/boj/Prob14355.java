package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

// https://www.acmicpc.net/problem/14355
public class Prob14355 {
    private static final int prDiff = Math.abs('P' - 'R');
    private static final int rsDiff = Math.abs('R' - 'S');
    private static final int spDiff = Math.abs('S' - 'P');

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int[] count = Arrays.stream(reader.readLine().split(" "))
                    .skip(1)
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int temp = count[0];
            count[0] = count[1];
            count[1] = temp;
            String match = makeMatches(count);
            answer.append("Case #")
                    .append(i + 1)
                    .append(": ")
                    .append(match)
                    .append('\n');
        }
        System.out.println(answer);
    }

    private static String makeMatches(int[] count) {
        int sum = Arrays.stream(count).sum();
        char[] tournament = new char[sum];
        if(recursive(sum, 0, count, tournament)) {
            StringBuilder converted = new StringBuilder();
            for (char player : tournament) {
                converted.append(player);
            }
            return converted.toString();
        }
        return "IMPOSSIBLE";
    }

    private static boolean recursive(int height, int depth, int[] count, char[] tournament) {
        if (height == depth) {
            return checkValid(tournament);
        }

        for (int i = 0; i < 3; i++) {
            if (count[i] == 0) continue;
            count[i]--;
            tournament[depth] = switch (i) {
                case 0 -> 'P';
                case 1 -> 'R';
                case 2 -> 'S';
                default -> throw new Error("iterative for loop error");
            };
            if (recursive(height, depth + 1, count, tournament))
                return true;
            count[i]++;
        }
        return false;
    }

    private static boolean checkValid(char[] tournament) {
        Queue<Character> matches = new LinkedList<>();
        for (char player : tournament) {
            matches.offer(player);
        }
        while (matches.size() > 1) {
            char left = matches.poll();
            char right = matches.poll();
            int diff = Math.abs(left - right);
            if (diff == prDiff) matches.offer('P');
            else if (diff == rsDiff) matches.offer('R');
            else if (diff == spDiff) matches.offer('S');
            else return false;
        }
        return true;
    }
}
