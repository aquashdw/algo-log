package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

// https://www.acmicpc.net/problem/11809
public class Prob11809 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String a = reader.readLine();
        String b = reader.readLine();
        Deque<Character> aLeft = new LinkedList<>();
        Deque<Character> bLeft = new LinkedList<>();
        for (int i = 0; i < Math.min(a.length(), b.length()); i++) {
            char aNext = a.charAt(a.length() - i - 1);
            char bNext = b.charAt(b.length() - i - 1);
            if (aNext == bNext) {
                aLeft.push(aNext);
                bLeft.push(bNext);
            } else if (aNext > bNext) {
                aLeft.push(aNext);
            } else {
                bLeft.push(bNext);
            }
        }
        if (a.length() > b.length()) {
            int diff = a.length() - b.length();
            for (int i = 0; i < diff; i++) {
                aLeft.push(a.charAt(diff - i - 1));
            }
        } else if (b.length() > a.length()) {
            int diff = b.length() - a.length();
            for (int i = 0; i < diff; i++) {
                bLeft.push(b.charAt(diff - i - 1));
            }
        }

        StringBuilder aNew = new StringBuilder();
        StringBuilder bNew = new StringBuilder();
        while (!aLeft.isEmpty()) {
            aNew.append(aLeft.pop());
        }
        while (!bLeft.isEmpty()) {
            bNew.append(bLeft.pop());
        }
        StringBuilder answer = new StringBuilder();
        answer.append(aNew.isEmpty() ? "YODA" : Integer.parseInt(aNew.toString()));
        answer.append('\n');
        answer.append(bNew.isEmpty() ? "YODA" : Integer.parseInt(bNew.toString()));
        System.out.println(answer);
    }
}
