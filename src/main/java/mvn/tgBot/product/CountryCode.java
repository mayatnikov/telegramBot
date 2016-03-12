package mvn.tgBot.product;

import org.springframework.data.annotation.Id;

public class CountryCode {
     @Id
     private String id;

     private String countryCode;
     String Name;

     public CountryCode(String id,String countryCode, String name) {
          this.countryCode = countryCode;
          this.id = id;
          Name = name;
     }

     public String getCountryCode() {
          return countryCode;
     }

     public void setCountryCode(String countryCode) {
          this.countryCode = countryCode;
     }

     public String getName() {
          return Name;
     }

     public void setName(String name) {
          Name = name;
     }

}








