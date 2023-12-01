package backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Prob6603 {
    private int[] numbers;
    private StringBuilder answer;

    public void solution() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        answer = new StringBuilder();
        while (true) {
            String input = reader.readLine();
            if (input.equals("0")) break;
            StringTokenizer numToken = new StringTokenizer(input);
            int count = Integer.parseInt(numToken.nextToken());
            numbers = new int[count];
            for (int i = 0; i < count; i++) {
                numbers[i] = Integer.parseInt(numToken.nextToken());
            }
            dfs(0, 0, new int[count]);
            answer.append('\n');
        }
        System.out.println(answer);
    }

    private void dfs(int now, int selected, int[] comb) {
        if (selected == 6) {
            StringBuilder repBuilder = new StringBuilder();
            for (int i = 0; i < comb.length; i++) {
                if (comb[i] == 1) {
                    repBuilder.append(numbers[i]).append(' ');
                }
            }
            answer.append(repBuilder).append('\n');
        }
        else for (int i = now; i < numbers.length; i++) {
            comb[i] = 1;
            dfs(i + 1, selected + 1, comb);
            comb[i] = 0;
        }

    }

    public static void main(String[] args) throws IOException {
        new Prob6603().solution();
    }
}
