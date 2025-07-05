package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

// https://www.acmicpc.net/problem/20362
public class Prob20362 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        String winner = info[1] + ' ';
        Map<String, Integer> answerCount = new HashMap<>();
        String answer = null;
        for (int i = 0; i < n; i++) {
            String chat = reader.readLine();
            answer = chat.split(" ")[1];
            if (chat.startsWith(winner))
                break;

            answerCount.put(answer, answerCount.getOrDefault(answer, 0) + 1);
        }

        System.out.println(answerCount.getOrDefault(answer, 0));
    }
}
