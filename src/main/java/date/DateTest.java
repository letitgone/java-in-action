package date;

import java.time.LocalDateTime;
import java.util.Date;

public class DateTest {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        java.sql.Date date1 = new java.sql.Date(new Date().getTime());
        System.out.println(date1);

        //获取当前时间
        LocalDateTime nowTime= LocalDateTime.now();
        //自定义时间
        LocalDateTime endTime = LocalDateTime.of(2017, 10, 22, 10, 10, 10);
        System.out.println(nowTime);
        System.out.println(endTime);

        System.out.println(nowTime.getYear() + ":" + nowTime.getMonthValue() + ":" + nowTime.getDayOfMonth());

    }
}