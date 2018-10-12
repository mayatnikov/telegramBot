package mvn.tgBot.product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductInfoRepository extends MongoRepository<ProductInfo, String> {

    public ProductInfo findById(String id);
    public ProductInfo findByRegName(String regName);

}
