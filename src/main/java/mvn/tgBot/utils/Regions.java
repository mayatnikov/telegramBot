package mvn.tgBot.utils;

import mvn.tgBot.db.RegionType;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 16/03/16
 * Time: 08:54
 */
public  class Regions {
    private static HashMap<RegionType,String> reg;
    public static String get(RegionType r) {
        if(reg==null) {
            reg = new HashMap();
            reg.put(RegionType.ASIA,"Азию");
            reg.put(RegionType.SHENGEN,"Шенген");
            reg.put(RegionType.WORLDWIDE,"Весь Мир");
        }
        return reg.get(r);
    }

}
