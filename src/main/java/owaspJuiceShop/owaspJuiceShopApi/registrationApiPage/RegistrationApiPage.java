package owaspJuiceShop.owaspJuiceShopApi.registrationApiPage;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import owaspJuiceShop.genericApiKeywords.GenericApiKeyWords;
import owaspJuiceShop.pojoClasses.userRegisterPojo.UserRegisterPojo;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static owaspJuiceShop.configUtility.propertyReader.PropertyReader.getPropertyFromConfigFile;
import static owaspJuiceShop.utility.constants.communConstants.CommunConstants.BASE_URI;

public class RegistrationApiPage  {

    //Method usefull to extract the registration informations

    //Method useful to intializeHeaders for page registartion user
    public RequestSpecification req=given();

    public RequestSpecification setTheHeadrs()
    {
        return req=req.baseUri(getPropertyFromConfigFile(BASE_URI));

    }

    public Response extractTheRegistrationInformations(String registrationInformationsEndpoint) {
        return setTheHeadrs().get(registrationInformationsEndpoint).then().extract().response();

    }

    //Method usefull to create user

    public Response createUser(HashMap<String,Object> userRegisterPojo, String registrationEndpoint) //Method usefull to extract the recycle

    {
        return setTheHeadrs().contentType(ContentType.JSON).body(userRegisterPojo).post(registrationEndpoint).then().extract().response();

    }


}
