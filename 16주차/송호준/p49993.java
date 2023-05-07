import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for(String str : skill_trees){
            System.out.println(str.replaceAll("[^" + skill + "]", ""));
            if(skill.indexOf(str.replaceAll("[^" + skill + "]", "")) != 0){
                answer++;
            }
        }
        
        return skill_trees.length - answer;
    }
}
