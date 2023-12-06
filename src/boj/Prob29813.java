package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


// https://www.acmicpc.net/problem/29813
public class Prob29813 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(System.in));

        int studentCount = Integer.parseInt(reader.readLine());
        Queue<String> names = new LinkedList<>();
        Queue<Integer> years = new LinkedList<>();

        for (int i = 0; i < studentCount; i++) {
            String[] studentInfo = reader.readLine().split(" ");
            names.offer(studentInfo[0]);
            years.offer(Integer.parseInt(studentInfo[1]));
        }

        // 한명은 남긴다.
        while (names.size() > 1 && years.size() > 1) {
            names.poll();
            int year = years.poll();
            for (int i = 0; i < year - 1; i++) {
                names.offer(names.poll());
                years.offer(years.poll());
            }
            names.poll();
            years.poll();
        }

        System.out.println(names.poll());
    }
}
