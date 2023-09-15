package BM;

import java.util.ArrayList;
import java.util.Scanner;

public class BM60_generateParenthesis {

    public static ArrayList<String> res= new ArrayList<>();
    public static void permute(int left, int right, String temp, int n){
        if(left==n&&right==n){
            res.add(temp.toString());
            return;
        }
        if(left<n)
            permute(left+1,right,temp+"(",n);

        if(right<n&&left>right)
            permute(left,right+1,temp+")",n);

    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        permute(0,0,"",n);

        res.forEach(System.out::println);

    }
}
