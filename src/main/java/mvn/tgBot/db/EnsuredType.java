package mvn.tgBot.db;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 18/02/16
 * Time: 22:31
 * застрахованный
 */
public class EnsuredType {
    String firstName;
    String lastName;
    String birthday;
    String pasport;
    String age;              // 3 для <12   1 для 12-60    2 для >60

    public EnsuredType(String firstName, String lastName, String birthday, String pasport, String age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthday = birthday;
        this.pasport = pasport;
        this.age = age;
    }

    public EnsuredType() {
    }

    public EnsuredType(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public  EnsuredType(String[] mm,String key) {
        this.firstName = mm[0];
        this.lastName = mm[1];
        this.birthday = mm[2];
        this.pasport = mm[3];
        this.age = key;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPasport() {
        return pasport;
    }

    public void setPasport(String pasport) {
        this.pasport = pasport;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
    public String toString() {
        return firstName+" "+lastName+" "+birthday+" "+pasport;
    }
}

