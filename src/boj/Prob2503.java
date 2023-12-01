package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob2503 {
    private int solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int tries = Integer.parseInt(reader.readLine());
        int[][] ballInfo = new int[tries][3];
        for (int i = 0; i < tries; i++) {
            StringTokenizer countTokens = new StringTokenizer(reader.readLine());
            ballInfo[i] = new int[]{
                    Integer.parseInt(countTokens.nextToken()),
                    Integer.parseInt(countTokens.nextToken()),
                    Integer.parseInt(countTokens.nextToken())
            };
        }

//        int[] numbers = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
//        int answer = 0;
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (i == j) continue;
//                for (int k = 0; k < 9; k++) {
//                    if (i == k || j == k) continue;
//                    boolean flag = true;
//                    int[] select = new int[]{numbers[i], numbers[j], numbers[k]};
//                    for (int t = 0; t < tries; t++) {
//                        int target = ballInfo[t][0];
//                        int[] result = getCount(target, select);
//                        if (result[0] != ballInfo[t][1] || result[1] != ballInfo[t][2]) {
//                            flag = false;
//                            break;
//                        }
//                    }
//                    if (flag) answer++;
//                }
//            }
//        }

        int answer = 0;
        for (int i = 1; i < 10; i++) {  // 1부터 9까지
            for (int j = 1; j < 10; j++) {
                if (i == j) continue;
                for (int k = 1; k < 10; k++) {
                    if (k == i || k == j) continue;
                    boolean flag = true;
                    int[] select = new int[]{i, j, k};
                    for (int t = 0; t < tries; t++) {
                        int target = ballInfo[t][0];
                        int[] result = getCount(target, select);
                        if (result[0] != ballInfo[t][1] || result[1] != ballInfo[t][2]) {
                            flag = false;
                            break;
                        }
                    }
                    if (flag) answer++;
                }
            }
        }

        return answer;
    }

    public int[] getCount(int target, int[] select) {
        int[] targetNums = new int[]{target / 100, (target / 10) % 10, target % 10};
        int strikes = 0;
        int balls = 0;
        for (int i = 0; i < 3; i++) {
            if (targetNums[i] == select[i]) strikes++;
            else {
                for (int j = 0; j < 3; j++) {
                    if (targetNums[j] == select[i]) balls++;
                }
            }
        }
        return new int[]{strikes, balls};
    }

    public static void main(String[] args) throws IOException {
        System.out.println(new Prob2503().solution());
    }
}
