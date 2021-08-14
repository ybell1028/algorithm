package Programmers.Toss2021;

import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;
import java.text.*;

public class Exam3 {

    class Solution {
        public boolean solution(String amountText) {
            if(!Pattern.matches("^[0-9,]*$", amountText)) return false;
            if(!amountText.equals("0") && amountText.startsWith("0")) return false;
            if(amountText.startsWith(",") || amountText.endsWith(",")) return false;
            if(amountText.contains(",")){
                DecimalFormat df = new DecimalFormat("###,###");
                String comma = amountText.replaceAll(",", "");
                comma = df.format(Long.parseLong(comma));
                if(!comma.equals(amountText)) return false;
            }
            return true;
        }
    }
}
