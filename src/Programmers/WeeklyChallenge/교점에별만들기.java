package Programmers.WeeklyChallenge;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class 교점에별만들기 {

    static class Solution {
        String dot = ".";
        String star = "*";

        int maxY = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;

        int maxX = Integer.MIN_VALUE;
        int minX = Integer.MAX_VALUE;

        Set<String> hs = new HashSet<>();

        String intPattern = "^-*[0-9]*\\.0$";

        public String[] solution(int[][] line) {
            for(int i = 0; i < line.length - 1; ++i) {
                long A = line[i][0];
                long B = line[i][1];
                long E = line[i][2];
                for(int j = i + 1; j < line.length; ++j) {
                    long C = line[j][0];
                    long D = line[j][1];
                    long F = line[j][2];

                    double shares = (A*D - B*C);

                    if(shares == 0) continue;

                    double x = (B*F - E*D) / shares;
                    double y = (E*C - A*F) / shares;

                    if(Pattern.matches(intPattern, Double.toString(x)) &&
                            Pattern.matches(intPattern, Double.toString(y))) {
                        int iy = (int)y;
                        int ix = (int)x;

                        hs.add(iy + ", " + ix);

                        maxY = Math.max(maxY, iy);
                        minY = Math.min(minY, iy);

                        maxX = Math.max(maxX, ix);
                        minX = Math.min(minX, ix);
                    }
                }
            }

            String[] answer = new String[maxY - minY + 1];

            int idx = 0;

            for(int i = maxY; i >= minY; --i) {
                StringBuilder sb = new StringBuilder();
                for(int j = minX; j <= maxX; ++j) {
                    sb.append(hs.contains(i + ", " + j) ? star : dot);
                }
                answer[idx++] = sb.toString();
            }

            return answer;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] line = {{2, -1, 4}, {-2, -1, 4}, {0, -1, 1}, {5, -8, -12}, {5, 8, 12}};
        int[][] line2 = {{0, 1, -1}, {1, 0, -1}, {1, 0, 1}};
        int[][] line3 = {{1, -1, 0}, {2, -1, 0}};
        s.solution(line);
    }
}
