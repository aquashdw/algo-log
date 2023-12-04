package programmers;

// https://school.programmers.co.kr/learn/courses/30/lessons/161990
public class Prob161990 {
    public int[] solution(String[] wallpaper) {
        int lux = 0;
        int luy = 0;
        for (int i = 0; i < wallpaper.length; i++) {
            if (wallpaper[i].contains("#")) {
                lux = i;
                break;
            }
        }
        for (int i = 0; i < wallpaper[0].length(); i++) {
            boolean found = false;
            for (String row : wallpaper) {
                if (row.charAt(i) == '#'){
                    luy = i;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

        int rdx = 0;
        int rdy = 0;
        for (int i = wallpaper.length - 1; i >= 0; i--) {
            if (wallpaper[i].contains("#")) {
                rdx = i;
                break;
            }
        }

        for (int i = wallpaper[0].length() - 1; i >= 0; i--) {
            boolean found = false;
            for (String row : wallpaper) {
                if (row.charAt(i) == '#'){
                    rdy = i;
                    found = true;
                    break;
                }
            }
            if (found) break;
        }

//        System.out.println(Arrays.toString(new int[]{lux, luy, rdx + 1, rdy + 1}));


        int[] answer = {lux, luy, rdx + 1, rdy + 1};
        return answer;
    }

    public static void main(String[] args) {
        new Prob161990().solution(new String[]{".#...", "..#..", "...#."});
    }
}
