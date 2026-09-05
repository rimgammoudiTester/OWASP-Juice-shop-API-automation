package owaspJuiceShop.owaspJuiceShopApi.cardApiPage;

import io.restassured.response.Response;
import owaspJuiceShop.genericApiKeywords.GenericApiKeyWords;
import owaspJuiceShop.pojoClasses.addNewCardPojo.AddNewCardPojo;

import java.util.HashMap;

public class CardApiPage extends GenericApiKeyWords {

    //Method useful to extract card informations

    public Response extractTheCardInformation(String extractCardInformationsEndpoint) {
        return extractObject(extractCardInformationsEndpoint);

    }


    //Method useful to create card Number

    public Response createCard(AddNewCardPojo cardPayload, String addCardEndpoint) {

        return createObject(cardPayload, addCardEndpoint);
    }


}
