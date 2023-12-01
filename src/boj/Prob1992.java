package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1992 {
    private char[][] image;
    private StringBuilder quadTree;
    public void solution() throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        image = new char[n][];
        for (int i = 0; i < n; i++) {
            image[i] = reader.readLine().toCharArray();
        }
        quadTree = new StringBuilder();
        compressQuad(n, 0, 0);
        System.out.println(quadTree);
    }

    public void compressQuad(int n, int x, int y) {

        boolean success = true;
        char init = image[x][y];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (image[x + i][y + j] != init) {
                    success = false;
                    break;
                }
            }
        }
        if (!success) {
            quadTree.append('(');
            int half = n / 2;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    compressQuad(half, x + half * i, y + half * j);
                }
            }
            quadTree.append(')');
        } else {
            quadTree.append(init);
        }
    }

    public static void main(String[] args) throws IOException {
        new Prob1992().solution();
    }
}
