

package com.example.webdemo.test;

//import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTest {

//    @Test
    public void test() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date parse = sdf.parse("2018-03-21 10:32:33.333");
        System.out.println(parse);
        System.out.println(parse.getTime());

        long time = parse.getTime();
        String format = sdf.format(new Date(time));
        System.out.println(format);
    }

//    @Test
    public void test2() throws ParseException {
        long l = covertToMillisecond("2018-03-21 10:32:33.333");
        System.out.println(l);
    }

    public static long covertToMillisecond(String dateStr) {
        Calendar calendar = Calendar.getInstance();
        try {
            Date date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").parse(dateStr);
            calendar.setTime(date);
        } catch (ParseException e) {
            System.out.println(dateStr + "is not format as yyyy-MM-dd HH:mm:ss.SSS");
        }
        return calendar.getTimeInMillis();
    }
}
