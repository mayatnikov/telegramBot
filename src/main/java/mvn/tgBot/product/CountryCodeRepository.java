package mvn.tgBot.product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface CountryCodeRepository extends MongoRepository<CountryCode, String> {

    public CountryCode findById(String id);
    public CountryCode findByName(String name);

}
