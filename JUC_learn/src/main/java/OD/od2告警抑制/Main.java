package OD.od2告警抑制;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(System.out);

    public static int read() throws IOException {
        st.nextToken();
        return (int)st.nval;
    }

    public static String readChar() throws IOException{
        st.nextToken();
        return st.sval;
    }

    static int num;
    static HashMap<String, HashSet<String>> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        num = read();
        for(int i=0;i<num;i++){
            String start = readChar(), end = readChar();
            map.putIfAbsent(end,new HashSet<>());
            map.get(end).add(start);
        }
        String[] list = in.readLine().split(" ");
        HashSet<String> alertSet = new HashSet<>(Arrays.asList(list));

        StringJoiner ans = new StringJoiner(" ");

        for (String tmp:list){
            if(!map.containsKey(tmp)||Collections.disjoint(alertSet,map.get(tmp))){
                ans.add(tmp);
            }
        }

        out.println(ans);
        out.flush();
    }

}
