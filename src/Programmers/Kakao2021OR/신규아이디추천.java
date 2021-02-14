package Programmers.Kakao2021OR;

public class 신규아이디추천 {
    class Solution {
        public String solution(String new_id) {
            StringBuilder sb = new StringBuilder(new_id.toLowerCase()); // 1
            System.out.println("1단계 " + sb.toString());

            String p2 = "[^0-9a-zA-Z._\\w-]*$";
            String p3 = "^.(.+)$";
            for(int i = 0; i < sb.length(); ++i){ //2, 3
                if(!Pattern.matches(p2, sb.substring(i, i+1)) || !Pattern.matches(p3, sb.substring(i, i+1))){
                    sb.replace(i, i+1, "");
                }
            }
            System.out.println("2, 3단계 " + sb.toString());

            if(sb.substring(0, 1).equals(".")){ // 4
                sb = sb.substring(1, new_id.length());
            }
            if(sb.substring(sb.length() - 1, sb.length()).equals(".")){ // 4
                sb = sb.substring(1, new_id.length());
            }
            System.out.println("4단계 " + sb.toString());


            if(sb.equals("")){ // 5
                sb = new StringBuilder("a");
            }
            System.out.println("5단계 " + new_id);

            if(new_id.length() >= 16){ // 6
                if(new_id.charAt(15) == '.'){
                    new_id = new_id.substring(0, 14);
                } else {
                    new_id = new_id.substring(0, 15);
                }
            }
            System.out.println("6단계 " + new_id);

            if(new_id.length() <= 2){
                String tail = sb.substring(sb.length() - 1, sb.length());
                while(new_id.length() < 3){
                    sb.append(tail);
                }
                System.out.println("7단계 " + sb.toString());
                return sb.toString();
            } else {
                System.out.println("7단계 " + new_id);
                return new_id;
            }
        }
    }
}
