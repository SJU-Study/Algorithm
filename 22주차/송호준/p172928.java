import java.util.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {

        int x = 0;
        int y = 0;
        for(int i = 0; i < park.length; i++){
            String line = park[i];
            if(line.contains("S")){
                x = i;
                y = line.indexOf('S');
                break;
            }
        }
        
        int[] dX = {-1, 0, 1, 0};
        int[] dY = {0, -1, 0, 1};
        
        Map<String, Integer> map = new HashMap<>();
        map.put("N", 0);
        map.put("W", 1);
        map.put("S", 2);
        map.put("E", 3);
        
        
        for(String route : routes){
            String[] tmp = route.split(" ");
            String direction = tmp[0];
            int distance = Integer.parseInt(tmp[1]);
            int dir = map.get(direction);
            int nextX = x;
            int nextY = y;
            if(x + dX[dir] * distance >= park.length ||
               y + dY[dir] * distance >= park[0].length() ||
               x + dX[dir] * distance < 0 ||
               y + dY[dir] * distance < 0){
                continue;
            }
            boolean cantgo = false;
            for(int i = 0; i < distance; i++){
                nextX += dX[dir];
                nextY += dY[dir];
                if(park[nextX].charAt(nextY) == 'X'){
                    cantgo = true;
                    break;
                }
            }
            if(cantgo){
                continue;
            }
            x = nextX;
            y = nextY;
        }
        return new int[]{x, y};
    }
}
