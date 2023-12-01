package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution4012 {
    private int minSynergy = Integer.MAX_VALUE;
    private int[][] recipe;
    private int n;
    private int r;
    public int solution(int n, int[][] recipe) {
        this.minSynergy = Integer.MAX_VALUE;
        this.n = n;
        this.r = n / 2;
        this.recipe = recipe;
        combination(0, 0, new boolean[n]);
        return minSynergy;
    }

    public void combination(int k, int next, boolean[] selected) {
        if (k == r) {
            List<Integer> leftFoodRecipe = new ArrayList<>();
            List<Integer> rightFoodRecipe = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (selected[i]) leftFoodRecipe.add(i);
                else rightFoodRecipe.add(i);
            }
            int synergyLeft = 0;
            int synergyRight = 0;
            for (int i = 0; i < r; i++) {
                for (int j = 0; j < r; j++) {
                    synergyLeft += this.recipe[leftFoodRecipe.get(i)][leftFoodRecipe.get(j)];
                    synergyRight += this.recipe[rightFoodRecipe.get(i)][rightFoodRecipe.get(j)];
                }
            }

            int synergyDiff = synergyLeft > synergyRight ? synergyLeft - synergyRight : synergyRight - synergyLeft;
            this.minSynergy = Math.min(synergyDiff, this.minSynergy);
        } else if (next < n) {
            selected[next] = true;
            combination(k + 1, next + 1, selected);
            selected[next] = false;
            combination(k, next + 1, selected);
        }
    }

    public static void main(String[] args) throws Exception
    {
        Solution4012 solution = new Solution4012();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        for(int tc = 1; tc <= T; tc++)
        {
            int N = Integer.parseInt(reader.readLine());
            int[][] recipe = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer recipeToken = new StringTokenizer(reader.readLine());
                for (int j = 0; j < N; j++) {
                    recipe[i][j] = Integer.parseInt(recipeToken.nextToken());
                }
            }

            System.out.printf("#%d %d%n", tc, solution.solution(N, recipe));
        }
    }
}
