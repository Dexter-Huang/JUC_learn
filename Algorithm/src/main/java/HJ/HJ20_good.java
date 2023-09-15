package HJ;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HJ20_good {

    static boolean isMatch(String str){
        Pattern p = Pattern.compile("[a-z]");
        int cnt = 0;
        if(p.matcher(str).find())
            cnt++;
        /////////////////////////
        p = Pattern.compile("[A-Z]");
        if(p.matcher(str).find())
            cnt++;
        /////////////////////////
        p = Pattern.compile("[0-9]");
        if(p.matcher(str).find())
            cnt++;
        /////////////////////////
        p = Pattern.compile("[^0-9a-zA-Z \n]");
        if(p.matcher(str).find())
            cnt++;

        if(cnt<3)
            return false;
        else
            return true;

    }

    static boolean isOverLap(String str){
        for (int i = 0,j=3; j < str.length(); i++,j++) {
            if(str.substring(j).contains(str.substring(i,j)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()){
            String target = in.nextLine();
            if(target.length()<=8)
                System.out.println("NG");
            else if (!isMatch(target)) {
                System.out.println("NG");
            } else if (!isOverLap(target)) {
                System.out.println("NG");
            }else {
                System.out.println("OK");
            }
        }
    }
}
