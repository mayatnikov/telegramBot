package mvn.tgBot.db;

import mvn.tgBot.tgObjects.Contact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AnyContactRepository extends MongoRepository<Contact, String> {

//    public Contact findByphone_number(String phone_number);

}
