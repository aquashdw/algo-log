package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/5532
public class Prob5532 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int vacation = Integer.parseInt(reader.readLine());
        int mathPages = Integer.parseInt(reader.readLine());
        int korPages = Integer.parseInt(reader.readLine());
        int mathDayPerPage = Integer.parseInt(reader.readLine());
        int korDayPerPage = Integer.parseInt(reader.readLine());

        int mathDays = (mathPages / mathDayPerPage) + (mathPages % mathDayPerPage == 0 ? 0 : 1);
        int korDays = (korPages / korDayPerPage) + (korPages % korDayPerPage == 0 ? 0 : 1);
        System.out.println(vacation - Math.max(mathDays, korDays));
    }
}
