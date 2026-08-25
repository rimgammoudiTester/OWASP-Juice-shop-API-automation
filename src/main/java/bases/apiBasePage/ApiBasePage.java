package bases.apiBasePage;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import owaspJuiceShop.configUtility.propertyReader.PropertyReader;
import owaspJuiceShop.enums.userFieldsType.UserFieldsType;
import owaspJuiceShop.genericUiKeywords.GenericUiKeyWords;
import owaspJuiceShop.owaspJuiceShopApi.authetificationApi.AuthetificationApiPage;
import owaspJuiceShop.owaspJuiceShopApi.registrationApiPage.RegistrationApiPage;
import owaspJuiceShop.pojoClasses.loginPojo.LoginPojo;
import owaspJuiceShop.pojoClasses.userRegisterPojo.UserRegisterPojo;
import owaspJuiceShop.utility.keyUtility.registrationHelper.RegistrationHelper;

import java.sql.SQLSyntaxErrorException;
import java.util.HashMap;

//import static bases.uiBase.UiBase.log;
import static owaspJuiceShop.configUtility.propertyReader.PropertyReader.*;
import static owaspJuiceShop.genericUiKeywords.GenericUiKeyWords.getCurrentLocalDate;
import static owaspJuiceShop.utility.constants.apiConstants.loginApiConstants.LoginApiConstants.LOGIN_EndPOINT;
import static owaspJuiceShop.utility.constants.apiConstants.registrationApiConstants.RegistrationApiConstants.REGISTRATION_ENDPOINT;
import static owaspJuiceShop.utility.constants.communConstants.CommunConstants.*;


public class ApiBasePage extends PropertyReader {
    /**
     * @Author Rim Gammoudi
     */


    //public  String token;
    AuthetificationApiPage loginApi;
    RegistrationApiPage registerUserPage;
    LoginPojo loginPojo;
     HashMap<String,Object>loginMap=new HashMap<>();
     HashMap<String,Object>registartionMap=new HashMap<>();
    RegistrationHelper registrationHelper;
    UserRegisterPojo userRegisterPojo;
    public static String savedEmail;
    public static String savedPassword;
    public static String token;


    public ApiBasePage()
     {


     }


     @BeforeClass
     public void intialization()
     {

         registrationHelper=new RegistrationHelper();
         savedEmail=registrationHelper.generateUserCredentnals(UserFieldsType.EMAIL);
         savedPassword=registrationHelper.generateUserCredentnals(UserFieldsType.PASSWORD);
         registartionMap.put("email",savedEmail);
         registartionMap.put("password",savedPassword);
         registartionMap.put("passwordRepeat",savedPassword);
        /* registartionMap.put("securityQuestion.question","Mother's birth date? (MM/DD/YY)");
         registartionMap.put("securityQuestion.id",3);
         registartionMap.put("securityQuestion.createdAt",getCurrentLocalDate());
         registartionMap.put("securityQuestion.updatedAt",getCurrentLocalDate());
         registartionMap.put("securityAnswer","13/07/1968");
         userRegisterPojo=new UserRegisterPojo(registartionMap);*/
         System.out.println("ccccc"+registartionMap);
         registerUserPage=new RegistrationApiPage();
         Response res = registerUserPage.createUser(registartionMap, getPropertyFromConfigFile(COMMUN_API) + getPropertyFromConfigFile(REGISTRATION_ENDPOINT));
        System.out.println("code status"+ res.getStatusCode());
         System.out.println("body"+ res.getBody().asPrettyString());


     }

    //Method useful to generate access Token
    //@BeforeClass()
    public String generateToken() {

  /* if(token!=null)
   {
     /*  return token;
   }
   else {

       loginMap.put("email", savedEmail);
       loginMap.put("password", savedPassword);


       loginPojo = new LoginPojo(loginMap);
       String loginUrl = getPropertyFromConfigFile(COMMUN_REST) + getPropertyFromConfigFile(LOGIN_EndPOINT);

       // FIX: Use raw RestAssured here instead of instantiating AuthetificationApiPage
       Response res = io.restassured.RestAssured.given()
               .contentType(io.restassured.http.ContentType.JSON)
               .body(loginPojo)
               .post(loginUrl);


      // loginApi = new AuthetificationApiPage();
      // Response res = loginApi.login(loginPojo, getPropertyFromConfigFile(COMMUN_REST) + getPropertyFromConfigFile(LOGIN_EndPOINT));
       System.out.print(res.body().prettyPrint());
       token = res.path("authentication.token");
       System.out.println("hello " + token);

       return token /*= res.body().prettyPrint();*/;

        if (token != null) {
            return token;
        } else {
            loginMap.put("email", savedEmail);
            loginMap.put("password", savedPassword);
            loginPojo = new LoginPojo(loginMap);

            String loginUrl = getPropertyFromConfigFile(COMMUN_REST) + getPropertyFromConfigFile(LOGIN_EndPOINT);
            System.out.println("Attempting to connect to login URL: " + loginUrl); // Add this line
            // FIX: Use raw RestAssured here instead of instantiating AuthetificationApiPage
            Response res = io.restassured.RestAssured.given().baseUri(getPropertyFromConfigFile(BASE_URI)).
                    contentType(io.restassured.http.ContentType.JSON)
                    .body(loginPojo)
                    .post(loginUrl);

            System.out.print(res.body().prettyPrint());
            token = res.path("authentication.token");
            System.out.println("hello " + token);

            return token;
   }
    }
    //Method useful to set up the headers for apis
    public HashMap<String, String> intializeTheHeaders() {
         String valueOfToken=generateToken();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " +valueOfToken);
        headers.put("Content-Type", "application/json");
        return headers;

    }

    @AfterClass
    public void killTheToken() {

        /*if (!token.isEmpty()) {
           // log.info("the token is killed ");
        }*/
    }


}
