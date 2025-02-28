package boj;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// https://www.acmicpc.net/problem/27889
public class Prob27889 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(switch (reader.readLine()) {
            case "NLCS" -> "North London Collegiate School";
            case "BHA" -> "Branksome Hall Asia";
            case "KIS" -> "Korea International School";
            case "SJA" -> "St. Johnsbury Academy";
            default ->
                throw new IllegalStateException("Unexpected value");
        });
    }
}
