package mvn.tgBot.db;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface HistoryRepository extends MongoRepository<History, String> {

    public History findByChatId(long chatId);
    public History findByPhone(String phone);

}
