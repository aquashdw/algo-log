package bf;

import java.util.Arrays;

public class PowerSetRecursive {
    public static void main(String[] args) {
        int[] target = new int[]{2, 3, 5};
        new PowerSetRecursive().powerSet(target, 0, new int[target.length]);
    }

    public void powerSet(int[] set, int next, int[] select) {
        if (next == set.length) {
            for (int i = 0; i < set.length; i++) {
                if (select[i] == 1) System.out.print(set[i] + ", ");
            }
            System.out.println(Arrays.toString(select));
        }
        else {
            powerSet(set, next + 1, select);
            select[next] = 1;
            powerSet(set, next + 1, select);
            select[next] = 0;
        }
    }
}
