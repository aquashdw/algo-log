package programmers;


// https://school.programmers.co.kr/learn/courses/30/lessons/181939
public class Prob181939 {
    public int solution(int a, int b) {
        StringBuilder aBuilder = new StringBuilder();
        int resultA = Integer.parseInt(aBuilder
                .append(a)
                .append(b)
                .toString());
        StringBuilder bBuilder = new StringBuilder();
        int resultB = Integer.parseInt(bBuilder
                .append(b)
                .append(a)
                .toString());
        return Math.max(resultA, resultB);
    }
}
