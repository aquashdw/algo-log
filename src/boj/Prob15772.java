package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/15772
public class Prob15772 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] rRange = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int[] fRange = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        Map<String, int[]> records = new HashMap<>();
        StringBuilder answer = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split(" ");
            int action = Integer.parseInt(tokens[0]);
            String user = tokens[1];
            if (action == 1) {
                int[] record = records.computeIfAbsent(user, k -> new int[2]);
                record[0] = i;
                record[1]++;
                continue;
            }

            if (!records.containsKey(user)) {
                answer.append("None\n");
                continue;
            }

            int[] record = records.get(user);
            int recency = i - record[0];
            int frequency = record[1];
            if (recency > rRange[3]) {
                if (frequency > fRange[3]) answer.append("Can't Lose Them\n");
                else if (frequency > fRange[1]) answer.append("About to Leave\n");
                else answer.append("Lost\n");
            } else if (recency > rRange[2]) {
                if (frequency > fRange[1]) answer.append("About to Leave\n");
                else if (frequency > fRange[0]) answer.append("Hibernating\n");
                else answer.append("Lost\n");
            } else if (recency > rRange[1]) {
                if (frequency > fRange[2]) answer.append("Loyal Customer\n");
                else if (frequency > fRange[1]) answer.append("Need Attention\n");
                else answer.append("About to Sleep\n");
            } else if (recency > rRange[0]) {
                if (frequency > fRange[2]) answer.append("Loyal Customer\n");
                else if (frequency > fRange[0]) answer.append("Potential Loyalist\n");
                else answer.append("Promising\n");
            } else {
                if (frequency > fRange[3]) answer.append("Champion\n");
                else if (frequency > fRange[2]) answer.append("Loyal Customer\n");
                else if (frequency > fRange[0]) answer.append("Potential Loyalist\n");
                else answer.append("New Customer\n");
            }
        }
        System.out.print(answer);
    }

}
