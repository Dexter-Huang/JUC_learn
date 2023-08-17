package BM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Scanner;

public class BM58_stringArrange {
    public static ArrayList<String> res = new ArrayList<>();

    public static void permute(String[]cs, LinkedList<String> list,Boolean[] vis){
        if(list.size()==cs.length){
            StringBuilder builder = new StringBuilder("");
            for(String str:list)
                builder.append(str);
            res.add(builder.toString());
            return;
        }

        for(int i=0;i<cs.length;i++){
            if(vis[i])
                continue;
            if(i>0&&cs[i-1].equals(cs[i])&&!vis[i-1])
                continue;

            vis[i]=true;
            list.add(cs[i]);

            permute(cs,list,vis);

            vis[i]=false;
            list.removeLast();

        }

    }

    public static void main(String[] args) {
        Scanner in =new Scanner(System.in);
        String str = in.nextLine();
        String[] cs = str.split("");

        Boolean[] vis = new Boolean[cs.length];

        Arrays.fill(vis,false);
        LinkedList<String> list = new LinkedList<>();
        permute(cs,list,vis);

        res.forEach(System.out::println);

    }
}
