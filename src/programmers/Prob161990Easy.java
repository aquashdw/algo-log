package programmers;

import java.util.Arrays;

// https://school.programmers.co.kr/learn/courses/30/lessons/161990
public class Prob161990Easy {
    public int[] solution(String[] wallpaper) {
        // 왼쪽 위 좌표
        int lux = wallpaper.length;
        int luy = wallpaper[0].length();
        // 오른쪽 아래 좌표
        int rdx = 0;
        int rdy = 0;

        // 전체 칸을 순회한다.
        for (int i = 0; i < wallpaper.length; i++) {
            for (int j = 0; j < wallpaper[0].length(); j++) {
                // 만약 파일이 있다면,
                if (wallpaper[i].charAt(j) == '#') {
                    // 여태 나온것보다 위에 있었으면 기록
                    lux = Math.min(lux, i);
                    // 여태 나온것보다 왼쪽에 있었으면 기록
                    luy = Math.min(luy, j);
                    // 여태 나온것보다 아래쪽에 있었으면 기록
                    rdx = Math.max(rdx, i);
                    // 여태 나온것보다 오른쪽에 있었으면 기록
                    rdy = Math.max(rdy, j);
                }
            }
        }

        return new int[]{lux, luy, rdx + 1, rdy + 1};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Prob161990Easy().solution(new String[]{".#...", "..#..", "...#."})));
    }
}
