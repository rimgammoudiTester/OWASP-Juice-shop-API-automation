package owaspJuiceShop.owaspJuiceShopApi.deliveryMethodApi;

import io.restassured.response.Response;
import owaspJuiceShop.genericApiKeywords.GenericApiKeyWords;

public class DeliveryMethodMangeApiPage extends GenericApiKeyWords {
    /**@Author
     * Rim Gammoudi
     */

    //Method usefull to get delivery methods

    public Response getDeliveryInformations(String deliveryEndpoint)
    {
       return   extractObject(deliveryEndpoint);

    }

    //Method usefull to get the get informations of delivery method selected

    public Response getDeliveryMethodsSelected(String idOfDeliveryMethod,int valueOfDeliveryMethod,String  deliveryEndpoint)
    {
        return  extractObjectByPathParameter(idOfDeliveryMethod,valueOfDeliveryMethod,deliveryEndpoint);

    }
}
