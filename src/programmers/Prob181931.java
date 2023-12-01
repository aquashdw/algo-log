package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181931
public class Prob181931 {
    public int solution(int a, int d, boolean[] included) {
        int answer = 0;
        for(int i = 0; i < included.length; i++) {
            if(included[i]) answer += a;
            a = a + d;
        }
        return answer;
    }
}
