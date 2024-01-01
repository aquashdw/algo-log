package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

// https://www.acmicpc.net/problem/1269
public class Prob1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] setElems = reader.readLine().split(" ");
        int aCount = Integer.parseInt(setElems[0]);
        int bCount = Integer.parseInt(setElems[1]);

        Set<Integer> aSet = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());
        Set<Integer> bSet = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toSet());

        aSet.retainAll(bSet);
        int interCount = aSet.size();
        System.out.println(aCount + bCount - interCount * 2);
    }
}
