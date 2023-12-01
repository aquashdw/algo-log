package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1343 {
    public String solution() throws IOException {
        String board = new BufferedReader(new InputStreamReader(System.in)).readLine();

        StringBuilder answerBuilder = new StringBuilder();
        int xCount = 0;
        for (int i = 0; i < board.length(); i++) {
            if (board.charAt(i) == 'X') xCount++;
            else if (xCount % 2 == 1) return "-1";
            else {
                fillBoard(xCount, answerBuilder);
                xCount = 0;
                answerBuilder.append(".");
            }
        }

        if (xCount % 2 == 1) return "-1";
        else {
            fillBoard(xCount, answerBuilder);
        }

        return answerBuilder.toString();
    }

    private void fillBoard(int xCount, StringBuilder answerBuilder) {
        while (xCount > 0) {
            if (xCount >= 4) {
                answerBuilder.append("AAAA");
                xCount -= 4;
            }
            else {
                answerBuilder.append("BB");
                xCount -= 2;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Prob1343().solution());
    }
}
