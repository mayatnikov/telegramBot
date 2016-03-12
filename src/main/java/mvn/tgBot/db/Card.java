package mvn.tgBot.db;

import org.springframework.data.annotation.Id;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 20/11/15
 * Time: 16:44
 */
public class Card {
    @Id
    private String id;

    String cn;
    Long amount;

    public Card(String id, String cn, Long amount) {
        this.id = id;
        this.cn = cn;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCn() {
        return cn;
    }

    public void setCn(String cn) {
        this.cn = cn;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
