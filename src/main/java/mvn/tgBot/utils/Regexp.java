package mvn.tgBot.utils;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class Regexp {
    private final static Log log = LogFactory.getLog(Regexp.class);

    public boolean checkEmail(String in) {
        //@TODO написать проверку корректности email
        return true;
    }

    public double filterAmount(String in) {
        Double am;
        try {
            Pattern p = Pattern.compile("[^0-9\\.,]+");
            String s = filter(in,p,"").replaceAll(",",".");
            am = new Double(s);
        } catch (NumberFormatException e) {
            am = 0D;
        }
        return am;
    }

    public static String filterReplaseDot(String in) {
        log.debug("dot>>>"+in);
        String s2 =in.replaceAll("\\.","_");
        log.debug("<<<"+s2);
        return (s2);
    }

    public static String filterPhone(String in) {
        if(in!=null) {
            log.debug("phone>>>" + in);
            String regexp = "^(7|8|\\+7)(\\d{3})(\\d*)";
            String s2 = in.replaceAll("[^0-9\\+]", "");
            if (s2.length() > 10) {
                s2 = s2.replaceAll(regexp, "7$2$3");
            }
            if (s2.length() == 10) s2 = "7" + s2;
            log.debug("<<<" + s2);
            return (s2);
        }
        else return null;
    }

    public static String filterDate(String in) throws  java.time.DateTimeException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String res = "?";
        String regexp = "^(\\d+)[\\s-/](\\d+)[\\s-/](\\d+)*";
        String [] ss = in.split("[\\s-/\\.]");

//         String [] ss = in.split("[\\s-/\\.]");


        LocalDate now = LocalDate.now();
        int yearNow = now.getYear();
        int monthNow = now.getMonthValue();

        if(ss.length==3) {
            int yearX = Integer.parseInt(ss[2]);
            if(yearX+2000 <= yearNow )  yearX = (yearX<100) ? yearX +2000 : yearX;
            else yearX  = (yearX<100) ? yearX +1900 : yearX;
            LocalDate ld = LocalDate.of( yearX, Integer.parseInt(ss[1]), Integer.parseInt(ss[0]));
            res = ld.format(formatter);
        }
        if(ss.length==2) {
            LocalDate ld = LocalDate.of( yearNow, Integer.parseInt(ss[1]), Integer.parseInt(ss[0]));
            res = ld.format(formatter);
        }
        if(ss.length==1) {
            int dd = Integer.parseInt(ss[0]);
            LocalDate ld;
            if(dd>99)   ld = LocalDate.of( yearNow, dd%100, dd/100 );
            else ld = LocalDate.of( yearNow, monthNow,dd );
            res = ld.format(formatter);
        }
        return res;
    }

    // выделение от начала чисел разделенных точкой
    public static String[] filterIndexCol(String in) {
        log.debug("Index>>>"+in);
        String regexp= "^(\\d{1})[:](.*)[:](.*)$";
        String [] ret = new String[3];
        ret[0] = in.replaceAll(regexp, "$1");
        ret[1] = in.replaceAll(regexp, "$2");
        ret[2] = in.replaceAll(regexp, "$3");

        log.debug("Index<<<"+ret[0]+" | "+ ret[1] +" | "+ ret[2]);
        return (ret);
    }

    // выделение первых 4-х слов из: IVAN IVANOV 25.05.1985 745865452
    public static String[] filterUserData(String in) {
        log.debug("in>>>"+in);

        String regexp= "\\s+";
        String[] r = in.split(regexp);
        log.debug("ret size="+r.length);
        return (r);
    }

    public static boolean isLatin(String in ) {
        return in.matches("[A-Za-z\\-]+");
    }

    public static void main (String ... args ) {
        String[] in = {"Petrov",
                "Sid/orov","Sid;orov","Sid_orov","Sid=orov","Lev-ham","Ort-петров",
                "петров"};
        for(int tik=0;tik<in.length;tik++) {
            System.out.println(in[tik]+ ">>>" + Regexp.isLatin(in[tik])  );
        }
    }


    public String[] parseWorlds(String in) {  // просто синоним
        return filterUserData(in);
    }


    public String filterDigital(String in) {
        Pattern p = Pattern.compile("[^0-9]+");
        return filter(in,p,"");
    }
    public String filterPassport(String in) {
//@TODO сделать доп проверки ПАСПОРТА
        return filterDigital(in);
    }

    private String filter(String in, Pattern p, String replaceto) {

        Matcher m = p.matcher(in);
        StringBuffer sb = new StringBuffer();
        boolean result = m.find();
        boolean deletedIllegalChars = false;

        while(result) {
            deletedIllegalChars = true;
            m.appendReplacement(sb, replaceto);
            result = m.find();
        }
        // Add the last segment of input to the new String
        m.appendTail(sb);

        String res = sb.toString();
        if (deletedIllegalChars) {
            // предупреждение - часть симолов не цифры - удалены
            log.warn("delete same not digital chars");
        }
       return res;
    }
}



/*
    public static void main (String ... args ) {
        Regexp re = new Regexp();
        String[] in = {"79165894332","89143456655","+7(916)7776655"};
        for(int tik=0;tik<in.length;tik++) {
            String ans = re.filterPhone(in[tik]);
            System.out.println(in[tik]+ ">>>" + ans);
        }
    }

    public static void main (String ... args ) {
        Regexp re = new Regexp();
        String in1[] = {"11-11-96","6-1-1998","06.01.1998","06-01","12/08/1999","14 06 2017","12/05/16","14 06 2015","0304","1201","7", "21","121"};
        for(int tik=0;tik< in1.length;tik++) {
            System.out.println(">>>>> "+in1[tik]);
            try {
                String res = re.filterDate(in1[tik]);
                System.out.println("<<<<<< "+res);
                System.out.println();
            } catch ( java.time.DateTimeException e) {
                System.out.println("=====>"+ e.getMessage());
            }
        }
    }


    public static void main (String ... args ) {

        String[][] menu = {
                {"m1"},
                {"m2"},
                {"m3"}
        };
        String[][] arr = new String[7][1];
        for(int tik=0;tik<7;tik++) {
            arr[tik][0] ="tik="+tik;
        }
        for(int tik=0;tik<7;tik++) {
            System.out.println(arr[tik][0]);
        }
        for(int tik=0;tik<3;tik++) {
            System.out.println(menu[tik][0]);
        }
    }



    public static void main (String ... args ) {
        Regexp re = new Regexp();
        String in = "PETRO sidoro 12/08/1999 888777666";
        String[] ans = re.filterUserData(in);
        System.out.println("ans="+ans);
    }


    public static void main (String ... args ) {
        Regexp re = new Regexp();
        String in = "3.4";
        String ans = re.filterReplaseDot(in);
        System.out.println("ans="+ans);
    }


    public static void main (String ... args ) {

        Regexp re = new Regexp();
        String in = "3.4) от 12 до 60: IVANOV IVAN 12/01/2012 670007654";
        String[] ans = re.filterIndexCol(in);
        System.out.println("1="+ans[0]+" 2="+ans[1]);
    }

    public static void main (String ... args ) {

    Regexp re = new Regexp();
        System.out.println(re.filterAmount("   234,23"));
        System.out.println(re.filterAmount("23   4.23"));
        System.out.println(re.filterAmount("abcd234.eee @_~# / 23"));
        System.out.println(re.filterDigital("abcd234.eee @_~# / 23"));

        Double dd = new Double( re.filterAmount("abcd234.eee @_~# / 23")) ;
        System.out.println("Double="+dd);
    }

public class EmailValidation {

     public static void main(String[] args) throws Exception {

        System.out.println("res:["+filterDigital("+7 916-589 43 32");

    }

    public static void main(String[] args)
            throws Exception {

        String input = "@sun.com";
        //Checks for email addresses starting with
        //inappropriate symbols like dots or @ signs.
        Pattern p = Pattern.compile("^\\.|^\\@");
        Matcher m = p.matcher(input);
        if (m.find())
            System.err.println("Email addresses don't start" +
                    " with dots or @ signs.");
        //Checks for email addresses that start with
        //www. and prints a message if it does.
        p = Pattern.compile("^www\\.");
        m = p.matcher(input);
        if (m.find()) {
            System.out.println("Email addresses don't start" +
                    " with \"www.\", only web pages do.");
        }
        p = Pattern.compile("[^A-Za-z0-9\\.\\@_\\-~#]+");
        m = p.matcher(input);
        StringBuffer sb = new StringBuffer();
        boolean result = m.find();
        boolean deletedIllegalChars = false;

        while(result) {
            deletedIllegalChars = true;
            m.appendReplacement(sb, "");
            result = m.find();
        }

        // Add the last segment of input to the new String
        m.appendTail(sb);

        input = sb.toString();

        if (deletedIllegalChars) {
            System.out.println("It contained incorrect characters" +
                    " , such as spaces or commas.");
        }
    }
}



 */