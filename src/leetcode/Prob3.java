package leetcode;

public class Prob3 {
    public static void main(String[] args) {
        System.out.println(new Prob3().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        boolean[] visited = new boolean[128];
        int left = 0;
        int right = 0;
        int maxLen = 0;
        while (right < s.length()) {
            if (visited[s.charAt(right)]) {
                while (s.charAt(left) != s.charAt(right)) {
                    visited[s.charAt(left)] = false;
                    left++;
                }
                left++;
            }
            else visited[s.charAt(right)] = true;
            maxLen = Math.max(right - left + 1, maxLen);
            right++;
        }
        return maxLen;
    }
}
