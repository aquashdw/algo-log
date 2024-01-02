package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Stream;

// https://www.acmicpc.net/problem/9466
public class Prob9466 {
    private static int students;
    private static int[] favoring;
    private static final StringBuilder answerBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            students = Integer.parseInt(reader.readLine());
            favoring = Stream.concat(Stream.of("0"), Arrays.stream(reader.readLine().split(" ")))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            solve();
        }

        System.out.println(answerBuilder);
    }

    private static void solve() {
        boolean[] visited = new boolean[students + 1];
        boolean[] grouped = new boolean[students + 1];
        visited[0] = true;
        grouped[0] = true;

        for (int i = 1; i < students + 1; i++) {
            if (visited[i]) continue;
            Stack<Integer> reverse = new Stack<>();
            int next = i;
            while (true) {
                int now = next;
                if (visited[now]) {
                    while (!reverse.empty() && reverse.contains(now)) {
                        int came = reverse.pop();
                        grouped[came] = true;
                        if (came == now) break;
                    }
                    break;
                }
                visited[now] = true;
                next = favoring[now];
                reverse.push(now);
            }
        }

        int count = 0;
        for (boolean isGrouped: grouped) {
            if (!isGrouped) count++;
        }

        answerBuilder.append(count).append("\n");
    }
}
