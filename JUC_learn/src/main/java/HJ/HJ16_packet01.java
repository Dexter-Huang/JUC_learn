package HJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class HJ16_packet01 {

    private static class Thing{
        public int v;
        public int p;

        public Thing(int v, int p) {
            this.v = v;
            this.p = p;
        }

        public int getV() {
            return v;
        }

        public void setV(int v) {
            this.v = v;
        }

        public int getP() {
            return p;
        }

        public void setP(int p) {
            this.p = p;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] tmp = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = tmp[0];
        int m = tmp[1];
        ArrayList<Thing> primary = new ArrayList<>();
        HashMap<Integer,ArrayList<Thing>> annex = new HashMap<>();
        for (int i = 1; i <=m; i++) {
            int[] tmp2 = Arrays.stream(in.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if(tmp2[2]==0)
                primary.add(new Thing(tmp2[0],tmp2[1]));
            else {
                if (annex.containsKey(tmp2[0]))
                    annex.get(tmp2[0]).add(new Thing(tmp2[0],tmp[1]));
                else {
                    ArrayList<Thing> list = new ArrayList<>();
                    list.add(new Thing(tmp2[0],tmp2[1]));
                    annex.put(tmp2[0],list);
                }
            }
        }

        int[] dp = new int[n+1];
        for (int i = 0; i < primary.size(); i++) {
            ArrayList<Integer> w = new ArrayList<>(),v = new ArrayList<>();
            w.add(primary.get(i).v);

        }



    }
}
