package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181903
public class Prob181903 {
    public String solution(int q, int r, String code) {
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = r; i < code.length(); i += q) {
            answerBuilder.append(code.charAt(i));
        }
        return answerBuilder.toString();
    }
}
