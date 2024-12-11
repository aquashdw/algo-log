package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/15081
public class Prob15081 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        Set<String> wanted = new HashSet<>();
        List<List<String>> childWanted = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            childWanted.add(Arrays.stream(reader.readLine().split(" "))
                    .skip(1).map(app -> {
                        wanted.add(app);
                        return app;
                    }).collect(Collectors.toList()));
        }

        List<String> installed = new ArrayList<>(n);
        childWanted.stream().forEach(childWants -> {
            String app = childWants.stream().filter(wanted::contains).findFirst()
                    .orElseThrow();
            wanted.remove(app);
            installed.add(app);
        });
        System.out.println(String.join(" ", installed));
    }
}
