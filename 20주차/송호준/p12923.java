class Solution {
    public int[] solution(long begin, long end) {
        int[] answer = new int[(int)end - (int)begin + 1];
        int k = 0;
        for(int i = 0; i <= end - begin; i++){
            int value = findMaxDividor(i + begin);
            if(i + begin == 1){
                answer[i] = 0;
                continue;
            }
            answer[i] = value;
        }
        return answer;
    }
    private int findMaxDividor(long e){
        int value = 1;
        for(int i = 2; i <= (int)Math.sqrt(e); i++){
            int k = (int)e / i;
            if((int)e % i == 0){
                if(k > 10_000_000){
                    value = Math.max(value, i);
                    continue;
                }
                value = Math.max(value, k);
            }
        }
        return value;
    }
}
