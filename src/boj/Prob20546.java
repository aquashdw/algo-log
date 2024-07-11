package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/20546
public class Prob20546 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int baseAsset = Integer.parseInt(reader.readLine());
        int[] prices = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bnpAsset = baseAsset;
        int bnpStocks = 0;
        int tttAsset = baseAsset;
        int tttStocks = 0;
        int tttUp = 0;
        int tttDown = 0;
        for (int i = 0; i < prices.length; i++) {
            bnpStocks += bnpAsset / prices[i];
            bnpAsset %= prices[i];
            if (i == 0) continue;

            if (prices[i - 1] > prices[i]) {
                tttDown++;
                tttUp = 0;
                if (tttDown == 3) {
                    tttDown = 0;
                    tttStocks += tttAsset / prices[i];
                    tttAsset %= prices[i];
                }
            }
            if (prices[i - 1] < prices[i]) {
                tttUp++;
                tttDown = 0;
                if (tttUp == 3) {
                    tttUp = 0;
                    tttAsset += tttStocks * prices[i];
                    tttStocks = 0;
                }
            }
        }

        bnpAsset += bnpStocks * prices[13];
        tttAsset += tttStocks * prices[13];
        switch (Integer.compare(bnpAsset, tttAsset)) {
            case -1 -> System.out.println("TIMING");
            case 0 -> System.out.println("SAMESAME");
            case 1 -> System.out.println("BNP");
        }
    }
}
