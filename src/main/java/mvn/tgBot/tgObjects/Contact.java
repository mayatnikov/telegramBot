package mvn.tgBot.tgObjects;

import org.springframework.data.annotation.Id;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 18/11/15
 * Time: 13:24
 */
public class Contact {
    @Id
    String phone_number;
    String first_name;
    Long user_id;

    public String getPhone_number() { return phone_number; }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
