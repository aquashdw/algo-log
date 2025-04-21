package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/14641
public class Prob14641 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] connected = new boolean[26][26];
        Arrays.stream(connected).forEach(row -> Arrays.fill(row, false));

        int[] nm = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        reader.lines().limit(nm[0]).forEach(line -> {
            int[] translation = Arrays.stream(line.split(" "))
                    .mapToInt(str -> str.charAt(0) - 'a')
                    .toArray();
            connected[translation[0]][translation[1]] = true;
        });

        for (int mid = 0; mid < 26; mid++) {
            for (int start = 0; start < 26; start++) {
                for (int end = 0; end < 26; end++) {
                    if ((connected[start][mid] && connected[mid][end]) || start == end) {
                        connected[start][end] = true;
                    }
                }
            }
        }

        StringBuilder answer = new StringBuilder();
        reader.lines().limit(nm[1]).forEach(line -> {
            String[] words = line.split(" ");
            if (words[0].length() != words[1].length()) {
                answer.append("no\n");
                return;
            }
            for (int i = 0; i < words[0].length(); i++) {
                if (!connected[words[0].charAt(i) - 'a'][words[1].charAt(i) - 'a']) {
                    answer.append("no\n");
                    return;
                }
            }
            answer.append("yes\n");
        });

        System.out.print(answer);
    }
}
