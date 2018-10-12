package mvn.tgBot.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.stereotype.Component;

@Component
public class Pojo2Json {

    Gson gson;

    public Pojo2Json() {
        gson = new GsonBuilder().disableHtmlEscaping().create();      // setPrettyPrinting().
    }

    public String getStr(Object in) {
                    return  gson.toJson(in);
    }
}
