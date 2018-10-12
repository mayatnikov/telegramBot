package mvn.tgBot.tgExchange;

import com.sun.net.httpserver.Headers;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

import java.nio.charset.Charset;

@Component
public class Header extends HttpHeaders {

    final Charset charset=Charset.forName("UTF-8");
 private Headers headers;
    public Header() {
        this.add("Content-Type", "application/json; charset=utf-8");
        this.add("Accept-Type", "application/json");
        this.add("Accept-Charset", "UTF-8");              // не работает !
        this.add ("Accept-Language", "ru,en;q=0.8,en-US;q=0.6");
    }
}
