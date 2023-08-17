package Acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Ac794_高精度除法 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> A = new ArrayList<>();
    static ArrayList<Integer> C = new ArrayList<>();
    static int B = 0;

    static int r =0;

    static int div(ArrayList<Integer> A, int B){
        for (int i = 0; i < A.size(); i++) {
            r=r*10+A.get(i);
            C.add(r/B);
            r%=B;
        }
        int zero_num=0;
        for (int i = 0; i < C.size(); i++) {
            if(C.get(i).equals(0))
                zero_num++;
            else
                break;
        }

        return zero_num;
    }





    public static void main(String[] args) throws IOException {
        char[] a = in.readLine().toCharArray();
        for (int i = 0; i < a.length; i++) {
            A.add(a[i]-'0');
        }

        B = Integer.parseInt(in.readLine());
        int zero_num = div(A,B);

        for (int i = zero_num; i < C.size() ; i++) {
            System.out.print(C.get(i));
        }

        if(zero_num==C.size())
            System.out.print(0);

        System.out.println();
        System.out.println(r);



    }
}
