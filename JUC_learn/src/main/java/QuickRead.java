import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

public class QuickRead {
    public static void main(String[] args) throws IOException {
        Integer[] ints = new Integer[]{12, 4, 6, 7, 2, 8, 3, 9};
        int[] ints2 = new int[]{8,7,6,5,43,2,1};
        Arrays.sort(ints, Collections.reverseOrder());
//        Arrays.sort(ints2, Collections.reverseOrder());

        System.out.println(Arrays.toString(ints));

    }
}
