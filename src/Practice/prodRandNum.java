package Practice;

import java.text.DecimalFormat;

public class prodRandNum {
    public static DecimalFormat df;
    public static void main(String[] args) {
        df = new DecimalFormat("0");
        for(int i = 0; i < 8; ++i){
            String rand = df.format(Math.random() * 6);
            System.out.print(rand + " ");
        }
    }
}
