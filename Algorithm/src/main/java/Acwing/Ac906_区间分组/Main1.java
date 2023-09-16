package Acwing.Ac906_区间分组;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.Arrays;

/**
 * 有若干个活动，第i个活动开始时间和结束时间是[Si,Fi]
 * 同一个教室安排的活动之间不能交叠，求要安排所有活动，少需要几个教室？
 */

class Point implements Comparable<Point>{
    int val;
    boolean isBegin;

    public Point(int val, boolean isBegin) {
        this.val = val;
        this.isBegin = isBegin;
    }

    @Override
    public int compareTo(Point o) {
        if (this.val < o.val) {
            return -1;
        } else if (this.val > o.val) {
            return 1;
        } else {
            // 如果值相等，则将开始点排序在结束点之前
            if (this.isBegin && !o.isBegin) {
                return -1;
            } else if (!this.isBegin && o.isBegin) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}

public class Main1 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static int n;

    static int nextInt() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    public static void main(String[] args) throws IOException {
        n = nextInt();
        int len = 2*n;
        Point[] point = new Point[len];
        for(int i=0;i<len;i+=2){
            point[i]=new Point(2*nextInt(),true);
            point[i+1] = new Point(2*nextInt()+1,false);
        }
        Arrays.sort(point,0,len);
        int res= 0,maxRes=0;
        for(int i=0;i<len;i++){
            if(point[i].isBegin){
                res++;
            }else{
                res--;
            }
            maxRes= Math.max(res,maxRes);
        }
        System.out.println(maxRes);
    }
}
