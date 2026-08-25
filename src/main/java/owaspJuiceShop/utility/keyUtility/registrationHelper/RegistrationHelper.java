package owaspJuiceShop.utility.keyUtility.registrationHelper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import owaspJuiceShop.enums.userFieldsType.UserFieldsType;
import owaspJuiceShop.owaspJuiceShopApi.authetificationApi.AuthetificationApiPage;

import java.util.HashMap;
import java.util.UUID;

import static owaspJuiceShop.enums.userFieldsType.UserFieldsType.EMAIL;
import static owaspJuiceShop.enums.userFieldsType.UserFieldsType.PASSWORD;

public class RegistrationHelper  {
    private static final Log log = LogFactory.getLog(RegistrationHelper.class);

    /**@Author
     * Rim Gammoudi
     */


    //Method useful for performing the registartion needed for each test's execution

    public String generateUserCredentnals(UserFieldsType authentificationField)
    {
        String authentificationFieldToReturn = "";
       if(authentificationField.equals(EMAIL))
       {

           authentificationFieldToReturn="email"+ UUID.randomUUID().toString().substring(0,5)+"@gmail.com";}
       else if(authentificationField.equals(PASSWORD))
       {
           authentificationFieldToReturn= "password"+UUID.randomUUID().toString().substring(0,4);
       }

       else
       {
           log.error("the field name you're given is wrong");
           throw new RuntimeException("The authentifaction field you're currently sending is completly wrong");
       }
       System.out.println(authentificationFieldToReturn);
       return authentificationFieldToReturn;
    }
}
