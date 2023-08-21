import java.util.*;

class Solution {
    
    class Missile implements Comparable<Missile> {
        int start;
        int end;
        Missile(int start, int end){
            this.start = start;
            this.end = end;
        }
        
        public int compareTo(Missile o){
            return this.end - o.end;
        }
    }
    
    private PriorityQueue<Missile> pq;
    
    public int solution(int[][] targets) {
        pq = new PriorityQueue<>();
        
        for(int[] target : targets){
            pq.add(new Missile(target[0], target[1]));
        }
        int answer = 0;
        while(!pq.isEmpty()){
            Missile m = pq.poll();
            while(!pq.isEmpty() && pq.peek().start < m.end){
                pq.poll();
            }
            answer++;
        }
        return answer;
    }
}
