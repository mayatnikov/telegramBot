package mvn.tgBot.soap;

import mvn.tgBot.db.EnsuredType;
import mvn.tgBot.db.SexType;
import mvn.tgBot.db.User;
import mvn.tgBot.utils.CheckDates;
import mvn.tgBot.utils.Regexp;
import ru.toi.model.common.DocumentTypeType;
import ru.toi.model.common.GenderType;
import ru.toi.model.gw.client.*;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.text.ParseException;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created with IntelliJ IDEA.
 * User: vitaly
 * Date: 05/03/16
 * Time: 13:01
 */
public class TgClientInfo {


    /**
     *  ClientInfo для полиса
     */
    public static ClientInfoType getAdultInfo(User user, EnsuredType client) throws ParseException, DatatypeConfigurationException {

        ClientInfoType resp = new ClientInfoType();
        resp.getAccountRole().add(AccountRoleType.PRIMARYINSURED);
//        resp.getAccountRole().add(AccountRoleType.CHILD);
//        resp.getAccountRole().add(AccountRoleType.SENIOR);
        resp.setAccountType(AccountTypeType.PERSONAL);
        resp.setLastName(user.getLastName());
        resp.setFirstName(user.getFirstName());
        resp.setMiddleName(user.getSecondName());
        resp.setLastNameEng(client.getLastName());
        resp.setFirstNameEng(client.getFirstName());
        resp.setEmail(user.getEmail());
        resp.setMobilePhone(user.getPhone());
        if(user.getSex() == SexType.MEN)   resp.setGender(GenderType.MALE);
        else resp.setGender(GenderType.FEMALE);
        resp.setTypePrimaryPhone(TypePrimaryPhoneType.MOBILE_MAIN);
        resp.getDocument().add(getDocument(client));
// ========== ДР =========
        resp.setBirthdate(getBirthday(client));
// =============
        return resp;

    }

    /**
     * ClientInfo для полиса о стариках
     * @param client  (  FIO ДР ПАСПОРТ )
     * @return
     * @throws ParseException
     * @throws DatatypeConfigurationException
     */
    public static ClientInfoType getSeniorInfo(EnsuredType client) throws ParseException, DatatypeConfigurationException {
        String s1 = "????";
        ClientInfoType resp = new ClientInfoType();
        resp.getAccountRole().add(AccountRoleType.SENIOR);
        resp.setAccountType(AccountTypeType.PERSONAL);
        resp.setLastName(s1);
        resp.setFirstName(s1);
        resp.setMiddleName(s1);
        resp.setLastNameEng(client.getLastName());
        resp.setFirstNameEng(client.getFirstName());
        resp.getDocument().add(getDocument(client));
// ========== ДР =========
        resp.setBirthdate(getBirthday(client));
// =============
        return resp;
    }

    /**
     * ClientInfo для детей
     * @param client (  FIO ДР ПАСПОРТ )
     * @return
     * @throws ParseException
     * @throws DatatypeConfigurationException
     */
    public static ClientInfoType getChildInfo(EnsuredType client) throws ParseException, DatatypeConfigurationException {
        String s1 = "????";
        ClientInfoType resp = new ClientInfoType();
        resp.getAccountRole().add(AccountRoleType.CHILD);
        resp.setAccountType(AccountTypeType.PERSONAL);
        resp.setLastName(s1);
        resp.setFirstName(s1);
        resp.setMiddleName(s1);
        resp.setLastNameEng(client.getLastName());
        resp.setFirstNameEng(client.getFirstName());
        resp.getDocument().add(getDocument(client));
// ========== ДР =========
        resp.setBirthdate(getBirthday(client));
// =============
        return resp;
    }

    private static DocumentType getDocument(EnsuredType client) {
        DocumentType doc1 = new DocumentType();
        doc1.setDocumentType(DocumentTypeType.EXT_PASSPORT_RUS);
        doc1.setSeries(client.getPasport().substring(0,2));
        doc1.setNumber(client.getPasport().substring(2));
        doc1.setIsActive(true);
        return doc1;
    }

    private static XMLGregorianCalendar getBirthday(EnsuredType client) throws ParseException, DatatypeConfigurationException {
        CheckDates checkDates = new CheckDates();
        GregorianCalendar gcal = new GregorianCalendar();
        Date dt = checkDates.string2Date(Regexp.filterDate(client.getBirthday()));
        gcal.setTime(dt);
        XMLGregorianCalendar xgcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);  // здесь д.б. ДР
        return xgcal;
    }

}
