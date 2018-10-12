package mvn.tgBot.db;

import org.springframework.data.annotation.Id;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 22/11/15
 * Time: 10:45
 */
public class UnknownUser {

    @Id
    private Long id;
    String firstName;
    String lastName;
    String userName;
    Long chatId;

    public UnknownUser(Long id,String firstName, String lastName, String userName, Long chatId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.chatId = chatId;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
