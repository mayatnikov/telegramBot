package mvn.tgBot.soap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.toi.model.productinfo.ProductInfoType;
import ru.toi.model.productinfo.servicemessage.GetProductListRequestType;
import ru.toi.model.productinfo.servicemessage.GetProductListResponseType;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 13/02/16
 * Time: 23:24
 */
@Component
public class TgProductList  {
    private Log log = LogFactory.getLog(mvn.tgBot.soap.TgProductList.class);

@Autowired
TgMessageHeader hdr;

@Autowired
    TgSoapService ss;

    public TgProductList() {
        log.debug("service created");
    }


    public List<ProductInfoType> getResponse() {
        GetProductListRequestType req = new GetProductListRequestType();
        if(hdr==null) log.error("hdr is NULL!");
        req.setHeader(hdr.getHeader());

        GetProductListResponseType hndl = ss.getPort().getProductList(req);
        return hndl.getProductInfo();
    }

}
