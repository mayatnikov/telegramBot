package mvn.abby;

import com.abbyy.result.DocumentType;
import com.abbyy.result.FieldType;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 10/03/16
 * Time: 00:22
 */
public class ResultFields {

    HashMap<String,String> allFields;


    public ResultFields(File in) throws JAXBException, FileNotFoundException {
        FileInputStream fin = new FileInputStream(in);
        new ResultFields(fin);
    }

    public ResultFields(InputStream in) throws JAXBException {
        JAXBContext jc;
        jc = JAXBContext.newInstance(DocumentType.class);
        Unmarshaller unmarshaller = jc.createUnmarshaller();
        DocumentType d = (DocumentType) unmarshaller.unmarshal(in);
        List<Object> flds = d.getFieldOrTableOrBlock();
        allFields = new HashMap();
        for (Object obj : flds) {
            FieldType field = (FieldType)obj;
            allFields.put(field.getType(),field.getValue());
        }

    }

    public String getFieldByType(String type) { return allFields.get(type); }


    public static void main(String[] args) throws JAXBException, FileNotFoundException {
        ResultFields flds = new ResultFields(new File("res"));
        System.out.println("LastName:"+flds.getFieldByType("LastName"));
    }
}
