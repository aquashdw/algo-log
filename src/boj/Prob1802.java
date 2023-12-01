package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prob1802 {

    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        for (int i = 0; i < tests; i++) {
            if (foldable(reader.readLine()))
                System.out.println("YES");
            else System.out.println("NO");
        }

    }

    private boolean foldable(String paper) {
        assert paper.length() % 2 == 1;
        if (paper.length() > 1) {
            int half = paper.length() / 2;
            if (!foldable(paper.substring(half + 1))) return false;
            if (!foldable(paper.substring(0, half))) return false;
            for (int i = 1; i < half + 1; i++) {
                if (paper.charAt(half + i) == paper.charAt(half - i))
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        new Prob1802().solution();
    }
}

/*
3
0
000
1000110
 */