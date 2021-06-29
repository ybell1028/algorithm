package Programmers.YAPP.Week14;

import java.util.*;
import java.util.stream.Collectors;

public class 수식최대화 {
    static class Solution {
        LinkedList<Long> numberList;
        LinkedList<String> operationList;
        boolean[] operExist = new boolean[3]; // + 0 - 1 * 2
        String[] operators = {"+", "-", "*"};
        PriorityQueue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        String ex;

        public long solution(String expression) {
            int cnt = 0;
            ex = expression;
            for (int i = 0; i < operators.length; ++i) {
                if (expression.contains(operators[i])) {
                    cnt++;
                    operExist[i] = true;
                }
            }

            permutation(new LinkedList<Integer>(), new boolean[3], 3, cnt);

            return pq.poll();
        }

        public List<Long> seperateNumber(String expression) {
            return Arrays.asList(
                    expression.replaceAll("\\+", " ")
                            .replaceAll("-", " ")
                            .replaceAll("\\*", " ")
                            .split(" "))
                    .stream()
                    .map(Long::parseLong)
                    .collect(Collectors.toList());
        }

        public List<String> seperateOperation(String expression) {
            return Arrays.asList(
                    expression.replaceAll("[0-9]", "")
                            .split(""));
        }

        public void permutation(LinkedList<Integer> operList, boolean[] visited, int n, int r) {
            if (operList.size() == r) {
                numberList = new LinkedList<>(seperateNumber(ex));
                operationList = new LinkedList<>(seperateOperation(ex));
                for (Integer operIdx : operList) {
                    while (operationList.contains(operators[operIdx])) {
                        int numberIdx = operationList.indexOf(operators[operIdx]);
                        operationList.remove(numberIdx);
                        switch (operators[operIdx]) {
                            case "+": {
                                numberList.add(numberIdx, numberList.remove(numberIdx) + numberList.remove(numberIdx));
                                break;
                            }
                            case "-": {
                                numberList.add(numberIdx, numberList.remove(numberIdx) - numberList.remove(numberIdx));
                                break;
                            }
                            case "*": {
                                numberList.add(numberIdx, numberList.remove(numberIdx) * numberList.remove(numberIdx));
                                break;
                            }
                            default:
                                break;
                        }
                    }
                }
                if (numberList.get(0) > 0) {
                    pq.add(numberList.poll());
                } else {
                    pq.add(-numberList.poll());
                }
            }
            for (int i = 0; i < n; ++i) {
                if (!visited[i]) {
                    visited[i] = true;
                    if (operExist[i]) operList.add(i);
                    permutation(operList, visited, n, r);
                    if(operList.contains(i)) operList.removeLast();
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.solution("50*6-3*2"));
    }
}