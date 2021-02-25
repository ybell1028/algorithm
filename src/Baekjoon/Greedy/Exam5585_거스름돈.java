package Greedy;

import java.util.Scanner;

public class Exam5585_거스름돈 {
    public static int MONEY = 1000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int paid = sc.nextInt();

        int money = MONEY - paid;

        int gohyaku;
        int hyaku;
        int gojyuu;
        int jyuu;
        int go;
        int ichi;

        for(gohyaku = 0; money > 0; ++gohyaku){
            if(money < 500) break;
            else {
                money -= 500;
            }
        }

        for(hyaku = 0; money > 0; ++hyaku) {
            if (money < 100) break;
            else {
                money -= 100;
            }
        }

        for(gojyuu = 0; money > 0; ++gojyuu) {
            if (money < 50) break;
            else {
                money -= 50;
            }
        }

        for(jyuu = 0; money > 0; ++jyuu) {
            if (money < 10) break;
            else {
                money -= 10;
            }
        }

        for(go = 0; money > 0; ++go) {
            if (money < 5) break;
            else {
                money -= 5;
            }
        }

        for(ichi = 0; money > 0; ++ichi) {
                money -= 1;
        }

        System.out.println(gohyaku + hyaku + gojyuu + jyuu + go + ichi);
    }
}
