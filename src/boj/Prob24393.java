package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

// https://www.acmicpc.net/problem/24393
public class Prob24393 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        // 조커 카드 위에 남은 카드 장수
        int joker = 0;

        while (n-- > 0) {
            int[] swaps = Arrays.stream(reader.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();

            // 이번 섞음으로 인해 위로 올라갈 카드 장수
            int over = 0;
            // 다음 섞음 순서 (idx)
            int next = 0;
            // 만약 조커 위에 13장이 없다면 조커는 왼쪽으로 간다.
            if (joker < 13) {
                // 오른쪽 첫 뭉치가 다음에 위로 올라올 것이다.
                over += swaps[next];
                next++;
            } else {
                // 왼쪽의 13장이 빠졌으므로 오른쪽에서 조커의 위치가 조정된다.
                joker -= 13;
            }
            // 모든 단계가 끝나거나 조커위에 충분한 카드가 있는 경우
            while (next < swaps.length && joker >= swaps[next]) {
                // 내쪽 더미에서 카드를 추가하고
                over += swaps[next];
                // 조커 위에서 그만큼 카드가 사라지고
                joker -= swaps[next];
                next++;
                // 저쪽 더미에서 위에 카드를 추가한다.
                if (!(next < swaps.length)) break;
                over += swaps[next];
                next++;
            }
            // 조커가 포함된 더미 차례가 되었을 때,
            // 조커 위에 남은 장수 += 이미 섞은 카드 장수
            joker += over;
        }

        // joker는 조커 위에 장수를 파악하는 용도이므로 몇번째인지를 판단하기 위해 +1
        System.out.println(joker + 1);
    }
}
/*
4
12 13 2
14 13
14 13
1 13 13


4
12 13 2 -> j == 12
14 13   -> j == 26
14 13   -> j == 13
1 13 13 -> j == 0
 */