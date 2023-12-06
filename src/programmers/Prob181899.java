package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181899
public class Prob181899 {
    public int[] solution(int start, int end) {
        int[] answer = new int[start - end + 1];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = start - i;
        }
        return answer;
    }
}
