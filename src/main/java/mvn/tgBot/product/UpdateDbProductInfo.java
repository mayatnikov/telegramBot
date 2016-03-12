package mvn.tgBot.product;

import mvn.tgBot.soap.TgProductInfo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ru.toi.model.productinfo.ProductInfoType;

import java.util.List;

@Component
public class UpdateDbProductInfo implements CommandLineRunner {
    private static Log log = LogFactory.getLog(UpdateDbProductInfo.class);

    @Autowired
    ProductInfoRepository db;
    @Autowired
    TgProductInfo tgProductInfo;

    public void run(String... args) throws Exception {
        log.info("Update product-info from server site  ");
        List<ProductInfoType> prList=null;
        try {
            log.info(">>>>>>>>>>>> product INFO <<<<<<<<<<<<<<<");
            prList = tgProductInfo.getResponse();
            if (prList != null)
                for (ProductInfoType pr : prList) {
                    log.info("prod description=" + pr.getFullDescription());
                    ProductInfo productInfo = new ProductInfo();
                    productInfo.setId("A001");
                    productInfo.setRegName(pr.getName());
                    productInfo.setProduct(pr);
                    log.debug("Product name:" + pr.getName());
                    db.save(productInfo);
                    log.info("Product:" + pr.getName() + " was stored in database");
                }
            else log.error("Cannot found productInfo ! Check product name in configuration-file");
        }
        catch ( Exception e ) {
            log.error("=========> soap service error:" + e.getMessage());
        }
    }
}



/*
        log.info(">>>>>>>>>>>> product list <<<<<<<<<<<<<<<");
        List<ProductInfoType> productList = tgProductList.getResponse();
        for (ProductInfoType pr : productList) {
            log.info("name=" + pr.getName());
            log.info("type=" + pr.getProductType());
            log.info("ver=" + pr.getProductVersion());
        }
*/
