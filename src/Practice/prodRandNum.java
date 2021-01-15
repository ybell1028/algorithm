package Practice;

import java.text.DecimalFormat;

public class prodRandNum {
    public static DecimalFormat df;
    public static void main(String[] args) {
        df = new DecimalFormat("0.000");
        for(int i = 0; i < 10000; ++i){
            String rand = df.format(Math.random() * 100);
            System.out.println(rand);
        }
    }
}
