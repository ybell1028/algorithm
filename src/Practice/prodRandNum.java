package Practice;

import java.text.DecimalFormat;

public class prodRandNum {
    public static DecimalFormat df;
    public static void main(String[] args) {
        df = new DecimalFormat("0");
        for(int i = 0; i < 500000; ++i){
            String rand1 = df.format(Math.random() * 5 + 1);
            String rand2 = df.format(Math.random() * 300000);
            System.out.println(rand1 + " " + rand2);
        }
    }
}
