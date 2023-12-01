package bf;

public class PowerSet {
    public static void main(String[] args) {
        // 몇번째 원소를 선택할지 여부를 0과 1로 구분
        int[] target = new int[]{2, 3, 5};
        int[] select = new int[]{0, 0, 0};

        for (int i = 0; i < 2; i++) {
            // 0 일 경우 미선택, 1 일 경우 선택
            select[0] = i;
            for (int j = 0; j < 2; j++) {
                // 0 일 경우 미선택, 1 일 경우 선택
                select[1] = j;
                for (int k = 0; k < 2; k++) {
                    // 0 일 경우 미선택, 1 일 경우 선택
                    select[2] = k;
                    // select의 3번째 원소가 결정되면 부분집합이 완성이다.
                    for (int elem = 0; elem < 3; elem++) {
                        if (select[elem] == 1)
                            System.out.print(target[elem] + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}
