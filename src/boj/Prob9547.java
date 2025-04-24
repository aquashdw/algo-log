package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/9547
public class Prob9547 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < tests; i++) {
            int[] info = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] candidates = new int[info[0] + 1];
            int[][] voters = new int[info[1]][];
            int maxVotes = 0;
            int maxCandidate = -1;
            for (int j = 0; j < info[1]; j++) {
                voters[j] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                candidates[voters[j][0]]++;
                if (candidates[voters[j][0]] > maxVotes) {
                    maxVotes = candidates[voters[j][0]];
                    maxCandidate = voters[j][0];
                }
            }

            if (maxVotes > info[1] / 2) {
                answer.append(maxCandidate).append(' ').append(1).append('\n');
                continue;
            }

            int firstVotes = -1;
            int firstCandidate = -1;
            int secondVotes = -1;
            int secondCandidate = -1;
            for (int j = 1; j < info[0] + 1; j++) {
                if (candidates[j] > firstVotes) {
                    secondVotes = firstVotes;
                    secondCandidate = firstCandidate;
                    firstVotes = candidates[j];
                    firstCandidate = j;
                } else if (candidates[j] > secondVotes) {
                    secondVotes = candidates[j];
                    secondCandidate = j;
                }
            }

            Arrays.fill(candidates, 0);
            for (int j = 0; j < info[1]; j++) {
                for (int k = 0; k < info[0]; k++) {
                    if (voters[j][k] == firstCandidate) {
                        candidates[firstCandidate]++;
                        break;
                    }
                    if (voters[j][k] == secondCandidate) {
                        candidates[secondCandidate]++;
                        break;
                    }
                }
            }
            maxCandidate = candidates[firstCandidate] > candidates[secondCandidate] ? firstCandidate : secondCandidate;
            answer.append(maxCandidate).append(' ').append(2).append('\n');
        }
        System.out.print(answer);
    }
}
