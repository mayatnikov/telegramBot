package mvn.tgBot.soap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import ru.toi.model.productinfo.ProductInfoType;
import ru.toi.model.productinfo.servicemessage.GetProductInfoRequestType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 13/02/16
 * Time: 23:24
 */
@Component
public class TgProductInfo {
    private Log log = LogFactory.getLog(TgMessageHeader.class);

    @Value("${soap.prodName}")
    String prodName;

    @Autowired
    TgMessageHeader hdr;

    @Autowired
    TgSoapService ss;

    public TgProductInfo() {
        log.debug("created");
    }


    public List<ProductInfoType> getResponse() {
        GetProductInfoRequestType req = new GetProductInfoRequestType();
        req.setHeader(hdr.getHeader());
        req.setProductName(prodName);
        return ss.getPort().getProductInfo(req).getProductInfo();
    }

}
