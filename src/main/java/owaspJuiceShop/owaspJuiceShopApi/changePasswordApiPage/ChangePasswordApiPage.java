package owaspJuiceShop.owaspJuiceShopApi.changePasswordApiPage;

import io.restassured.response.Response;
import owaspJuiceShop.genericApiKeywords.GenericApiKeyWords;

import java.util.HashMap;

public class ChangePasswordApiPage extends GenericApiKeyWords {

    //Method useful to change the password
    public Response setUserPassword(HashMap<String,Object> payload, String extractRequestEraserEndpoint)
    {

        return extractObjectByQueryParam(payload,extractRequestEraserEndpoint);
    }



}
