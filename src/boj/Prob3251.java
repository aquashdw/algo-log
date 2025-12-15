package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

// https://www.acmicpc.net/problem/3251
public class Prob3251 {
    private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        while (tests-- > 0) {
            String[] syllables = reader.lines().limit(4)
                    .map(line -> {
                        String[] words = line.split(" ");
                        String lastWord = words[words.length - 1];
                        int sylStart = 0;
                        for (int i = lastWord.length() - 1; i > 0; i--) {
                            if (!vowels.contains(lastWord.charAt(i))) continue;
                            sylStart = i;
                            break;
                        }
                        return lastWord.substring(sylStart).toLowerCase();
                    })
                    .toArray(String[]::new);

            if (syllables[0].equals(syllables[1]) && syllables[2].equals(syllables[3])) {
                if (syllables[0].equals(syllables[2])) answer.append("perfect");
                else answer.append("even");
            } else if (syllables[0].equals(syllables[2]) && syllables[1].equals(syllables[3])) answer.append("cross");
            else if (syllables[0].equals(syllables[3]) && syllables[1].equals(syllables[2])) answer.append("shell");
            else answer.append("free");
            answer.append('\n');
        }
        System.out.print(answer);
    }
}
