package Programmers.YAPP.Week8;

public class 괄호변환 {
    static class Solution {
        StringBuilder sb = new StringBuilder();
        public String solution(String p) {
            return getCorrect(p);
        }

        public static int makeU(String p){
            String[] splited = p.split("");
            int cnt = 0;
            int idx = 0;
            for(int i = 0; i < splited.length; ++i){
                if(splited[i].equals("(")) cnt++;
                else cnt--;
                if(cnt == 0){
                    idx = i + 1;
                    break;
                }
            }
            return idx;
        }

        public static boolean correct(String u){
            String[] splited = u.split("");
            int cnt = 0;
            for(String s : splited){
                if(s.equals("(")) cnt++;
                else cnt--;
                if(cnt < 0) return false;
            }
            return true;
        }

        public String getCorrect(String p){
            int idx = makeU(p);
            String u = p.substring(0, idx);
            String v = p.substring(idx);

            if(correct(u)) sb.append(u);
            else {
                sb.append("(");
                if(!v.equals("")){
                    getCorrect(v);
                    v = "";
                }
                sb.append(")");
                sb.append(cutReverse(u));
            }
            if(!v.equals("")){
                getCorrect(v);
            }
            return sb.toString();
        }

        public String cutReverse(String p){
            String[] split = p.split("");
            StringBuilder sb = new StringBuilder();
            for(int i = 1; i < split.length - 1; i++){
                if(split[i].equals("(")) sb.append(")");
                else sb.append("(");
            }
            return sb.toString();
        }

        public static void main(String[] args) {
            String s1 = "(()())()";
            String s2 = ")(";
            String s3 = "()))((()";
            String s4 = "))()()(()))(((";
            String s5 = "(()(())))()))()))))(((((()))()(((()()(()))())((()))))()(((((())(())()))(((())())((()()))((()))())(((";
            String s6 = "(()((()())))";

            Solution s = new Solution();
            System.out.println(s.solution(s4));
        }
    }
}
