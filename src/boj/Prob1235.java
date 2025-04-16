package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// https://www.acmicpc.net/problem/1235
public class Prob1235 {
    private static int length;
    private static int answer = 0;
    private static String[] studentNums;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        studentNums = new String[count];
        for (int i = 0; i < count; i++) {
            studentNums[i] = reader.readLine();
        }
        length = studentNums[0].length();
        compare(IntStream.range(0, count).boxed().collect(Collectors.toList()), 1);
        System.out.println(answer);
    }

    private static void compare(List<Integer> compareStudents, int depth) {
        answer = Math.max(answer, depth);
        if (answer == length) return;
        Map<Character, List<Integer>> sameStudents = new HashMap<>();
        for (int student : compareStudents) {
            List<Integer> list = sameStudents.computeIfAbsent(
                    studentNums[student].charAt(length - depth),
                    k -> new ArrayList<>()
            );
            list.add(student);
        }
        if (sameStudents.size() == compareStudents.size()) return;
        for (List<Integer> list : sameStudents.values()) {
            if (list.size() > 1) compare(list, depth + 1);
        }
    }
}
