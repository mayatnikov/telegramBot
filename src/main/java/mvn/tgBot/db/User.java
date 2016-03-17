package mvn.tgBot.db;

import mvn.tgBot.utils.Regexp;
import org.springframework.data.annotation.Id;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 20/11/15
 * Time: 16:06
 * параметры для страховки
 */

public class User {
    @Id
    private String id;      // tg-[chatId]
    boolean NewUser;      // этот chat здесь впервые
    String firstName;
    String lastName;
    String secondName;
    String userName;  // имя в телеграм
    String firstNameEng;
    String lastNameEng;
    String passport;
    Long chatId;
    // -- статус диалога
    String wait4Stage;      //  для какой state ожидается ввод
    boolean lastErr;        // признак повтора state была ошибка ввода
    PolicyType policyType;   // тип полиса onetrip / annual
    CountryType countryType;   // много / одна / region
    RegionType regionType;   //  WORLD, ASIA, SHENGEN
    String countryName;       // название страны или список через запятую
    String countryCode;
    HolidayType holidayType;    // вид отдыха СПОКОЙНЫЙ / АКТИВНЫЙ / ОПАСНЫЙ
    boolean ensuranceOptEnable;  // есть или нет опции страхования
    EnsuranceOptType ensuranceOpt1; // Опции страховки
    EnsuranceOptType ensuranceOpt2; // Опции страховки
    EnsuranceOptType ensuranceOpt3; // Опции страховки
    EnsuranceOptType ensuranceOpt4; // Опции страховки
    boolean roolesAccept;       // согласие с правилами
    String dateFrom;            // даты для документов начало
    String dateTo;              // конец
    String dateReg;             // подачи в посольство
    String datePolicyEnd;           // дата окончания полиса +15 дней для Шенген
    String dateDuration;        // продолжительность (с учетом +15 дней для Шенген)
    String phone;
    String email;
    SexType sex;
    String birthday;
    String Address1;
    String Address2;
    int ensuredNumber;            // количество виз люди
    int oldNumber;              // количество виз старики
    int childNumber;            // количество виз дети
    HashMap<String,EnsuredType> ensured;      // список застрахованных
    HashMap<String,EnsuredType> ensuredOld;      // список застрахованных старики
    HashMap<String,EnsuredType> ensuredChild;      // список застрахованных дети
    String ensuredCurrentKey; // текущий ключ для стадии ввода страхуемого
    HashMap<String,EnsuredType> ensuredAll;       // все ранее введеные ключ = FN + ":" +LN
    Long opDate;
    boolean correctMode;  // режим корректировки историю не сбрасывать!

    public User() {}
    public User(String id, Long chatId, String userName, String wait4Stage) {
        this.id = id;
        this.userName = userName;
        this.chatId = chatId;
        this.wait4Stage = wait4Stage;
    }

    public HashMap<String, EnsuredType> getEnsuredAll() {
        return ensuredAll;
    }

    public void setEnsuredAll(HashMap<String, EnsuredType> ensuredAll) {
        this.ensuredAll = ensuredAll;
    }

    public String getDatePolicyEnd() {   return datePolicyEnd;  }
    public void setDatePolicyEnd(String datePolicyEnd) {    this.datePolicyEnd = datePolicyEnd;   }
    public String getPassport() {   return passport;  }
    public void setPassport(String passport) { this.passport = passport;  }
    public String getFirstNameEng() {    return firstNameEng;  }
    public void setFirstNameEng(String firstNameEng) {   this.firstNameEng = firstNameEng;  }
    public String getLastNameEng() {  return lastNameEng;  }
    public void setLastNameEng(String lastNameEng) {  this.lastNameEng = lastNameEng;  }
    public String getDateDuration() {  return dateDuration;  }
    public void setDateDuration(String dateDuration) {
        this.dateDuration = dateDuration;
    }
    public String getCountryCode() {
        return countryCode;
    }
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
    public boolean isCorrectMode() {
        return correctMode;
    }
    public void setCorrectMode(boolean correctMode) {
        this.correctMode = correctMode;
    }
    public Long getOpDate() {
        return opDate;
    }
    public void setOpDate(Long opDate) {
        this.opDate = opDate;
    }
    public String getEnsuredCurrentKey() {
        return ensuredCurrentKey;
    }
    public void setEnsuredCurrentKey(String ensuredCurrentKey) {
        this.ensuredCurrentKey = ensuredCurrentKey;
    }
    public int getEnsuredNumber() {
        return ensuredNumber;
    }
    public void setEnsuredNumber(int ensuredNumber) {
        this.ensuredNumber = ensuredNumber;
    }
    public HashMap<String, EnsuredType> getEnsuredOld() {
        return ensuredOld;
    }
    public void setEnsuredOld(HashMap<String, EnsuredType> ensuredOld) {
        this.ensuredOld = ensuredOld;
    }
    public HashMap<String, EnsuredType> getEnsuredChild() {
        return ensuredChild;
    }
    public void setEnsuredChild(HashMap<String, EnsuredType> ensuredChild) {
        this.ensuredChild = ensuredChild;
    }
    public boolean isEnsuranceOptEnable() {
        return ensuranceOptEnable;
    }
    public void setEnsuranceOptEnable(boolean ensuranceOptEnable) {
        this.ensuranceOptEnable = ensuranceOptEnable;
    }
    public String getCountryName() {
        return countryName;
    }
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
    public CountryType getCountryType() {  return countryType;  }
    public void setCountryType(CountryType countryType) { this.countryType = countryType; }
    public boolean isNewUser() {
        return NewUser;
    }
    public void setNewUser(boolean newUser) {
        NewUser = newUser;
    }
    public String getDateFrom() {
        return dateFrom;
    }
    public EnsuranceOptType getEnsuranceOpt1() {
        return ensuranceOpt1;
    }
    public void setEnsuranceOpt1(EnsuranceOptType ensuranceOpt1) {
        this.ensuranceOpt1 = ensuranceOpt1;
    }
    public EnsuranceOptType getEnsuranceOpt2() {
        return ensuranceOpt2;
    }
    public void setEnsuranceOpt2(EnsuranceOptType ensuranceOpt2) {
        this.ensuranceOpt2 = ensuranceOpt2;
    }
    public EnsuranceOptType getEnsuranceOpt3() {
        return ensuranceOpt3;
    }
    public void setEnsuranceOpt3(EnsuranceOptType ensuranceOpt3) {
        this.ensuranceOpt3 = ensuranceOpt3;
    }
    public EnsuranceOptType getEnsuranceOpt4() {
        return ensuranceOpt4;
    }
    public void setEnsuranceOpt4(EnsuranceOptType ensuranceOpt4) {
        this.ensuranceOpt4 = ensuranceOpt4;
    }
    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }
    public String getDateTo() {
        return dateTo;
    }
    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
    public String getDateReg() {
        return dateReg;
    }
    public void setDateReg(String dateReg) {
        this.dateReg = dateReg;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getSecondName() {
        return secondName;
    }
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public Long getChatId() {
        return chatId;
    }
    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }
    public String getWait4Stage() {   return wait4Stage;  }
    public void setWait4Stage(String wait4Stage) {
        this.wait4Stage = wait4Stage;
    }
    public boolean isLastErr() {
        return lastErr;
    }
    public void setLastErr(boolean lastErr) {
        this.lastErr = lastErr;
    }
    public PolicyType getPolicyType() {
        return policyType;
    }
    public void setPolicyType(PolicyType policyType) {
        this.policyType = policyType;
    }
    public RegionType getRegionType() {
        return regionType;
    }
    public void setRegionType(RegionType regionType) {
        this.regionType = regionType;
    }
    public int getOldNumber() {
        return oldNumber;
    }
    public void setOldNumber(int oldNumber) {
        this.oldNumber = oldNumber;
    }
    public int getChildNumber() {
        return childNumber;
    }
    public void setChildNumber(int childNumber) {
        this.childNumber = childNumber;
    }
    public HolidayType getHolidayType() {
        return holidayType;
    }
    public void setHolidayType(HolidayType holidayType) {
        this.holidayType = holidayType;
    }
    public boolean isRoolesAccept() {
        return roolesAccept;
    }
    public void setRoolesAccept(boolean roolesAccept) {
        this.roolesAccept = roolesAccept;
    }
    public String getPhone() {
        return Regexp.filterPhone(phone);
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public SexType getSex() {
        return sex;
    }
    public void setSex(SexType sex) {
        this.sex = sex;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
    public String getAddress1() {
        return Address1;
    }
    public void setAddress1(String address1) {
        Address1 = address1;
    }
    public String getAddress2() {
        return Address2;
    }
    public void setAddress2(String address2) {
        Address2 = address2;
    }
    public HashMap<String, EnsuredType> getEnsured() {
        if(ensured == null) ensured = new HashMap();
        return ensured;
    }
    public void setEnsured(HashMap<String, EnsuredType> ensured) { this.ensured = ensured;  }

    public boolean isValid() {
        return (phone!=null && firstName!=null && lastName!=null && email!=null && Address1!=null && Address2!=null );
    }
}








