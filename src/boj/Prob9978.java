package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/9978
public class Prob9978 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        String line;
        while (!(line = reader.readLine()).equals("ENDOFINPUT")) {
            int n = Integer.parseInt(line.split(" ")[1]);
            int[][] durations = new int[n][];
            int[] sums = new int[n];
            for (int i = 0; i < n; i++) {
                durations[i] = Arrays.stream(reader.readLine().split(" "))
                        .mapToInt(Integer::parseInt).toArray();
                sums[i] = Arrays.stream(durations[i]).sum();
            }
            int waitStart = Integer.parseInt(reader.readLine());
            int[] timeLeft = Arrays.stream(sums).map(sum -> waitStart % sum)
                    .toArray();

            int minTimeLeft = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (timeLeft[i] == 0) {
                    minTimeLeft = 0;
                    break;
                }
                for (int next : durations[i]) {
                    if (timeLeft[i] <= next) {
                        minTimeLeft = Math.min(minTimeLeft, next - timeLeft[i]);
                        break;
                    }
                    timeLeft[i] -= next;
                }
            }
            answer.append(minTimeLeft).append('\n');
            reader.readLine();
        }
        System.out.print(answer);
    }
}
