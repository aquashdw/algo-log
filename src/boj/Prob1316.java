package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        int count = 0;
        for (int i = 0; i < tests; i++) {
            String line = reader.readLine();
            if (isGrouped(line)) count++;
        }
        System.out.println(count);
    }

    private static boolean isGrouped(String word) {
        boolean[] visited = new boolean[26];
        char[] letters = word.toCharArray();
        visited[letters[0] - 'a'] = true;
        char last = letters[0];
        for (int i = 1; i < word.length(); i++) {
            if (letters[i] != last) {
                if (visited[letters[i] - 'a'])
                    return false;
                last = letters[i];
                visited[last - 'a'] = true;
            }
        }

        return true;
    }
}
