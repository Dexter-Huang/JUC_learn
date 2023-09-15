package BM;

import java.util.Arrays;
import java.util.Scanner;

public class BM84_LCP {

    public static String LCP(String[] strs){
        if(strs.length==0)
            return "";

        Arrays.sort(strs);

        int len = strs.length;
        String first = strs[0],last=strs[len-1];
        len = Math.min(first.length(),last.length());
        int i=0;
        for(;i<len;i++){
            if(first.charAt(i)!=last.charAt(i))
                break;
        }


        return first.substring(0,i);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        in.nextLine();
        String[] strings = new String[len];
        for(int i=0;i<len;i++){
            strings[i]=in.nextLine();
        }

        System.out.println(LCP(strings));


    }
}
