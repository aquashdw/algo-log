package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/30427
public class Prob30427 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        int n = Integer.parseInt(reader.readLine());
        Set<String> people = reader.lines().limit(n).collect(Collectors.toSet());
        if (people.contains("dongho")) {
            System.out.println("dongho");
            return;
        }
        int witnessCount = Integer.parseInt(reader.readLine());
        reader.lines().limit(witnessCount)
                .forEach(people::remove);
        if (people.size() == 1) {
            System.out.println(people.iterator().next());
            return;
        }
        if (people.contains("bumin")) {
            System.out.println("bumin");
            return;
        }
        if (people.contains("cake")) {
            System.out.println("cake");
            return;
        }
        if (people.contains("lawyer")) {
            System.out.println("lawyer");
            return;
        }
        people.stream().sorted().findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println("swi"));
    }
}
