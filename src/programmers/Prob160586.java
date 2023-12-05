package programmers;

import java.util.Arrays;
import java.util.HashMap;


// https://school.programmers.co.kr/learn/courses/30/lessons/160586
public class Prob160586 {
    public int[] solution(String[] keymap, String[] targets) {
        int[] answer = new int[targets.length];
        HashMap<Character, Integer> minHits = new HashMap<>();
        for (int i = 0; i < targets.length; i++) {
            String target = targets[i];
            int hitSum = 0;
            for (int j = 0; j < target.length(); j++) {
                char targetChar = target.charAt(j);
                if (minHits.containsKey(targetChar)) {
                    hitSum += minHits.get(targetChar);
                    continue;
                }
                int minHit = 101;
                for (String keys : keymap) {
                    for (int k = 0; k < keys.length(); k++) {
                        if (keys.charAt(k) == targetChar) {
                            minHit = Math.min(minHit, k);
                            break;
                        }
                    }
                }
                if (minHit == 101) {
                    hitSum = -1;
                    break;
                }
                hitSum += minHit + 1;
                minHits.put(targetChar, minHit + 1);
            }
            answer[i] = hitSum;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Prob160586().solution(
                new String[]{"ABACD", "BCEFD"},
                new String[]{"ABCD", "AABB"}
        )));
        System.out.println(Arrays.toString(new Prob160586().solution(
                new String[]{"BC", "CDB"},
                new String[]{"BB"}
        )));
    }
}
