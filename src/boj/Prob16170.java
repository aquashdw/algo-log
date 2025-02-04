package boj;

import java.time.LocalDateTime;
import java.time.ZoneId;

// https://www.acmicpc.net/problem/16170
public class Prob16170 {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now(ZoneId.of("UTC-0"));
        System.out.printf("%d%n%02d%n%02d%n", now.getYear(), now.getMonthValue(), now.getDayOfMonth());
    }
}
