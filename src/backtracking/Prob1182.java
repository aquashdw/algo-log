package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob1182 {
    private int n;
    private int s;
    private int[] numbers;
    private int count;

    public void solution() throws IOException {
        BufferedReader reader
                = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer infoToken = new StringTokenizer(reader.readLine());
        n = Integer.parseInt(infoToken.nextToken());
        s = Integer.parseInt(infoToken.nextToken());
        count = s == 0 ? -1 : 0;
        numbers = new int[n];
        StringTokenizer numToken = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(numToken.nextToken());
        }
        dfs(0, 0);
//        Arrays.sort(numbers);
//        dfsSorted(0, 0);
        System.out.println(count);
    }

    private void dfs(int level, int sum) {
        if (level == n) {
            if (sum == s) count++;
        }
        else {
            dfs(level + 1, sum + numbers[level]);
            dfs(level + 1, sum);
        }
    }

//    private void dfsSorted(int level, int sum) {
//        if (level == n) {
//            System.out.println(sum + " in level == n");
//            if (sum == s) count++;
//        }
//        else if (sum == s) {
//            System.out.println(sum + " in sum == s");
//            count++;
//        }
//        else if (sum > s) {
//            return;
//        } else {
//            dfsSorted(level + 1, sum + numbers[level]);
//            dfsSorted(level + 1, sum);
//        }
//    }

    public static void main(String[] args) throws IOException {
        new Prob1182().solution();
    }
}
