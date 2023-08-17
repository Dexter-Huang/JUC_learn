package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HJ17 {
    static boolean isValid(String str){
        if("".equals(str)||" ".equals(str)||(str.length()!=3&&str.length()!=2)){
            return false;
        }

        if(str.startsWith("A")||str.startsWith("W")||str.startsWith("D")||str.startsWith("S")){
            str=str.substring(1);
            for (int i = 0; i < str.length(); i++) {
                if(!Character.isDigit(str.charAt(i))){
                    return false;
                }
            }
            return true;
        }
        else {
            return false;
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        List<String> arr = Arrays.stream(in.readLine().split(";")).collect(Collectors.toList());

        arr.removeIf(str->!isValid(str));

        int x=0,y=0;

        for (String t : arr) {
            String a = t.substring(0, 1);
            int b = Integer.parseInt(t.substring(1));
            switch (a){
                case "A":
                    x-=b;
                    break;
                case "W":
                    y+=b;
                    break;
                case "S":
                    y-=b;
                    break;
                case "D":
                    x+=b;
                    break;
            }
        }

        System.out.println(x+","+y);



    }
}
