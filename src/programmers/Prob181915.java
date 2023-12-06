package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181915
public class Prob181915 {
    public String solution(String myString, int[] indexList) {
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = 0; i < indexList.length; i++) {
            answerBuilder.append(myString.charAt(indexList[i]));
        }

        return answerBuilder.toString();
    }
}
