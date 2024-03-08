package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob11047 {
    public int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] info = reader.readLine().split(" ");
        int coinKinds = Integer.parseInt(info[0]);
        int targetAmount = Integer.parseInt(info[1]);
        int[] coinAmounts = new int[coinKinds];
        // 역순 입력
        for (int i = 0; i < coinKinds; i++) {
            coinAmounts[coinKinds - i - 1] = Integer.parseInt(reader.readLine());
        }

        int coinUsed = 0;
        for (int i = 0; i < coinKinds; i++) {
            int coinAmount = coinAmounts[i];
            coinUsed += targetAmount / coinAmount;
            targetAmount %= coinAmount;
        }

        return coinUsed;
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Prob11047().solution());
    }
}
