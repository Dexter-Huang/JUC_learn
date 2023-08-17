import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;

public class Test2 {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) throws IOException {
        int[] arr = Arrays.stream(in.readLine().split(",")).mapToInt(Integer::parseInt).toArray();
        int sum = 0;
        for (int i = 0; i < arr.length-1; i++) {
            sum+= Math.abs(arr[i]-arr[i+1]);
        }

        out.println(sum);

        out.flush();


    }

}
