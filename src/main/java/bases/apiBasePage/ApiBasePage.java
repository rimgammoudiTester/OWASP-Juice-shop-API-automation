package bases.apiBasePage;
import io.restassured.response.Response;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import owaspJuiceShop.configUtility.propertyReader.PropertyReader;
import owaspJuiceShop.enums.userFieldsType.UserFieldsType;
import owaspJuiceShop.owaspJuiceShopApi.registrationApiPage.RegistrationApiPage;
import owaspJuiceShop.pojoClasses.loginPojo.LoginPojo;
import owaspJuiceShop.pojoClasses.userRegisterPojo.UserRegisterPojo;
import owaspJuiceShop.utility.keyUtility.registrationHelper.RegistrationHelper;

import java.util.HashMap;

import static owaspJuiceShop.utility.constants.apiConstants.loginApiConstants.LoginApiConstants.LOGIN_EndPOINT;
import static owaspJuiceShop.utility.constants.apiConstants.registrationApiConstants.RegistrationApiConstants.REGISTRATION_ENDPOINT;
import static owaspJuiceShop.utility.constants.communConstants.CommunConstants.*;


public class ApiBasePage extends PropertyReader {
    /**
     * @Author Rim Gammoudi
     */

    RegistrationApiPage registerUserPage;
    LoginPojo loginPojo;
    HashMap<String, Object> loginMap = new HashMap<>();
    HashMap<String, Object> registrationMap = new HashMap<>();
    RegistrationHelper registrationHelper;
    UserRegisterPojo userRegisterPojo;
    public static String savedEmail;
    public static String savedPassword;
    public static String token;


    public ApiBasePage() {


    }


    @BeforeMethod
    public void initialization() {

        registrationHelper = new RegistrationHelper();
        savedEmail = registrationHelper.generateUserCredentnals(UserFieldsType.EMAIL);
        savedPassword = registrationHelper.generateUserCredentnals(UserFieldsType.PASSWORD);
        registrationMap.put("email", savedEmail);
        registrationMap.put("password", savedPassword);
        registrationMap.put("passwordRepeat", savedPassword);
        /* registartionMap.put("securityQuestion.question","Mother's birth date? (MM/DD/YY)");
         registartionMap.put("securityQuestion.id",3);
         registartionMap.put("securityQuestion.createdAt",getCurrentLocalDate());
         registartionMap.put("securityQuestion.updatedAt",getCurrentLocalDate());
         registartionMap.put("securityAnswer","13/07/1968");
         userRegisterPojo=new UserRegisterPojo(registartionMap);*/
        registerUserPage = new RegistrationApiPage();
        Response res = registerUserPage.createUser(registrationMap, getPropertyFromConfigFile(COMMUN_API) + getPropertyFromConfigFile(REGISTRATION_ENDPOINT));
        System.out.println("code status" + res.getStatusCode());
        System.out.println("body" + res.getBody().asPrettyString());


    }

    //Method useful to generate access Token
    public String generateToken() {

        loginMap.put("email", savedEmail);
        loginMap.put("password", savedPassword);
        loginPojo = new LoginPojo(loginMap);

        String loginUrl = getPropertyFromConfigFile(COMMUN_REST) + getPropertyFromConfigFile(LOGIN_EndPOINT);
        // FIX: Use raw RestAssured here instead of instantiating AuthetificationApiPage
        Response res = io.restassured.RestAssured.given().baseUri(getPropertyFromConfigFile(BASE_URI)).
                contentType(io.restassured.http.ContentType.JSON)
                .body(loginPojo)
                .post(loginUrl);

        token = res.path("authentication.token");
        return token;

    }

    //Method useful to set up the headers for apis
    public HashMap<String, String> intializeTheHeaders() {
        String valueOfToken = generateToken();
        HashMap<String, String> headers = new HashMap<>();
        headers.put("Authorization", "Bearer " + valueOfToken);
        headers.put("Content-Type", "application/json");
        return headers;

    }

    @AfterClass
    public void killTheToken() {

       /* if (!token.isEmpty()) {
            log.info("the token is killed ");
        }*/
    }
}



