package bases.apiBasePage;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import owaspJuiceShop.configUtility.propertyReader.PropertyReader;
import owaspJuiceShop.enums.userFieldsType.UserFieldsType;
import owaspJuiceShop.owaspJuiceShopApi.registrationApiPage.RegistrationApiPage;
import owaspJuiceShop.pojoClasses.loginPojo.LoginPojo;
import owaspJuiceShop.pojoClasses.userRegisterPojo.UserRegisterPojo;
import owaspJuiceShop.utility.keyUtility.registrationHelper.RegistrationHelper;

import java.util.HashMap;

import static owaspJuiceShop.genericUiKeywords.GenericUiKeyWords.getCurrentLocalDate;
import static owaspJuiceShop.utility.constants.apiConstants.loginApiConstants.LoginApiConstants.LOGIN_EndPOINT;
import static owaspJuiceShop.utility.constants.apiConstants.registrationApiConstants.RegistrationApiConstants.REGISTRATION_ENDPOINT;
import static owaspJuiceShop.utility.constants.communConstants.CommunConstants.*;


public class ApiBasePage extends PropertyReader {
    /**
     * @Author Rim Gammoudi
     */

    private RegistrationApiPage registerUserPage;
    private LoginPojo loginPojo;
    //private HashMap<String, Object> loginMap = new HashMap<>();
    private HashMap<String, Object> registrationMap = new HashMap<>();
    private RegistrationHelper registrationHelper;
    UserRegisterPojo userRegisterPojo;
    private  static ThreadLocal<String>savedEmail=new ThreadLocal<>();
    private static ThreadLocal<String>savedPassword=new ThreadLocal<>();
    private static ThreadLocal<String>token=new ThreadLocal<>();


    public ApiBasePage() {


    }

    //Getters and setters used for apiBasePage

    // getter for email
    public static  String getTheEmail()
    {
        return savedEmail.get();
    }

    // getter for password
    public static String getThePassword()
    {
        return savedPassword.get();
    }
    // getter for token
    public  static String getTheToken()
    {
        return token.get();
    }

    // setter for email
    public static void setTheEmail(String emailValue)
    {
        savedEmail.set(emailValue);
    }
    // setter for password
    public  static void setThePassword(String PasswordValue)
    {
        savedPassword.set(PasswordValue);
    }
    // setter for token
    public  static void setTheToken(String tokenValue)
    {

        token.set(tokenValue);
    }


    /*@BeforeMethod
    public void initialization() {
        System.out.println("--> @BeforeMethod Thread ID: " + Thread.currentThread().getId());

        registrationHelper = new RegistrationHelper();
        String email = registrationHelper.generateUserCredentnals(UserFieldsType.EMAIL);
        String password = registrationHelper.generateUserCredentnals(UserFieldsType.PASSWORD);
        System.out.println("the email is : "+email);
        System.out.println("the password is : "+password);

        setTheEmail(email);
        setThePassword(password);
        System.out.println("hellomail"+getTheEmail());
        System.out.println("helloPassword"+getThePassword());
        registrationMap.put("email",getTheEmail());
        registrationMap.put("password",getThePassword());
        registrationMap.put("passwordRepeat",getThePassword());
         registrationMap.put("securityQuestion.question","Mother's birth date? (MM/DD/YY)");
         registrationMap.put("securityQuestion.id",3);
         registrationMap.put("securityQuestion.createdAt",getCurrentLocalDate());
         registrationMap.put("securityQuestion.updatedAt",getCurrentLocalDate());
         registrationMap.put("securityAnswer","13/07/1968");
         userRegisterPojo=new UserRegisterPojo(registrationMap);
        registerUserPage = new RegistrationApiPage();
        Response res = registerUserPage.createUser(registrationMap, getPropertyFromConfigFile(COMMUN_API) + getPropertyFromConfigFile(REGISTRATION_ENDPOINT));
        System.out.println("code status" + res.getStatusCode());
        System.out.println("body" + res.getBody().asPrettyString());


    }*/

    //Method useful to generate access Token
    public String generateToken() {
       /* System.out.println("--> generateToken Thread ID: " + Thread.currentThread().getId());
        System.out.println("Email from ThreadLocal: " + getTheEmail());*/
         String tokenValue;
        HashMap<String, Object> loginMap = new HashMap<>();

        loginMap.put("email",/*getTheEmail()*/getPropertyFromConfigFile(EMAIL));
        loginMap.put("password",/*getThePassword()*/getPropertyFromConfigFile(PASSWORD));
        System.out.println("cc"+loginMap);
        loginPojo = new LoginPojo(loginMap);
        String loginUrl = getPropertyFromConfigFile(COMMUN_REST) + getPropertyFromConfigFile(LOGIN_EndPOINT);
        // FIX: Use raw RestAssured here instead of instantiating AuthetificationApiPage
        Response res = io.restassured.RestAssured.given().baseUri(getPropertyFromConfigFile(BASE_URI)).
                contentType(io.restassured.http.ContentType.JSON)
                .body(loginPojo)
                .post(loginUrl);
        System.out.println("hello hello"+res.body().prettyPrint());
        tokenValue = res.path("authentication.token");
        setTheToken(tokenValue);
        return getTheToken();

    }

    //Method useful to set up the headers for apis
    public HashMap<String, String> intializeTheHeaders() {
        String valueOfToken = generateToken();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + valueOfToken);
        headers.put("Content-Type", "application/json");
        headers.put("accept", "application/json, text/plain, */*");
        return headers;

    }

    @AfterClass
    public void killTheToken() {

       /* if (!token.isEmpty()) {
            log.info("the token is killed ");
        }*/
    }
}



