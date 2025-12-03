package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


// https://www.acmicpc.net/problem/20520
public class Prob20520 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] info = Arrays.stream(reader.readLine().split(" "))
                .mapToLong(Long::parseLong).toArray();
        long sections = info[0];
        long defenders = info[1];
        Queue<long[]> priority = new PriorityQueue<>(Comparator.comparingLong(o -> -o[1]));
        long attackers = 0;
        for (int i = 0; i < sections; i++) {
            long[] attack = Arrays.stream(reader.readLine().split(" "))
                    .mapToLong(Long::parseLong).toArray();
            // 만약 공격 효율이 공격자보다 많으면 그 효율이 발휘되지 못한다.
            if (attack[0] < attack[1]) attack[1] = attack[0];
            attackers += attack[0];
            priority.offer(attack);
        }
        while (defenders > 0 && !priority.isEmpty()) {
            long[] next = priority.poll();
            // maxDef: 현재 효율([1])로 넣을 수 있는 최대 방어자 수
            long maxDef = next[0] / next[1];
            // 한명 만으로도 모두 막을 수 있음 (공격자를 효율로 맞추기 때문에 1이 최소)
            if (maxDef == 1 && next[0] % next[1] == 0) {
                // 한명 투입하고
                defenders--;
                // 공격자 전부 막는다.
                attackers -= next[0];
                // 이 구역은 안전하다.
                continue;
            }
            // 남은 방어자가 필요 양보다 적은 경우
            if (defenders <= maxDef) {
                // 현재 방어자를 최대한 투입해서 공격자를 막는다.
                attackers -= defenders * next[1];
                // 방어자를 다 소모한다.
                defenders = 0;
                // 다음 반복에서 종료될 예정
                continue;
            }

            // 현재 효율로 방어자를 넣을 만큼 투입한다.
            long fendOff = maxDef * next[1];
            attackers -= fendOff;
            defenders -= maxDef;
            // 남은 공격자를 계산한다.
            next[0] -= fendOff;
            // 혹 다 막았다면 이 구역은 안전하다.
            if (next[0] == 0) continue;
            // 아니라면 효율을 남은 공격자 수로 조정하고 다시 고려 구역으로 등록
            next[1] = next[0];
            priority.offer(next);
        }
        System.out.println(Math.max(attackers, 0));
    }
}
