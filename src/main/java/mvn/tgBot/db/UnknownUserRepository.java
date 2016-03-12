package mvn.tgBot.db;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UnknownUserRepository extends MongoRepository<UnknownUser, String> {

    public UnknownUser findByChatId(long chatId);
    public UnknownUser findByUserName(String userName);

}
