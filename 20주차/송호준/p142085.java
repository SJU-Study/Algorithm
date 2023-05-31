import java.util.*;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        if(enemy.length <= k){
            return enemy.length;
        }
        
        int ptr;
        for(ptr = 0; ptr < k; ptr++){
            pq.add(enemy[ptr]);
        }
        
        while(ptr < enemy.length && !pq.isEmpty()){
            if(enemy[ptr] < pq.peek()){
                if(n < enemy[ptr]){
                    return ptr;
                }
                n -= enemy[ptr];
            }
            else{
                if(n < pq.peek()){
                    return ptr;
                }
                n -= pq.poll();
                pq.add(enemy[ptr]);
            }
            ptr++;
        }
        return ptr;
    }
}
