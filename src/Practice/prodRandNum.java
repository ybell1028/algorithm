package Practice;

import java.text.DecimalFormat;

public class prodRandNum {
    public static DecimalFormat df;
    public static void main(String[] args) {
        df = new DecimalFormat("0");
        System.out.println(1000);
        for(int i = 0; i < 10; ++i){
            String rand = df.format(Math.random() * 10);
            System.out.println(rand);
        }
    }
}
