package programmers;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/181895
public class Prob181895 {
    public int[] solution(int[] arr, int[][] intervals) {
        List<Integer> answerList = new ArrayList<>();
        for (int i = intervals[0][0]; i <= intervals[0][1]; i++) {
            answerList.add(arr[i]);
        }
        for (int i = intervals[1][0]; i <= intervals[1][1]; i++) {
            answerList.add(arr[i]);
        }
        return answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
