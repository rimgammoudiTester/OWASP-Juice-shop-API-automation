package owaspJuiceShop.owaspJuiceShopApi.basketApiPage;

import io.restassured.response.Response;
import owaspJuiceShop.genericApiKeywords.GenericApiKeyWords;

import java.util.HashMap;

public class BasketApiPage  extends GenericApiKeyWords {

    //Method usefull to  get basket informations
    public Response getBasketInformationsById(String id, int idValue, String basketIdEndpoint)
    {

       return extractObjectByPathParameter(id,idValue,basketIdEndpoint);
    }
    //Method usefull to  get user email
    public Response getUserEmail(HashMap<String,Object>mapOfUser, String loginEndpoint)
    {

      return  extractObjectByQueryParam(mapOfUser,loginEndpoint);
    }

    //Method usefull to  get user email
    public Response deleteBasket(String basketId,int basketIdValue, String basketEndpoint)
    {

      return  deleteObjectByPathParameter(basketId,basketIdValue,basketEndpoint);
    }

    //Method usefull to add quantity
    public Response addQuantityBasket(HashMap<String,Object>pathParamMap,HashMap<String,Object>queryParam, String basketEndpoint) {

        return updateOrCreateObjectWithPathParamAndQueryParam(pathParamMap,queryParam,basketEndpoint);
    }

}
