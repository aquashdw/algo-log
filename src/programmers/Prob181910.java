package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181910
public class Prob181910 {
    public String solution(String myString, int n) {
        int startIndex = myString.length() - n;
        StringBuilder answerBuilder = new StringBuilder();
        for (int i = startIndex; i < myString.length(); i++) {
            answerBuilder.append(myString.charAt(i));
        }
        return answerBuilder.toString();

//        return myString
//                .substring(myString.length() - n);
    }
}
