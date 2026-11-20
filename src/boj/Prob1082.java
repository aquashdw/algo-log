package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;

public class Prob1082 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] prices = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt).toArray();
        int m = Integer.parseInt(reader.readLine());
        int[][] budget = new int[m + 1][3];

        int[] usableZeros = new int[m + 1];
        for (int i = prices[0]; i < m + 1; i++) {
            usableZeros[i] = usableZeros[i - prices[0]] + 1;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = n - 1; j > 0; j--) {
                int price = prices[j];
                // 이 숫자 못쓰면 스킵
                if (i - price < 0) continue;
                // 0을 엄청 많이 쓰고 이 숫자를 사용하는 경우에 사용할 수 있는 숫자 갯수가 더 많은지를 찾아야 한다.
                int makeDigits = usableZeros[i - price] + 1;  // 0을 다 쓰고 나를 쓰는 경우
                int lastDigit = 0;
                if (makeDigits <= budget[i - price][1] + 1) {  // 0과 나 하나 vs 나하나 나머지
                    // 초기화가 0 기준이기 때문에 여기서 다시 나머지 기준으로 초기화
                    makeDigits = budget[i - price][1] + 1;
                    lastDigit = budget[i - price][0];
                }

                // 일단 이번 숫자를 사용하면 현재 알고 있는 사용 가능한 숫자의 갯수가 이전보다 많아야 한다.
                if (makeDigits < budget[i][1]) continue;
                // 그리고 사용 가능한 숫자의 갯수가 같다면 값이 더 비싸야 한다.
                if (budget[i][1] == makeDigits && budget[i][0] >= j) continue;
                // 0에 이번에 고른 숫자
                budget[i][0] = j;
                // 1에 그래서 고른 숫자의 갯수
                budget[i][1] = makeDigits;
                // 2에 직전에 골랐던 숫자 (0이 나오면 재건축 중단을 위함)
                budget[i][2] = lastDigit;
            }

        }

        // 고른 숫자 살펴보고 제일 크게 만들기
        int[] counts = new int[10];
        int budgetLeft = m;
        while (budgetLeft > 0) {
            int collect = budget[budgetLeft][0];
            counts[collect]++;
            if (budget[budgetLeft][2] == 0) {
                counts[0] = usableZeros[budgetLeft - prices[collect]];
                break;
            }
            budgetLeft -= prices[collect];

        }

        StringBuilder answer = new StringBuilder();
        for (int i = 9; i >= 0; i--) {
            answer.append(String.valueOf(i).repeat(counts[i]));
        }
        System.out.println(answer.length() == 0 ? 0 : new BigInteger(answer.toString()));
    }
}
