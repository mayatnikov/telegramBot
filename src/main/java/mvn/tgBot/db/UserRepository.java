package mvn.tgBot.db;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {

    public User findByChatId(long chatId);
    public User findByPhone(String phone);

}
