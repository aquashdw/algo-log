package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/8901
public class Prob8901 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tests = Integer.parseInt(reader.readLine());
        StringBuilder answer = new StringBuilder();
        for (int test = 0; test < tests; test++) {
            int[] chems = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int[] prices = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            int maxPrice = 0;
            // ab를 만드는 갯수 (a,b 중 적은거 만큼만 만들 수 있음)
            for (int i = 0; i <= Math.min(chems[0], chems[1]); i++) {
                // 기준가
                int price = prices[0] * i;
                // 남아있는 a
                int aLeft = chems[0] - i;
                // 남이있는 b
                int bLeft = chems[1] - i;

                // 남은걸로 ca를 최대한 만드는 경우
                int maxCaCnt = Math.min(aLeft, chems[2]);
                int maxCaPrice = maxCaCnt * prices[2] + Math.min(chems[2] - maxCaCnt, bLeft) * prices[1];
                // 남은걸로 bc를 최대한 만드는 경우
                int maxBcCnt = Math.min(bLeft, chems[2]);
                int maxBcPrice = maxBcCnt * prices[1] + Math.min(chems[2] - maxBcCnt, aLeft) * prices[2];
                price += Math.max(maxCaPrice, maxBcPrice);
                maxPrice = Math.max(maxPrice, price);
            }
            answer.append(maxPrice).append('\n');
        }
        System.out.print(answer);
    }
}
