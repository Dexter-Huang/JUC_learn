package HJ;

import java.util.Scanner;

public class HJ107 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double t = in.nextDouble();
        double L =-20.0,R=20.0;
        while (R-L>=0.00001){
            double mid = (R+L)/2.0;
            if(mid*mid*mid>=t)
                R=mid;
            else
                L=mid;
        }

        System.out.printf("%.1f\n",R);
    }
}
