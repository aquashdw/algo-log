package programmers;

import java.util.Arrays;

public class Prob1712928Delta {
    public int[] solution(String[] parkStr, String[] routes) {
        int[] answer = new int[2];
        int height = parkStr.length;
        int width = parkStr[0].length();

        // 시작지점 기록
        for (int i = 0; i < height; i++) {
            if (parkStr[i].contains("S")) {
                int x = parkStr[i].indexOf("S");
                answer[0] = i;
                answer[1] = x;
                break;
            }
        }
        // 문자열 공원을 char[][]로 변형
        char[][] park = new char[parkStr.length][];
        for (int i = 0; i < parkStr.length; i++) {
            park[i] = parkStr[i].toCharArray();
        }

        // 각 방향별 delta 설정
        int[][] deltas = new int[][]{
                // N
                {-1, 0},
                // S
                {1, 0},
                // W
                {0, -1},
                // E
                {0, 1}
        };

        // 각 명령을 순회한다.
        for (String route : routes) {
            // 명령 정보 확인하기
            String[] routeInfo = route.split(" ");
            int distance = Integer.parseInt(routeInfo[1]);
            // 사용할 델타 설정
            int dIndex = getDirIndex(routeInfo[0]);
            int[] delta = deltas[dIndex];
            // 움직일 거리에 도달하면 공원을 벗어나진 않는지?
            if (!checkBounds(
                    answer[0] + delta[0] * distance,
                    answer[1] + delta[1] * distance,
                    height, width))
                // 벗어나면 다음 명령으로
                continue;
            // 진행 과정에 장애물이 등장하는지 확인한다.
            // 일단 장애물 만난적 없다.
            boolean blocked = false;
            // 1 부터 움직이는 거리까지 순회
            for (int i = 1; i < distance + 1; i++) {
                // i 만큼 해당 방향으로 움직였다.
                char now = park[answer[0] + delta[0] * i][answer[1] + delta[1] * i];
                // 장애물이 있나?
                if (now == 'X') {
                    // 있으면 그만두고 돌아간다.
                    blocked = true;
                    break;
                }
            }
            // 장애물을 만난 적 없다면
            if (!blocked) {
                // 해당 방향으로 진행하자.
                answer[1] += delta[1] * distance;
                answer[0] += delta[0] * distance;
            }
        }

        return answer;
    }

    // 어떤 delta를 사용하는지를 direction을 바탕으로 결정
    public int getDirIndex(String direction) {
        return switch (direction) {
            case "N" -> 0;
            case "S" -> 1;
            case "W" -> 2;
            case "E" -> 3;
            default -> -1;
        };
    }

    // 공원을 벗어나는지 확인하기 위한 메서드
    public boolean checkBounds(int y, int x, int height, int width) {
        return 0 <= y && y < height && 0 <= x && x < width;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Prob1712928Delta().solution(
                new String[]{"SOO","OOO","OOO"},
                new String[]{"E 2","S 2","W 1"}
        )));
    }
}