package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181904
public class Prob181904 {
    public String solution(String myString, int m, int c) {
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = c - 1; i < myString.length(); i += m) {
            answerBuilder.append(myString.charAt(i));
        }

        return answerBuilder.toString();
    }
}
