package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/29332
public class Prob29332 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int clues = Integer.parseInt(reader.readLine());
        if (clues < 4) {
            System.out.println("Infinity");
            return;
        }
        int leftBorder = -1_000_000_001;
        int rightBorder = 1_000_000_001;
        int topBorder = 1_000_000_001;
        int bottomBorder = -1_000_000_001;
        for (int i = 0; i < clues; i++) {
            String[] clue = reader.readLine().split(" ");
            switch (clue[2]) {
                case "L":
                    rightBorder = Math.min(Integer.parseInt(clue[0]), rightBorder);
                    break;
                case "R":
                    leftBorder = Math.max(Integer.parseInt(clue[0]), leftBorder);
                    break;
                case "U":
                    bottomBorder = Math.max(Integer.parseInt(clue[1]), bottomBorder);
                    break;
                case "D":
                    topBorder = Math.min(Integer.parseInt(clue[1]), topBorder);
                    break;
            }
        }
        if (
                leftBorder == -1_000_000_001 || rightBorder == 1_000_000_001 ||
                        topBorder == 1_000_000_001 || bottomBorder == -1_000_000_001
        ) {
            System.out.println("Infinity");
            return;
        }
        long xDiff = rightBorder - leftBorder - 1;
        long yDiff = topBorder - bottomBorder - 1;
        System.out.println(xDiff * yDiff);
//        BigInteger xDiff = BigInteger.valueOf(rightBorder - leftBorder - 1);
//        BigInteger yDiff = BigInteger.valueOf(topBorder - bottomBorder - 1);
//        System.out.println(xDiff.multiply(yDiff));
    }
}