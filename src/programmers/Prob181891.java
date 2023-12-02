package programmers;

import java.util.ArrayList;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/181891
public class Prob181891 {
    public int[] solution(int[] numbers, int n) {
        List<Integer> answerList = new ArrayList<>();
        for (int i = n; i < numbers.length; i++) {
            answerList.add(numbers[i]);
        }
        for (int i = 0; i < n; i++) {
            answerList.add(numbers[i]);
        }

        return answerList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
