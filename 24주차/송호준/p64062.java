import java.util.*;

class Solution {
    
    class Stone{
        int index;
        int value;
        
        Stone(int index, int value){
            this.index = index;
            this.value = value;
        }
    }
    
    public int solution(int[] stones, int k) {
        Deque<Stone> deque = new LinkedList<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < stones.length; i++) {
            while (!deque.isEmpty() && deque.peekLast().value < stones[i]) {
                deque.pollLast();
            }
            deque.addLast(new Stone(i, stones[i]));
            
            if (!deque.isEmpty() && deque.peekFirst().index <= i - k) {
                deque.pollFirst();
            }
            if(i >= k - 1){
                min = Math.min(min, deque.peekFirst().value);
            }
        }
        return min;
    }
}
