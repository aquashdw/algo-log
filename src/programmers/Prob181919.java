package programmers;

import java.util.ArrayList;
import java.util.List;

// 기초 - Collatz
// https://school.programmers.co.kr/learn/courses/30/lessons/181919
public class Prob181919 {
    public int[] solution(int n) {
        List<Integer> answer = new ArrayList<>();
        while (n != 1) {
            answer.add(n);
            if (n % 2 == 0) n /= 2;
            else n = n * 3 + 1;
        }
        answer.add(1);
        return answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
