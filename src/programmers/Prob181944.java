package programmers;

import java.util.Scanner;

// https://school.programmers.co.kr/learn/courses/30/lessons/181883
public class Prob181944 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n % 2 == 0)
            System.out.printf("%d is even", n);
        else
            System.out.printf("%d is odd", n);
    }
}
