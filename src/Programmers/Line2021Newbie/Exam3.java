package Programmers.Line2021Newbie;
import java.util.*;

public class Exam3 {
    static class Solution {
        class Job implements Comparable{
            public int lt; // 걸리는 시간
            public int num; // 분류 번호
            public int ipt; // 중요도

            Job(int[] info){
                this.lt = info[1];
                this.num = info[2];
                this.ipt = info[3];
            }

            @Override
            public int compareTo(Object obj){
                Job temp = (Job)(obj);
                if(ipt != temp.ipt) return ipt - temp.ipt;
                else if(num != temp.num) return temp.num - num;
                else return 0;
            }
        }
        public int[] solution(int[][] jobs) {
            List<Integer> list = new LinkedList<>();
            List<Job> queue = new LinkedList<>();
            Map<Integer, Job> hm = new HashMap<>(); // 분류번호를 key로

            int start = jobs[0][0];
            int end = start;
            int time = 0;
            int classNum = -1;
            int i = 0;

            for(int[] j : jobs){
                end += j[1];
            }

            while(time <= end){
                int now = jobs[i][0]; // 요청 시각
                if(time == now){
                    Job temp = hm.get(jobs[i][2]);
                    if(temp == null) {
                        hm.put(jobs[i][2], new Job(jobs[i]));
                        queue.add(hm.get(jobs[i][2]));
                    }
                    else {
                        temp.lt += jobs[i][1];
                        temp.ipt += jobs[i][3];
                    }
                    i++;
                }
                if(!queue.isEmpty()){
                    Job j = queue.get(0);
                    j.lt--;
                    if(j.num != classNum){
                        classNum = j.num;
                        list.add(classNum);
                    }
                    if(j.lt <= 0){
                        queue.remove(0);
                        Collections.sort(queue);
                    }
                }
                time++;
            }

            int[] result = list.stream().mapToInt(in -> in).toArray();
            return result;
        }
    }

    public static void main(String[] args) {
        Solution s= new Solution();
        int[][] jobs = {{1, 5, 2, 3}, {2, 2, 3, 2}, {3, 1, 3, 3}, {5, 2, 1, 5}, {7, 1, 1, 1}, {9, 1, 1, 1}, {10, 2, 2, 9}};
        s.solution(jobs);
    }
}
