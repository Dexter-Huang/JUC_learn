package Test;

import org.apache.commons.lang.time.DateFormatUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class CalculateWorkDaysUtil {

    /*
      特殊的工作日(星期六、日工作)
              */
    public static List<String> SPECIAL_WORK_DAYS = new ArrayList<>();


    /*   特殊的休息日(星期一到五休息)
     */
    public static List<String> SPECIAL_REST_DAYS = new ArrayList<>();


    public static int getworkDays(String strStartDate, String strEndDate) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Calendar cl1 = Calendar.getInstance();
        Calendar cl2 = Calendar.getInstance();

        try {
            cl1.setTime(df.parse(strStartDate));
            cl2.setTime(df.parse(strEndDate));

        } catch (ParseException e) {
            System.out.println("日期格式非法");
            e.printStackTrace();
        }

        int count = 0;
        while (cl1.compareTo(cl2) <= 0) {
            //如果不是周六或者周日则工作日+1
            if (cl1.get(Calendar.DAY_OF_WEEK) != 7 && cl1.get(Calendar.DAY_OF_WEEK) != 1) {
                count++;
                //如果不是周六或者周日，但是该日属于国家法定节假日或者特殊放假日则-1
                if (SPECIAL_REST_DAYS.contains(DateFormatUtils.format(cl1.getTime(), "yyyy-MM-dd"))) {
                    count--;
                }
            }
            //如果是周六或者周日，但是该日属于需要工作的日子则 +1
            if (SPECIAL_WORK_DAYS.contains(DateFormatUtils.format(cl1.getTime(), "yyyy-MM-dd"))) {
                count++;
            }
            cl1.add(Calendar.DAY_OF_MONTH, 1);
        }
        return count;
    }

    public static void main(String[] args) {
//        System.out.println(
//                getworkDays("2021-09-30", "2021-10-07")
//        );

        ArrayList<Integer> tt = new ArrayList<>();
        System.out.println(tt.size());
        System.out.println(tt);

    }

}
