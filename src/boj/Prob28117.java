package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

// https://www.acmicpc.net/problem/28117
public class Prob28117 {
    private static int count = 0;
    private static List<Integer> longLongStarts;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        reader.readLine();
        String newString = reader.readLine();
        int lastIdx = 0;
        longLongStarts = new ArrayList<>();
        while (true) {
            int next = newString.indexOf("longlong", lastIdx);
            if (next == -1) break;
            longLongStarts.add(next);
            lastIdx = next + 1;
        }
        if (longLongStarts.isEmpty()) {
            System.out.println(1);
            return;
        }
        if (longLongStarts.size() == 1) {
            System.out.println(2);
            return;
        }
        comb();
        System.out.println(count);
    }

    private static void comb() {
        boolean[] used = new boolean[longLongStarts.size()];
        used[0] = true;
        combRecursive(used, 1);
        used[0] = false;
        combRecursive(used, 1);
    }

    private static void combRecursive(boolean[] used, int nowIdx) {
        if (nowIdx == used.length) {
            count++;
            return;
        }
        int now = longLongStarts.get(nowIdx);
        int before = longLongStarts.get(nowIdx - 1);
        if (!(used[nowIdx - 1] && before == now - 4)) {
            used[nowIdx] = true;
            combRecursive(used, nowIdx + 1);
        }
        used[nowIdx] = false;
        combRecursive(used, nowIdx + 1);
    }
}
