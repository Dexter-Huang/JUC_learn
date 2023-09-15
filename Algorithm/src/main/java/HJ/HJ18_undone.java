package HJ;

import java.util.Arrays;
import java.util.Scanner;

public class HJ18_undone {
    static int[] ans=new int[7];

    static boolean isValidMask(String mask){
        int[] arr = Arrays.stream(mask.split("\\.")).mapToInt(Integer::parseInt).toArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            String tmp = Integer.toBinaryString(arr[i]);
            for (int j = 0; j < 8 - tmp.length(); j++) {
                sb.append("0");
            }
            sb.append(tmp);
        }

        return sb.toString().lastIndexOf("1")<sb.toString().indexOf("0");
    }

    static boolean isValidIP(String ip){
        String[] arr= ip.split("\\.");
        if(arr.length!=4)
            return false;
        for (int i = 0; i < 4; i++) {
            int a = Integer.parseInt(arr[i]);
            if(a<0||a>255)
                return false;
        }
        return true;
    }

    static boolean isDigit(String[] tmp){
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[i].length(); j++) {
                if(!Character.isDigit(tmp[i].charAt(j)))
                    return false;
            }
        }
        return true;
    }

    static void cal(String ip){
        String[] tmp = ip.split("\\.");
        if(!isDigit(tmp)){
            ans[5]++;
            return;
        }


        int head = Integer.parseInt(tmp[0]);
        int second = Integer.parseInt(tmp[1]);

        if(1<=head&&head<=126)
            ans[0]++;
        else if (128 <= head && head <= 191) {
            ans[1]++;
        } else if (192 <= head && head <= 223) {
            ans[2]++;
        } else if (224 <= head && head <= 239) {
            ans[3]++;
        } else if (240 <= head && head <= 255) {
            ans[4]++;
        }

        if(10==head)
            ans[6]++;
        else if (172 == head&&16<=second&&second<=32) {
            ans[6]++;
        } else if (192==head&&second==168) {
            ans[6]++;
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in) ;

        while (in.hasNextLine()){
            String[] str = in.nextLine().split("\\~");
            String ip = str[0],mask=str[1];

            if(isValidMask(mask)&& isValidIP(ip)){
                cal(ip);
            }else{
                ans[5]++;
            }
        }

        Arrays.stream(ans).forEach(o-> System.out.print(o+" "));
    }
}
