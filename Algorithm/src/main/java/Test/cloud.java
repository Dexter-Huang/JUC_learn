package Test;

import java.io.*;

public class cloud {
    public static void read(String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName))));
        String str;
        br.readLine();
        String[] arr=new String[320];
        int i=0;
        while ((str= br.readLine())!=null){
            arr[i]=str;
            i++;
        }

        for(int j=0;j<320;j+=10){
            double avg_time=0.0;
            for(int k=0;k<10;k++){
                String tmp=arr[j+k];
                avg_time+= Double.parseDouble(tmp.split("        ")[2]);
            }
            System.out.printf("%.2f,\n",avg_time/10.00);
        }

        System.out.println("+======================");

//        for(int j=0;j<320;j+=10){
//            double avg_time=0.0;
//            double avg_ef=0.0;
//            for(int k=0;k<10;k++){
//                String tmp=arr[j+k];
//                avg_time+= Double.parseDouble(tmp.split("        ")[2]);
//                avg_ef+=Double.parseDouble(tmp.split("        ")[4]);
//            }
//            System.out.printf("%.2f,\n",avg_ef/10.00);
//        }
        for(int j=0;j<320;j+=10){
            double avg_time=0.0;
            double avg_ef=0.0;
            for(int k=0;k<10;k++){
                String tmp=arr[j+k];
                int size=500;
                int pNum = Integer.parseInt(tmp.split("        ")[0]);
                int lineNum = (size%pNum==0)?(size/pNum):(size/pNum)+1;
                size = lineNum*pNum;
                avg_time+= Double.parseDouble(tmp.split("        ")[2]);
                avg_ef+=(lineNum*size*size)/avg_time;
//                System.out.println("500 "+pNum+" "+lineNum+" "+size);
            }
            System.out.printf("%.2f,\n",avg_ef/10.00);
        }

        System.out.println("+======================");

        br.close();
    }

    public static void main(String[] args) throws IOException {

        read("JUC_File/hhhh.txt");
        read("JUC_File/11.txt");

    }
}
