package Programmers.YAPP.Week20;

import java.util.*;

public class 파일명정렬 {
    class Solution {
        int od = 1;

        class Name implements Comparable{
            public String origin;
            public String head;
            public int number;
            public int order;

            Name(String origin){
                this.origin = origin;
                int i = 0;
                for(i = 0; i < origin.length(); ++i){
                    if(origin.charAt(i) >= '0' && origin.charAt(i) <= '9'){
                        break;
                    }
                }
                this.head = origin.substring(0, i).toLowerCase();
                int j = i;
                for(j = i; j < origin.length(); ++j){
                    if(origin.charAt(j) < '0' || origin.charAt(j) > '9'){
                        break;
                    }
                }
                this.number = Integer.valueOf(origin.substring(i, j));
                this.order = od++;
            }

            @Override
            public int compareTo(Object obj){
                Name name = (Name)(obj);
                if(!head.equals(name.head)){
                    return head.compareTo(name.head);
                } else if(number != name.number){
                    return number - name.number;
                } else {
                    return order - name.order;
                }
            }
        }

        public String[] solution(String[] files) {
            Name[] nameArr = new Name[files.length];

            List<Name> nameList = new ArrayList<>();

            for(int i = 0; i < nameArr.length; ++i){
                nameList.add(new Name(files[i]));
            }

            Collections.sort(nameList);

            String[] answer = nameList.stream()
                    .map(n -> n.origin)
                    .toArray(String[]::new);
            return answer;
        }
    }
}
