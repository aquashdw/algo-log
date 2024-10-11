package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14298
public class Prob14298 {
    private static int count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            answer.append("Case #").append(i + 1).append(": ");
            int[] toVote = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            int sum = toVote[0] + toVote[1];
            long dividend = 1;
            for (int j = 0; j < toVote[1]; j++) {
                dividend *= (sum - j);
            }
            int divisor = 1;
            for (int j = 0; j < toVote[1]; j++) {
                divisor *= (j + 1);
            }
            long cases = dividend / divisor;
            toVote[0]--;
            count = 0;
            count(new int[]{1, 0}, toVote);
            answer.append((double) count / cases).append('\n');
        }
        System.out.println(answer);
    }

    private static void count(int[] votes, int[] toVote) {
        if (votes[0] == votes[1]) return;
        if (toVote[1] == 0 && votes[0] > votes[1]) {
            count++;
            return;
        }

        if (toVote[0] > 0) {
            votes[0]++;
            toVote[0]--;
            count(votes, toVote);
            votes[0]--;
            toVote[0]++;
        }

        if (toVote[1] > 0) {
            votes[1]++;
            toVote[1]--;
            count(votes, toVote);
            votes[1]--;
            toVote[1]++;
        }

    }
}
