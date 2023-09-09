package OD.od3AI面板识别;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader in =new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(System.out);
    public static int read() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }

    static int num,r;


    static class Region{
        int id,x1,y1,x2,y2;

        public Region(int id, int x1, int y1, int x2, int y2) {
            this.id = id;
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        @Override
        public String toString() {
            return "Region{" +
                    "id=" + id +
                    ", x1=" + x1 +
                    ", y1=" + y1 +
                    ", x2=" + x2 +
                    ", y2=" + y2 +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        num = read();
        ArrayList<Region> list = new ArrayList<>();
        for(int i=0;i<num;i++){
            list.add(new Region(read(),read(),read(),read(),read()));
        }
        Region first = list.get(0);
        r = Math.abs(first.x1-first.x2)/2;

        list.sort((o1,o2)->o1.y1-o2.y1);
        ArrayList<Region> sameRowArr = new ArrayList<>();
        int i = 0;
        Region firstRegion = list.get(0);
        StringJoiner ans = new StringJoiner(" ");
        while (i<list.size()){
            for(;i<list.size();i++){
                if(list.get(i).y1-firstRegion.y1>r){
                    sameRowArr.sort((o1,o2)->o1.x1-o2.x1);
                    sameRowArr.stream().forEach(o->ans.add(String.valueOf(o.id)));
                    firstRegion = list.get(i);
                    sameRowArr.clear();
                    break;
                }
                sameRowArr.add(list.get(i));
            }
        }

        sameRowArr.sort((o1,o2)->o1.x1-o2.x1);
        sameRowArr.stream().forEach(o->ans.add(String.valueOf(o.id)));
        System.out.println(ans);


    }
}
