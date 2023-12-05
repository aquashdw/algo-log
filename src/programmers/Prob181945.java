package programmers;

import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/181945
public class Prob181945 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        for (char a : str.toCharArray()) {
            System.out.println(a);
        }
    }
}
