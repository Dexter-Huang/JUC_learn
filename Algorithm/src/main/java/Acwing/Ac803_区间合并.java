package Acwing;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Ac803_区间合并 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

    static class Interval {
        public int L;
        public int R;

        public Interval(int l, int r) {
            L = l;
            R = r;
        }
    }

    public static void main(String[] args) throws IOException {
        int num = Integer.parseInt(in.readLine());
        int[] buffer;
        ArrayList<Interval> list = new ArrayList<>();
        while (num -- >0){
            buffer = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            list.add(new Interval(buffer[0],buffer[1]));
        }

        list.sort((o1, o2) -> {
            if(o1.L!=o2.L)
                return o1.L- o2.L;
            else
                return o1.R - o2.R;
        });
//        list.stream().forEach(o-> System.out.println(o.L+" "+o.R));
//        System.out.println("----");
        ArrayList<Interval> res = new ArrayList<>();
        int base = Integer.MIN_VALUE;
        for (Interval interval : list) {
            if (base< interval.L){
                res.add(interval);
                base = interval.R;
//                res.stream().forEach(o-> System.out.println(o.L+" "+o.R));
            } else if (base>= interval.L&&base< interval.R) {
                res.get(res.size()-1).R = interval.R;
                base = interval.R;
//                res.stream().forEach(o-> System.out.println(o.L+" "+o.R));
            }
        }
        out.write(res.size()+"\n");

        out.flush();out.close();in.close();
    }

}
