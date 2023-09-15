package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class HJ21 {
    static HashMap<Character,Character> map = new HashMap<>();
    static {
        map.put('1','1');
        map.put('a','2');
        map.put('b','2');
        map.put('c','2');
        map.put('d','3');
        map.put('e','3');
        map.put('f','3');
        map.put('g','4');
        map.put('h','4');
        map.put('i','4');
        map.put('j','5');
        map.put('k','5');
        map.put('l','5');
        map.put('m','6');
        map.put('n','6');
        map.put('o','6');
        map.put('p','7');
        map.put('q','7');
        map.put('r','7');
        map.put('s','7');
        map.put('t','8');
        map.put('u','8');
        map.put('v','8');
        map.put('w','9');
        map.put('x','9');
        map.put('y','9');
        map.put('z','9');
        map.put('0','0');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = in .readLine().toCharArray();
//        System.out.println((int)'a');//97
//        System.out.println((int)'0');//48
//        System.out.println((int)'9');//48
//        System.out.println((int)'Z');//90

        for (int i = 0; i < arr.length; i++) {
            if(!Character.isDigit(arr[i])){
                if((int)arr[i]>=97){//小写
                    arr[i]= map.get(arr[i]);
                }
                else {
                    if('Z'==arr[i]){
                        arr[i]='a';
                        continue;
                    }
                    arr[i]=(char) ((int)(Character.toLowerCase(arr[i]))+1);
                }
            }
        }


        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }


        in.close();
    }
}
