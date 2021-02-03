package Practice;

import java.text.DecimalFormat;

public class prodRandNum {
    public static DecimalFormat df;
    public static void main(String[] args) {
        df = new DecimalFormat("0");
        System.out.println(1000);
        for(int i = 0; i < 1000; ++i){
            boolean[] tri = new boolean[4];
            for(int j = 1; j <= 3; ++j){
                String rand = df.format(Math.random() * 2 + 1);
                int idx = Integer.parseInt(rand);
                if(tri[idx]) j--;
                else {
                    tri[idx] = true;
                    System.out.print(rand + " ");
                }
            }
            System.out.println();
        }
    }
}
