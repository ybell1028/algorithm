package Programmers.YAPP.Week9;
import java.util.*;

public class 오픈채팅방 {
    static class Solution {
        public String[] solution(String[] record) {
            HashMap<String, String> hm = new HashMap<>();
            StringTokenizer st;
            int cnt = 0;
            for(String r : record){
                st = new StringTokenizer(r);
                String command = st.nextToken();
                String id = st.nextToken();
                if(command.equals("Change")){
                    hm.put(id, st.nextToken());
                    cnt++;
                } else if(command.equals("Enter")){
                    hm.putIfAbsent(id, st.nextToken());
                }
            }
            int i = 0;
            String[] answer = new String[record.length - cnt];
            for(String r : record){
                st = new StringTokenizer(r);
                String command = st.nextToken();
                String id = st.nextToken();
                String nickname = hm.get(id);
                if(command.equals("Enter")){
                    answer[i] = nickname + "님이 들어왔습니다.";
                    i++;
                } else if (command.equals("Leave")){
                    answer[i] = nickname + "님이 나갔습니다.";
                    i++;
                }
            }
            return answer;
        }

        public static void main(String[] args) {
            Solution s = new Solution();
            String[] record = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};
            System.out.println(s.solution(record));
        }
    }
}
