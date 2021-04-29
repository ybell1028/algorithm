package Programmers.YAPP.Week8;

//시작 8시 55분
public class 괄호변환 {
    static class Solution {
        static StringBuilder u;
        static StringBuilder v;
        static StringBuilder sb;
        public String solution(String p) {
            if (p.equals("")) return p;
            sb = new StringBuilder();
            u = new StringBuilder();
            v = new StringBuilder(p);

            while(true) {
                boolean csb = correct(sb);
                if (sb.length() == p.length() && csb) break;
                if (csb) u = new StringBuilder();
                else sb = new StringBuilder();
                if(v.length() <= 0){
                    v.append(sb);
                    sb = new StringBuilder();
                } else {
                    makeU(v);
                }
                if (correct(u)) {
                    sb.append(u);
                } else {
                    v = new StringBuilder(transform(u, v.toString()));
                    System.out.println("sblen = " + sb.length());
                    System.out.println("vlen = " + v.length());
                    System.out.println("ulen = " + u.length());
                    sb.append(v);
                    u = new StringBuilder();
                }
            }

//            if(v.toString().equals("")) sb.append(u);

            return sb.toString();
        }

        public static void makeU(StringBuilder v){
            StringBuilder temp = new StringBuilder(v);
            int front = 0;
            int back = 0;
            temp.delete(1, v.length());
            v.delete(0, 1);
            front++;
            String fs = temp.toString();
            u.append(fs);
            while(front > back){
                temp = new StringBuilder(v);
                temp.delete(1, v.length());
                v.delete(0, 1);
                if(temp.toString().equals(fs)) front++;
                else back++;
                u.append(temp);
            }
        }

        public static boolean correct(StringBuilder u){
            if(u.toString().equals("")) return false;
            else if(u.substring(0, 1).equals(")")) return false; // 무조건 시작은 '('
            StringBuilder temp = new StringBuilder(u);
            int head = 0;
            int tail = 0;
            for(int i = 0; i < u.length(); ++i){
                temp.delete(i + 1, temp.length());
                temp.delete(0, i);
                if(temp.toString().equals("(")) head++;
                else tail++;
                if(tail > head) return false;
                temp = new StringBuilder(u);
            }
            return head == tail ? true : false;
        }

        public static String transform(StringBuilder u, String v){
            StringBuilder temp = new StringBuilder();
            temp.append("(" + v + ")");
            u.delete(0, 1);
            u.delete(u.length() - 1, u.length());
            temp.append(u.reverse());
//            if(u.length() > 0){
//                u.delete(0, 1);
//                u.delete(u.length() - 1, u.length());
//                temp.append(u.reverse());
//            }
            return temp.toString();
        }

        public static void main(String[] args) {
            String s1 = "(()())()";
            String s2 = ")(";
            String s3 = "()))((()";
            String s4 = "))()()(()))(((";
            String s5 = "(()(())))()))()))))(((((()))()(((()()(()))())((()))))()(((((())(())()))(((())())((()()))((()))())(((";
            String s6 = "(()((()())))";

            Solution s = new Solution();
            System.out.println(s.solution(s5));
        }
    }
}
