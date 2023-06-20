class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int mod = w * 2 + 1;
        int start = 1;
        for (int s : stations) {
            int end = s - w - 1;
            if (start > end || end < 1) {
                start = s + w + 1;
                continue;
            }
            int diff = end - start + 1;
            if (diff % mod == 0) answer += diff / mod;
            else answer += diff / mod + 1;
            start = s + w + 1;
        }
        if (start < n + 1) {
            int diff = n - start + 1;
            if (diff % mod == 0) answer += diff / mod;
            else answer += diff / mod + 1;
        }

        return answer;
    }
}
/*
1, 2, [3, 4, 5], 6, 7, 8, 9, [10, 11], 12, 13
1~2 => 1개
6~9 => 2개
12~13 => 1개 (뒤에 남아 있는 경우 계산)
----------
예외 상황
1. end < 1인 경우, start 갱신
2. 4,5 처럼 처음 주어진 기지국이 붙어 있는 경우, start 갱신
*/
