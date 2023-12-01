package dnc;

public class BinarySearch {
    public int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        // 왼쪽 인덱스가 오른쪽 인덱스보다 커지면 발견 실패
        while (left <= right) {
            // 현재 기준에서 절반 지점을 기준으로,
            int mid = left + (right - left) / 2;

            // 가운데에서 발견
            if (arr[mid] == target) {
                return mid;
            // 찾는 숫자보다 작다면 지금보다 오른쪽에서 찾는다.
            } else if (arr[mid] < target) {
                left = mid + 1;
            // 찾는 숫자보다 크다면 지금보다 왼쪽에서 찾는다.
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int target = 2;
        int index = new BinarySearch().binarySearch(arr, target);

        if (index != -1) {
            System.out.println(index);
        } else {
            System.out.println("탐색 실패");
        }
    }
}
