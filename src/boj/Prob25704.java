package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/25704
public class Prob25704 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int coupons = Integer.parseInt(reader.readLine());
        int price = Integer.parseInt(reader.readLine());
        int minPrice = price;
        if (coupons >= 5) {
            minPrice = Math.min(minPrice, Math.max(price - 500, 0));
        }
        if (coupons >= 10) {
            minPrice = Math.min(minPrice, Math.max(price / 100 * 90, 0));
        }
        if (coupons >= 15) {
            minPrice = Math.min(minPrice, Math.max(price - 2000, 0));
        }
        if (coupons >= 20) {
            minPrice = Math.min(minPrice, Math.max(price / 100 * 75, 0));
        }
        System.out.println(minPrice);
    }
}
