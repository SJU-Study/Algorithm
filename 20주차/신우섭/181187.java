class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for (int i = 1; i <= r2; i++) {
            int startX = (int) Math.ceil(Math.sqrt(Math.pow(r1, 2) - Math.pow(i, 2)));
            int endX = (int) Math.floor(Math.sqrt(Math.pow(r2, 2) - Math.pow(i, 2)));
            answer += endX - startX + 1;
        }
        return answer *= 4;
    }
}
