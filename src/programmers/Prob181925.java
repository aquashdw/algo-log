package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/181925
public class Prob181925 {
    public String solution(int[] numLog) {
        StringBuilder answerBuilder = new StringBuilder();
        for(int i = 0; i < numLog.length - 1; i++) {
            int diff = numLog[i + 1] - numLog[i];
            switch (diff) {
                case 1:
                    answerBuilder.append('w');
                    break;
                case -1:
                    answerBuilder.append('s');
                    break;
                case 10:
                    answerBuilder.append('d');
                    break;
                case -10:
                    answerBuilder.append('a');
                    break;
            }
        }

        return answerBuilder.toString();
    }
}
