package programmers;


// https://school.programmers.co.kr/learn/courses/30/lessons/181935
public class Prob181935 {
    public int solution(int n) {
        int answer = 0;
        if (n % 2 == 0) {
            for (int i = 0; i < n + 1; i += 2) {
                answer += i * i;
            }
        }
        else {
            for (int i = 1; i < n + 1; i += 2) {
                answer += i;
            }
        }
        return answer;
    }
}
