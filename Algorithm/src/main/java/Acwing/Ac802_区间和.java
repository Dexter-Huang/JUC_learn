package Acwing;

import java.io.*;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class Ac802_区间和 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static int n,m;

static int find(ArrayList<Integer> alls,int target){
    int L =-1,R=alls.size();
    while (L+1!=R){
        int mid = (L+R)>>1;
        if(alls.get(mid)>=target)
            R=mid;
        else
            L=mid;
    }
    return R;
}

public static void main(String[] args) throws IOException {
    int[] buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    n=buffer[0];m=buffer[1];
    ArrayList<Integer> alls = new ArrayList<>();
    alls.add(Integer.MIN_VALUE);
    ArrayList<AbstractMap.SimpleEntry<Integer,Integer>> add = new ArrayList<>();
    for (int i = 1; i <= n; i++) {
        buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        add.add(new AbstractMap.SimpleEntry<>(buffer[0],buffer[1]));
        alls.add(buffer[0]);
    }
    ArrayList<AbstractMap.SimpleEntry<Integer,Integer>> query = new ArrayList<>();
    for (int i = 0; i < m; i++) {
        buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        query.add(new AbstractMap.SimpleEntry<>(buffer[0],buffer[1]));
        alls.add(buffer[0]);
        alls.add(buffer[1]);
    }

    alls= (ArrayList<Integer>) alls.stream().distinct().sorted().collect(Collectors.toList());
    int[] a = new int[alls.size()+5], s=new int[alls.size()+5];
    for (AbstractMap.SimpleEntry<Integer, Integer> map : add) {
        int x =find(alls,map.getKey());
        a[x]+=map.getValue();
    }

    for (int i = 1; i <= alls.size(); i++) {
        s[i]+=s[i-1]+a[i];
    }

    for (AbstractMap.SimpleEntry<Integer, Integer> map : query) {
        int l = find(alls, map.getKey());
        int r = find(alls,map.getValue());
        out.write(s[r]-s[l-1]+"\n");
    }
    out.flush(); in.close();out.close();
}
}
