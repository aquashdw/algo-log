package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://school.programmers.co.kr/learn/courses/30/lessons/181886
public class Prob181886 {
    public String[] solution(String[] names) {
        List<String> answerList = new ArrayList<>();
        for (int i = 0; i < names.length; i += 5) {
            answerList.add(names[i]);
        }

        return answerList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Prob181886().solution(new String[]{"nami", "ahri", "jayce", "garen", "ivern", "vex", "jinx"})));
    }
}
