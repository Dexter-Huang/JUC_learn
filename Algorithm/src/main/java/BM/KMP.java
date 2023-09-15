package BM;

import java.util.Scanner;

public class KMP {
    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String son=" "+in.nextLine(),parent=" "+in.nextLine();
        int sonLen=son.length()-1,parentLen=parent.length()-1;
        int[] next=new int[5000];
        //求next过程
        for(int i=2,j=0;i<=sonLen;i++){
            while (j!=0&&son.charAt(i)!=son.charAt(j+1))
                j=next[j];
            if(son.charAt(i)==son.charAt(j+1))
                j++;
            next[i]=j;
        }

        for(int i=1,j=0;i<=parentLen;i++){
            while (j!=0&&parent.charAt(i)!=son.charAt(j+1))
                j=next[j];
            if(parent.charAt(i)==son.charAt(j+1))
                j++;
            if(j==sonLen)
            {
                System.out.println(i-sonLen);
                j=next[j];
            }
        }



    }
}
