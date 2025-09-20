package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/6778
public class Prob6778 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int antennas = Integer.parseInt(reader.readLine());
        int eyes = Integer.parseInt(reader.readLine());
        if (3 <= antennas && eyes <= 4) {
            System.out.println("TroyMartian");
        }
        if (antennas <= 6 && 2 <= eyes) {
            System.out.println("VladSaturnian");
        }
        if (antennas <= 2 && eyes <= 3) {
            System.out.println("GraemeMercurian");
        }
    }
}
