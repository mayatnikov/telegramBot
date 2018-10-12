package mvn.tgBot.utils;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

@Component
public class CheckDates {

    private static SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static long diffDays(Date dstart, Date dend) {
        return (dend.getTime() - dstart.getTime()) / (24 * 60 * 60 * 1000);
    }

    public static String addDays(String date, int duration) throws ParseException {
        Date dt= format.parse(date);
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        c.add(Calendar.DATE, duration);
        dt = c.getTime();
        String answ = format.format(dt);
        return answ;
    }



    public static Date getDate(String dt) throws ParseException {
         return format.parse(dt);
    }


    public static int getAge(LocalDate birthday) {
        LocalDate today = LocalDate.now();
        Period p = Period.between(birthday, today);
        return p.getYears();
    }
    public static int getAge(String birthday) throws ParseException {
            LocalDate bd = LocalDate.parse(birthday, formatter);
        return(getAge(bd));
    }

    public static long diffDays(String dstart, String dend) throws ParseException {
        return diffDays(getDate(dstart), getDate(dend));
    }

    public static Date string2Date(String dt) throws ParseException {
        return format.parse(dt);
    }

    public static long diffDays(Date dstart, String dend) throws ParseException {
        Date d1 = dstart;
        Date d2 = format.parse(dend);
        return diffDays(d1, d2);
    }

    // Дата начала не должна быть позднее чем через год

    /**
     *
     * @param dateStart
     * @return 0=все хорошо | 1=не верный формат даты | 2= > позже года от текущей даты | 3-раньше текущей
     * @throws ParseException
     */
    public static int checkDateStart(String dateStart)  {

        Date now = new Date();
        Long diff;
        try {
            diff = diffDays(now, dateStart);
        } catch (ParseException e) {
            return 1;
        }
        if (diff < 0) {
            return 3;
        }
        if (diff > 365) {
            return 2;
        }
        return 0;
    }

    /**
     *
     * @param dateStart
     * @param dateStop
     * @return  0=все хорошо | 1=format error | 2=Дата конца не позднее чем через 90 дней от начала страховки
     */
    public static int checkDateStop(String dateStart, String dateStop) {
        Long diff = null;
        try {
            diff = diffDays(dateStart, dateStop);
            if( diff <90 && diff>0) return 0;
            else return 2;
        } catch (ParseException e) {
           return 1;
        }
    }

    public static String getUnixTimeStamp(String dt) throws ParseException {
//        SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd 00:00:00 Z");
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date d1 = format.parse(dt);
        String result = outFormat.format(d1)+"T00:00:00+03:00";
        return result;
    }

}
/*
    public static void main(String[] args) {
        try {
            long duration = CheckDates.diffDays("05/04/2016","25/04/2016")+15;
            System.out.println(duration);
            System.out.println( CheckDates.addDays("05/04/2016", (int)duration) );
        } catch (ParseException e) {
            System.out.println("error format");
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        CheckDates chdt = new CheckDates();
        try {
            chdt.tests();
        } catch (ParseException e) {
            System.out.println("error format");
            e.printStackTrace();
        }
    }

    private void tests() throws ParseException {

        String[][] menu = {
                {"Страхование квартиры на время поездки"},   // 1
                {"Страхование от несчастного случая"},       // 2
                {"Багаж"},                                   // 3
                {"Отмена поездки"},                          // 4
                {"OK, оформляем"}
        };

        String tmp = menu[0][0];
        System.out.println("tmp="+tmp);
        System.out.println("menu10="+menu[1][0]);
        menu[1][0] = "xxxxx";
        System.out.println("menu10(mod)="+menu[1][0]);
        menu[1][0] = tmp;
        System.out.println("menu10(restore)="+menu[1][0]);


        String dateStart = "22-02-2016";
        String dateStop = "21-05-2016";

        Regexp regexp = new Regexp();
        String s1 = regexp.filterDate(dateStart);
        String s2 = regexp.filterDate(dateStop);


        System.out.println("Date start="+checkDateStart(s1) );
        System.out.println("Date stop ="+checkDateStop(s1,s2) );
        System.out.println("Долительность="+ diffDays(s1,s2 ) );
        }
}

/*

    boolean checkFormat(String dt) {
        Date now = new Date();
        Date dd = null;
        boolean res=true;
        try {
            dd = format.parse(dt);
            long diff = diffDays(now,dd);
            System.out.println("check diff="+diff);
            if( diff < 0  ) {
                res=false;
            }
            if( diff > 365 )  {
                res=false;
            }
        } catch (ParseException e) {
            res = false;
        }
        return res;
    }


        //HH convcheckDateserts hour in 24 hours format (0-23), day calculation

        Date d1 = null;
        Date d2 = null;

        try {

            //in milliseconds
            long diff = d2.getTime() - d1.getTime();

            long diffSeconds = diff / 1000 % 60;
            long diffMinutes = diff / (60 * 1000) % 60;
            long diffHours = diff / (60 * 60 * 1000) % 24;
            long diffDays = diff / (24 * 60 * 60 * 1000);

            System.out.print(diffDays + " days, ");
            System.out.print(diffHours + " hours, ");
            System.out.print(diffMinutes + " minutes, ");
            System.out.print(diffSeconds + " seconds.");

        } catch (Exception e) {
            e.printStackTrace();
        }

 */