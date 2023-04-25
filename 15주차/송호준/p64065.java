import java.util.*;

class Solution {
    public int[] solution(String s) {
        Set<String> set = new HashSet<>();

        //괄호 두개 없애
        s = s.substring(2, s.length() - 2);
        
        //split해서 묶음별로 분류
        String[] strArr = s.split("\\},\\{");

        int len = strArr.length;
        String[] sortedStrArr = new String[len];
        int[] answer = new int[len];

        //가지고 있는 숫자 개수에 따라서 정렬
        for (String e : strArr) {
            String[] numArr = e.split(",");
            sortedStrArr[numArr.length - 1] = e;
        }
        //옮겨 담아 이제
        for (int i = 0; i < len; i++) {
            String[] numArr = sortedStrArr[i].split(",");
            for (String e : numArr) {
                if (!set.contains(e)) {
                    set.add(e);
                    answer[i] = Integer.parseInt(e);
                    break;
                }
            }
        }
        return answer;
    }
}
