package HJ;

import java.io.*;

public class HJ1_字符串最后一个单词的长度 {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);


    public static void main(String[] args) throws IOException {
        String[] strArr = in.readLine().split(" ");
        out.println(strArr[strArr.length-1].length());
        out.flush();

    }
}
