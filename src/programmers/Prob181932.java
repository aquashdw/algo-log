package programmers;

// 기초 - 문자열 다루기
// https://school.programmers.co.kr/learn/courses/30/lessons/181932
public class Prob181932 {
    public String solution(String code) {
        StringBuilder answerBuilder = new StringBuilder();
        int mode = '0';
        for(int i = 0; i < code.length(); i++) {
            char letter = code.charAt(i);
            // ascii 기준 '1' - '0' == 1, '1' - '1' == 0
            if (letter == '1') mode = '1' - mode + '0';
            else if(i % 2 == mode - '0') {
                answerBuilder.append(letter);
            }
        }
        String answer = answerBuilder.toString();
        return answer.isEmpty() ? "EMPTY" : answer;
    }

    public static void main(String[] args) {
        new Prob181932().solution("abc1abc1abc");
    }
}
