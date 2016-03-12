package mvn.tgBot.soap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.namespace.QName;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 13/02/16
 * Time: 23:10
 */
@Component
public class TgSoapService {
    private Log log = LogFactory.getLog(TgSoapService.class);

  @Value("${soap.wsdl}")
  private String wsdlFileName; // = "./config/tinkoffSoapService.wsdl";

    private static final QName SERVICE_NAME = new QName("http://toi.ru/esb/services/3rdparty", "ExtPartyInterface");
    private ExtPartyInterface port;

    public void init() {

        URL wsdlURL = null;
        File wsdlFile = new File(wsdlFileName);
        try {
            if (wsdlFile.exists()) {
                log.info("use wsdl file:["+wsdlFileName +"]");
                wsdlURL = wsdlFile.toURI().toURL();
            } else {
                log.warn("wsdl file:["+wsdlFileName +"]-not found");
                wsdlURL = ExtPartyInterface_Service.WSDL_LOCATION;
                log.info("use wsdl from:"+wsdlURL);
            }
            log.debug("soap service created");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        ExtPartyInterface_Service ss = new ExtPartyInterface_Service(wsdlURL, SERVICE_NAME);

        port = ss.getExtPartyInterfaceSOAP();
    }

    public ExtPartyInterface getPort() {
        if(port==null ) init();
        return port;
    }

}
