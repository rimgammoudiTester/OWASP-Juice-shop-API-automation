package owaspJuiceShop.owaspJuiceShopApi.authetificationApi;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import owaspJuiceShop.genericApiKeywords.GenericApiKeyWords;
import owaspJuiceShop.pojoClasses.loginPojo.LoginPojo;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static owaspJuiceShop.configUtility.propertyReader.PropertyReader.getPropertyFromConfigFile;
import static owaspJuiceShop.utility.constants.communConstants.CommunConstants.BASE_URI;

public class AuthetificationApiPage extends GenericApiKeyWords {
    /**@Author Rim Gammoudi
     *
     * **/

    //Method useful to perform login
  public Response login(LoginPojo payload, String loginEndpoint)
  {
      return createObject(payload,loginEndpoint);

  }

}
