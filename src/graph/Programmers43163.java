package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers43163 {

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        if(!Arrays.asList(words).contains(target)) return answer;

        boolean[] visited = new boolean[words.length];
        int[] distance = new int[words.length];
        Queue<Integer> toVisit = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if (similar(begin, words[i])) {
                toVisit.offer(i);
                distance[i] = 1;
            }
        }
        while (!toVisit.isEmpty()) {
            int nextIdx = toVisit.poll();
            String nextWord = words[nextIdx];
            if (nextWord.equals(target)) {
                answer = distance[nextIdx];
                break;
            }

            for (int i = 0; i < words.length; i++) {
                if (similar(nextWord, words[i]) && !visited[i]) {
                    toVisit.add(i);
                    visited[i] = true;
                    distance[i] = distance[nextIdx] + 1;
                }
            }
        }

        return answer;
    }

    private boolean similar(String word, String target) {
        int k = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == target.charAt(i)) k++;
        }
        return k == word.length() - 1;
    }

    public static void main(String[] args) {
        System.out.println(
                new Programmers43163().solution("hit", "cog", new String[]{
                        "hot", "dot", "dog", "lot", "log", "cog"
                })
        );
        System.out.println(
                new Programmers43163().solution("hit", "cog", new String[]{
                        "hot", "dot", "dog", "lot", "log"
                })
        );
    }
}
