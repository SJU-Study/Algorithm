class Solution {
    
    private long[] dp;
    
    public int solution(int n) {
        dp = new long[5001];
        dp[0] = 1;
        if(n >= 2){
            dp[2] = 3;            
        }
        if(n >= 4){
            dp[4] = 3 * 3 + 2;    
        }
        for(int i = 6; i <= n; i += 2){
            dp[i] = (dp[i - 2] * 3) % 1_000_000_007;
            for(int j = 0; j <= i - 4; j += 2){
                dp[i] += dp[j] * 2 % 1_000_000_007;
                dp[i] %= 1_000_000_007;
            }
        }
        return (int)dp[n];
    }
}
