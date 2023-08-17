import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class lab7 {
    public static void main(String[] args) throws IOException {
        File file = new File("JUC_File/log.txt");
        System.out.println(file.getAbsolutePath()+file.exists());
        BufferedReader br  =new BufferedReader(new FileReader(new File("JUC_File/log.txt")));
        String str = "";
        ArrayList<String> list = new ArrayList<>();
        boolean reachMsg = false;
        int mergeCnt = 0;

        while ((str=br.readLine())!=null){
            if(reachMsg&&!str.startsWith("commit")){
                list.set(list.size()-1, list.get(list.size()-1)+str);
            }

            if(str.startsWith("commit")){
                list.add("");
                reachMsg = false;
            }

            if(str.startsWith("Merge"))
                mergeCnt++;
            if(str.startsWith("Date")){
                reachMsg = true;
            }

        }

        double totalNum = list.size();
        double commitWithMsg = 0;
        double commitTotalLen = 0;
        double commitWithFix = 0;
        for(int i=0;i< list.size();i++){
            commitTotalLen+=list.get(i).length();
            if(!list.get(i).equals(""))
                commitWithMsg++;
            if(list.get(i).contains("fix")||list.get(i).contains("bug fix"))
                commitWithFix++;
        }
        double averageCommitLen = commitTotalLen/totalNum;

        System.out.printf("%f \n",(commitWithMsg/totalNum)*100);
        System.out.printf("%f \n",(commitWithFix/totalNum)*100);
        System.out.printf("%f \n",averageCommitLen);
        System.out.printf("%f \n",(mergeCnt/totalNum)*100);



        br.close();
    }
}
