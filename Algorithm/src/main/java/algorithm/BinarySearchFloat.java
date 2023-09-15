package algorithm;

import java.io.IOException;
import java.util.Scanner;

/**
 * float L=-10000,R=10000;
 * while(R-L>=精度)
 * {
 * 	float mid=(L+R)/2.0;
 * 	if(check()) L=mid;
 * 	else R=mid;
 * 	//最后根据你所分左右两边区间的结果
 * 	//选取L或者R作为结果
 * }
 */
public class BinarySearchFloat {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        double a = in.nextDouble();
        double L = -10000,R=10000;
        while (R-L>=0.00000001){
            double mid = (L+R)/2.0;
            if(mid*mid*mid>=a)
                R = mid;
            else
                L = mid;
        }

        System.out.printf("%.6f\n",R);
    }
}
