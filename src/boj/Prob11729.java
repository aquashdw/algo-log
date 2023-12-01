package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob11729 {
    private StringBuilder towerBuilder;
    public static void main(String[] args) throws IOException {
        new Prob11729().solution();
    }

    public void solution() throws IOException {
        int n = Integer.parseInt(new BufferedReader(new InputStreamReader(System.in)).readLine());
        towerBuilder = new StringBuilder();
        towerBuilder.append((int) (Math.pow(2, n) - 1)).append('\n');
        hanoi(n, 1, 3, 2);
        System.out.println(towerBuilder);
    }

    public void hanoi(int height, int start, int end, int other) {
        if (height == 1) {
            towerBuilder.append(start + " " + end + "\n");
        }
        else {
            hanoi(height - 1, start, other, end);
            towerBuilder.append(start + " " + end + "\n");
            hanoi(height -1, other, end, start);
        }
    }
}
