package programmers;

import java.util.Arrays;
import java.util.StringTokenizer;

// https://school.programmers.co.kr/learn/courses/30/lessons/172928
public class Prob172928 {
    public int[] solution(String[] parkStr, String[] routes) {
        int[] answer = new int[2];
        int height = parkStr.length;
        int width = parkStr[0].length();

        // 시작지점 기록
        for (int i = 0; i < parkStr.length; i++) {
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

        for (String route : routes) {
            String[] routeInfo = route.split(" ");
            String direction = routeInfo[0];
            int distance = Integer.parseInt(routeInfo[1]);
            boolean blocked = false;
            switch (direction) {
                case "E" -> {
                    for (int i = 1; i < distance + 1; i++) {
                        if (answer[1] + i >= width || park[answer[0]][answer[1] + i] == 'X') {
                            blocked = true;
                            break;
                        }
                    }
                    if (!blocked) answer[1] += distance;
                }
                case "W" -> {
                    for (int i = 1; i < distance + 1; i++) {
                        if (answer[1] - i < 0 || park[answer[0]][answer[1] - i] == 'X') {
                            blocked = true;
                            break;
                        }
                    }
                    if (!blocked) answer[1] -= distance;
                }
                case "N" -> {
                    for (int i = 1; i < distance + 1; i++) {
                        if (answer[0] - i < 0 || park[answer[0] - i][answer[1]] == 'X') {
                            blocked = true;
                            break;
                        }
                    }
                    if (!blocked) answer[0] -= distance;
                }
                case "S" -> {
                    for (int i = 1; i < distance + 1; i++) {
                        if (answer[0] + i >= height || park[answer[0] + i][answer[1]] == 'X') {
                            blocked = true;
                            break;
                        }
                    }
                    if (!blocked) answer[0] += distance;
                }
            }
        }
        return answer;
    }

    // 공원을 벗어나는지 확인하기 위한 메서드
    public boolean checkBounds(int y, int x, int height, int width) {
        return 0 <= y && y < height && 0 <= x && x < width;
    }

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(new Solution().solution(
//                new String[]{"SOO","OOO","OOO"},
//                new String[]{"E 2","S 2","W 1"}
//        )));
//        System.out.println(Arrays.toString(new Solution().solution(
//                new String[]{"SOO","OXX","OOO"},
//                new String[]{"E 2","S 2","W 1"}
//        )));
//        System.out.println(Arrays.toString(new Solution().solution(
//                new String[]{"OSO","OOO","OXO","OOO"},
//                new String[]{"E 2","S 3","W 1"}
//        )));
//        System.out.println(Arrays.toString(new Solution().solution(
//                new String[]{"OOSOX", "OOOOO", "OOOOO"},
//                new String[]{"E 1"}
//        )));
//        System.out.println(Arrays.toString(new Solution().solution(
//                new String[]{"SOOXO", "OOOXO", "OXOOO", "XOOOO"},
//                new String[]{"E 2", "S 2", "W 2", "S 1", "W 1"}
//        )));
//        System.out.println(Arrays.toString(new Solution().solution(
//                new String[]{"OXXO", "XSXO", "XXXX"},
//                new String[]{"E 1", "S 1"}
//        )));
//        System.out.println(Arrays.toString(new Solution().solution(
//                new String[]{"OOO", "OSO", "OOO", "OOO"},
//                new String[]{"N 2", "S 2"}
//        )));
//        System.out.println(Arrays.toString(new Solution().solution(
//                new String[]{"SOOXO", "OOOXO", "OXOOO", "XOOOO"},
//                new String[]{"E 2", "S 2", "W 2", "S 1", "W 1"}
//        )));
        System.out.println(Arrays.toString(new Prob172928().solution(
                new String[]{"OOOOO", "OOOOO", "OOSOO", "OOOOO", "OOOOO"},
                new String[]{"E 3", "W 3", "S 3", "N 3", "E 2", "E 1", "W 4", "W 1", "S 2", "S 1", "N 4", "N 1"}
        )));
    }
}
