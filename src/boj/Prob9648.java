package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;

// https://www.acmicpc.net/problem/9648
public class Prob9648 {
    private static final Set<Integer> thirty = Set.of(4, 6, 9, 11);
    private static final Set<Integer> thirtyOne = Set.of(1, 3, 5, 7, 8, 10, 12);

    private static int julianToDates(int year, int month, int days) {
        int sum = 365 * (year - 1) + (year - 1) / 4;
        for (int i = 1; i < month; i++) {
            if (i == 2) {
                sum += 28 + (year % 4 == 0 ? 1 : 0);
            }
            else if (thirty.contains(i)) {
                sum += 30;
            }
            else {
                sum += 31;
            }
        }
        return sum + days - 1;
    }

    private static boolean isLeap(int year) {
        return (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0));
    }

    private static int gregorianMonthDays(int year, int month) {
        if (thirty.contains(month)) return 30;
        if (thirtyOne.contains(month)) return 31;
        if (isLeap(year)) return 29;
        else return 28;
    }

    private static int[] daysToGregorian(int days) {
        int years = days / 366;
        days -= (years * 365) + (years / 4) - (years / 100) + (years / 400);
        years++;
        while (days > 365 || (days == 365 && !isLeap(years))) {
            days -= isLeap(years) ? 366 : 365;
            years++;
        }

        int months = 1;
        while (true) {
            int daysInMonths = gregorianMonthDays(years, months);
            if (days < daysInMonths) {
                break;
            }
            days -= daysInMonths;
            months++;
        }

        return new int[]{years, months, days + 1};
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        reader.lines().forEach(line -> {
            String[] split = line.split("-");
            int year = Integer.parseInt(split[0]);
            int month = Integer.parseInt(split[1]);
            int day = Integer.parseInt(split[2]);

            int days = julianToDates(year, month, day);
            int[] gregorian = daysToGregorian(days - 1);
            year = gregorian[0];
            month = gregorian[1];
            day = gregorian[2];

            answer.append(String.format("%d-%02d-%02d%n", year, month, day));
        });

        System.out.print(answer);
    }
}
