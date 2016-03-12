package mvn.tgBot.product;

import org.springframework.data.annotation.Id;
import ru.toi.model.productinfo.ProductInfoType;

public class ProductInfo {
     @Id
     private String id;
     String regName;
     ProductInfoType product;

     public String getId() {
          return id;
     }

     public void setId(String id) {
          this.id = id;
     }

     public String getRegName() {
          return regName;
     }

     public void setRegName(String regName) {
          this.regName = regName;
     }

     public ProductInfoType getProduct() {
          return product;
     }

     public void setProduct(ProductInfoType product) {
          this.product = product;
     }
}








