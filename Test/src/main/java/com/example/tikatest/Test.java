package com.example.tikatest;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>(numRows+1);
        for (int i = 1;i<=numRows;i++){
            ans.add(new ArrayList<>(i));
            ans.get(i).set(0,1);
            ans.get(i).set(numRows-1,1);
            for(int j=2;j<numRows-1;j++){
                ans.get(i).set(j,ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        System.out.println(Test.generate(5));;
    }
}
