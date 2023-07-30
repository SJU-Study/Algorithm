import java.util.*;

class Solution {
    
    private String busTable;
    private int cnt;
    private PriorityQueue<String> pq;

    public String solution(int n, int t, int m, String[] timetable) {
        pq = new PriorityQueue<>();
        for (String e : timetable) {
            pq.add(e);
        }

        for (int i = 1; i < n; i++) {
            ride(i, t, m);
        }
        ride(n, t, m - 1);

        if (pq.isEmpty()) {
            return busTable;
        }
        
        String lastPerson = pq.poll();
        int hour = Integer.parseInt(lastPerson.substring(0, 2));
        int minute = Integer.parseInt(lastPerson.substring(3));
        minute--;
        if (minute == -1) {
            minute = 59;
            hour--;
        }
        String hourStr = digitCast(hour);
        String minuteStr = digitCast(minute);
        String timeStr = hourStr + ":" + minuteStr;

        if (timeStr.compareTo(busTable) > 0) {
            return busTable;
        }
        return timeStr;
    }
    
    private void ride(int i, int t, int m){
        int cnt = 0;
        busTable = busTable(i, t);
        while (cnt < m && !pq.isEmpty()) {
            if (pq.peek().compareTo(busTable) <= 0) {
                pq.poll();
                cnt++;
            } else {
                return;
            }
        }
    }

    private String busTable(int n, int t) {
        int timePassed = (n - 1) * t;
        int hour = timePassed / 60 + 9;
        int minute = timePassed % 60;
        String hourStr = digitCast(hour);
        String minuteStr = digitCast(minute);
        return hourStr + ":" + minuteStr;
    }

    private String digitCast(int num) {
        if (num < 10) {
            return "0" + num;
        }
        return "" + num;
    }
}
