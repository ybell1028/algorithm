package Programmers.SkillCheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Level2_스킬트리 {
    class Solution {
        public int solution(String skill, String[] skill_trees) {
            int answer = skill_trees.length;
            int bIdx = 0, cIdx = 0;

            for (int i = 0; i < skill_trees.length; ++i) {
                bIdx = skill_trees[i].indexOf(String.valueOf(skill.charAt(0)));
                for (int j = 1; j < skill.length(); ++j) {
                    cIdx = skill_trees[i].indexOf(String.valueOf(skill.charAt(j)));
                    if((bIdx > cIdx && cIdx != -1) // 선행스킬이 후행스킬 앞에 있고, 후행스킬이 존재할 경우
                            || (bIdx == -1 && cIdx != -1)) { // 선행스킬이 존재하지 않고, 후행스킬이 존재할 경우
                        answer--;
                        break;
                    }
                    bIdx = cIdx;
                }
            }
            return answer;
        }
    }

    class 모범답안 {
        public int solution(String skill, String[] skill_trees) {
            int answer = 0;
            ArrayList<String> skillTrees = new ArrayList<String>(Arrays.asList(skill_trees));
            //ArrayList<String> skillTrees = new ArrayList<String>();
            Iterator<String> it = skillTrees.iterator();

            while (it.hasNext()) {
                if (skill.indexOf(it.next().replaceAll("[^" + skill + "]", "")) != 0) {
                    it.remove();
                }
            }
            answer = skillTrees.size();
            return answer;
        }
    }
}
