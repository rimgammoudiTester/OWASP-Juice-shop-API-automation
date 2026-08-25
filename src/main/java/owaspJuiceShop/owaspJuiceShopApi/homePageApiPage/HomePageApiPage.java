package owaspJuiceShop.owaspJuiceShopApi.homePageApiPage;

import io.restassured.response.Response;
import owaspJuiceShop.genericApiKeywords.GenericApiKeyWords;

import java.util.HashMap;

public class HomePageApiPage extends GenericApiKeyWords {


    //Method usefull to create a basket
    public Response createBasket(HashMap<String,Object> productPayload, String addToBasketEndpoint)
    {

        return createObject(productPayload,addToBasketEndpoint);
    }
}
