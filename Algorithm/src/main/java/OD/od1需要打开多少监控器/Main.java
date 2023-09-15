package OD.od1需要打开多少监控器;

import java.io.*;

public class Main {

    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    static StreamTokenizer st = new StreamTokenizer(in);
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));

    static int read() throws IOException {
        st.nextToken();
        return (int) st.nval;
    }

    static int m, n, N = 21;
    static int[][] matrix = new int[N][N];
    static int[][] offsets = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        m = read();
        n = read();
        // 读入矩阵
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = read();
            }
        }
        out.println(getResult(m, n, matrix));
        out.flush();
    }

    public static int getResult(int m, int n, int[][] matrix) {
        int cnt = 0;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                if (matrix[x][y] == 1) {
                    cnt++;
                    continue;
                }

                for (int i = 0; i < 4; i++) {
                    int newX = x + offsets[i][0];
                    int newY = y + offsets[i][1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && matrix[newX][newY] == 1) {
                        cnt++;
                        break;
                    }
                }
            }
        }
        return cnt;
    }
}
