class Solution {
    public int solution(int n) {
        int len = Integer.bitCount(n);
        int answer = n+1;
        while(true){
            if(Integer.bitCount(answer++)==len) break;
        }
        
        return answer - 1;
    }
}
