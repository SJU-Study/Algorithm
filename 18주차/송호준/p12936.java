import java.util.*;

class Solution {
    
    private static long cnt;
    
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        
        List<Integer> arr = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            arr.add(i);
        }
        
        long fac = factorial(n);
        for(int i = 0; i < n - 1; i++){
            fac /= (n - i);
            int index;
            if (k != 0) {
                index = (int) ((k - 1) / fac) + 1;
                answer[i] = arr.get(index);
            } else {
                index = arr.size() - 1;
                answer[i] = arr.get(index);
            }
            arr.remove(index);
            k %= fac;
        }
        answer[n - 1] = arr.get(1);
        
        
        return answer;
    }
    
    private static long factorial(int n){
        long result = 1;
        for(long i = 2; i <= n; i++){
            result *= i;
        }
        return result;
    }
}
