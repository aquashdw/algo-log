package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// https://www.acmicpc.net/problem/20055
public class Prob20055 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] belt = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();


        int n2 = nk[0] * 2;
        int load = 0;
        int unload = nk[0] - 1;
        List<Integer> robotPos = new ArrayList<>(nk[0]);

        // 4. 종료
        int reps = 0;
        while (Arrays.stream(belt).filter(cell -> cell == 0).count() < nk[1]) {
            // 1. 벨트 회전
            load = load - 1 < 0 ? n2 - 1 : load - 1;
            unload = unload - 1 < 0 ? n2 - 1: unload - 1;
            if (!robotPos.isEmpty() && robotPos.get(0) == unload) robotPos.remove(0);

            // 2. 로봇 이동
            for (int i = 0; i < robotPos.size(); i++) {
                // 내 앞에 로봇이 있다.
                if (i > 0 && robotPos.get(i - 1) == (robotPos.get(i) + 1) % n2)
                    continue;
                if (belt[(robotPos.get(i) + 1) % n2] < 1)
                    continue;
                robotPos.set(i, (robotPos.get(i) + 1) % n2);
                belt[robotPos.get(i)]--;
            }
            if (!robotPos.isEmpty() && robotPos.get(0) == unload) robotPos.remove(0);

            // 3. 올리는 칸에 로봇 배치
            if (belt[load] > 0 && (robotPos.isEmpty() || robotPos.get(robotPos.size() - 1) != load)) {
                robotPos.add(load);
                belt[load]--;
            }

            reps++;
        }
        System.out.println(reps);
    }
}
/*
3 2
1 2 1 2 1 2
 */