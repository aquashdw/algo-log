package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// https://school.programmers.co.kr/learn/courses/30/lessons/176963
public class Prob176963 {
    public int[] solution(String[] names, int[] yearning, String[][] photos) {
        // Map 활용
        int[] answer = new int[photos.length];
        Map<String, Integer> yearnMap = new HashMap<>();
        for (int i = 0; i < names.length; i++){
            yearnMap.put(names[i], yearning[i]);
        }

        for (int i = 0; i < photos.length; i++) {
            String[] photo = photos[i];
            int sum = 0;
            for (String person : photo) {
                sum += yearnMap.getOrDefault(person, 0);
            }
            answer[i] = sum;
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Prob176963().solution(
                new String[]{"may", "kein", "kain", "radi"},
                new int[]{5, 10, 1, 3},
                new String[][]{
                        {"may", "kein", "kain", "radi"},
                        {"may", "kein", "brin", "deny"},
                        {"kon", "kain", "may", "coni"}
                }
        )));
    }
}
