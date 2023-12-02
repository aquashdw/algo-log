package programmers;


// 기초
// https://school.programmers.co.kr/learn/courses/30/lessons/181884
public class Prob181884 {
    public int solution(int[] numbers, int n) {
        int answer = 0;
        for (int number : numbers) {
            answer += number;
            if (answer > n) return answer;
        }
        return answer;
    }
}
