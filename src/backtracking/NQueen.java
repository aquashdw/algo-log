package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NQueen {
    private int[] queenPos;
    private int size;
    private int count;

    public int solution() throws IOException {
        size = Integer.parseInt(
                new BufferedReader(
                        new InputStreamReader(System.in)).readLine());
        queenPos = new int[size];
        count = 0;
        setQueenPos(0);
        return count;
    }

    private void setQueenPos(int row) {
        if (row == size)
            count++;
        else for (int i = 0; i < size; i++) {
            queenPos[row] = i;
            if (checkQueen(row)) setQueenPos(row + 1);
        }
    }

    private boolean checkQueen(int row) {
        for (int i = 0; i < row; i++) {
            if (queenPos[i] == queenPos[row])
                return false;
            else if (Math.abs(queenPos[i] - queenPos[row]) == row - i)
                return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new NQueen().solution());
    }
}
