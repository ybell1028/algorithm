package Programmers.Hash;

public class 전화번호목록 {
    class Solution {
        public boolean solution(String[] phone_book) {
            boolean answer = true;
            for(int i = 0; i < phone_book.length - 1; ++i){
                for(int j = 0; j < phone_book.length; ++j){
                    if(i == j) continue;
                    if(phone_book[i].length() <= phone_book[j].length()){
                        String temp = phone_book[j].substring(0, phone_book[i].length());
                        // A가 B의 접두어가 되려면 온전히 첫글자부터 끝까지 앞에 있어야한다.
                        System.out.println(phone_book[i]+" "+temp);
                        if(phone_book[i].equals(temp)) {
                            answer = false;
                            break;
                        }
                    }
                }
                if(!answer) break;
            }
            return answer;
        }
    }
}
