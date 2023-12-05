package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181938
public class Prob181938 {
    public int solution(int a, int b) {
        StringBuilder aBuilder = new StringBuilder();
        int resultA = Integer.parseInt(aBuilder
                .append(a)
                .append(b)
                .toString());
        int resultB = 2 * a * b;
        return Math.max(resultA, resultB);
    }
}
