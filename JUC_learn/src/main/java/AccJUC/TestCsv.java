package AccJUC;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class TestCsv {
    public static void main(String[] args) throws IOException {
        // 读test.csv文件
        BufferedReader br = new BufferedReader(new FileReader("D:\\Desktop\\2022_interview\\interview\\mycode\\JUC_learn\\src\\main\\java\\AccJUC\\test.csv"));
        String line = br.readLine();
        ArrayList<Integer> vectorWithoutReRank = new ArrayList<>();
        ArrayList<Integer> vectorWithReRank = new ArrayList<>();
        ArrayList<Integer> fullTextWithoutReRank = new ArrayList<>();
        ArrayList<Integer> fullTextWithReRank = new ArrayList<>();
        ArrayList<Integer> mixedWithoutReRank = new ArrayList<>();
        ArrayList<Integer> mixedWithReRank = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            int[] split = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
            vectorWithoutReRank.add(split[0]);
            vectorWithReRank.add(split[1]);
            fullTextWithoutReRank.add(split[2]);
            fullTextWithReRank.add(split[3]);
            mixedWithoutReRank.add(split[4]);
            mixedWithReRank.add(split[5]);
        }

//        计算HitRate(vectorWithoutReRank, vectorWithReRank);
        System.out.println("====计算HitRate(匹配到第一个)====");
        calHitRate(vectorWithoutReRank, "语义搜索不重排：",0);
        calHitRate(vectorWithReRank, "语义搜索重排：",0);
        calHitRate(fullTextWithoutReRank, "全文搜索不重排：",0);
        calHitRate(fullTextWithReRank, "全文搜索重排：",0);
        calHitRate(mixedWithoutReRank, "混合搜索不重排：",0);
        calHitRate(mixedWithReRank, "混合搜索重排：",0);

        System.out.println("====计算HitRate(匹配到第二个)====");
        calHitRate(vectorWithoutReRank, "语义搜索不重排：",1);
        calHitRate(vectorWithReRank, "语义搜索重排：",1);
        calHitRate(fullTextWithoutReRank, "全文搜索不重排：",1);
        calHitRate(fullTextWithReRank, "全文搜索重排：",1);
        calHitRate(mixedWithoutReRank, "混合搜索不重排：",1);
        calHitRate(mixedWithReRank, "混合搜索重排：",1);

        System.out.println("====计算HitRate(匹配到第三个)====");
        calHitRate(vectorWithoutReRank, "语义搜索不重排：",2);
        calHitRate(vectorWithReRank, "语义搜索重排：",2);
        calHitRate(fullTextWithoutReRank, "全文搜索不重排：",2);
        calHitRate(fullTextWithReRank, "全文搜索重排：",2);
        calHitRate(mixedWithoutReRank, "混合搜索不重排：",2);
        calHitRate(mixedWithReRank, "混合搜索重排：",2);

        System.out.println("====计算MRR====");
        calMRR(vectorWithoutReRank, "语义搜索不重排：");
        calMRR(vectorWithReRank, "语义搜索重排：");
        calMRR(fullTextWithoutReRank, "全文搜索不重排：");
        calMRR(fullTextWithReRank, "全文搜索重排：");
        calMRR(mixedWithoutReRank, "混合搜索不重排：");
        calMRR(mixedWithReRank, "混合搜索重排：");

    }

    public static void calHitRate(ArrayList<Integer> vectorWithoutReRank, String prompt, int max) {
        double hit = 0, total= vectorWithoutReRank.size();
        for (int i = 0; i < total; i++) {
            if (vectorWithoutReRank.get(i) <=max) {
                hit++;
            }
        }
        System.out.println(prompt + hit/total);
    }

    // 计算MRR
    public static void calMRR(ArrayList<Integer> vectorWithoutReRank, String prompt) {
        double mrr = 0, total= vectorWithoutReRank.size();
        for (int i = 0; i < total; i++) {
            if (vectorWithoutReRank.get(i) <=1) {
                mrr += 1.0/(i+1);
            }
        }
        System.out.println(prompt + mrr/total);
    }
}
