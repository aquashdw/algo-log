package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/159994
public class Prob159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1Idx = 0;
        int card2Idx = 0;
        for (String string : goal) {
            if (card1Idx < cards1.length && cards1[card1Idx].equals(string)) {
                card1Idx++;
                continue;
            }
            if (card2Idx < cards2.length && cards2[card2Idx].equals(string)) {
                card2Idx++;
                continue;
            }
            return "No";
        }
        return "Yes";
    }
}
