package apiTests.cardApiTests;

import io.restassured.response.Response;
import org.assertj.core.api.Assertions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import owaspJuiceShop.enums.addCardNumberFields.wrongCardNumberFields;
import owaspJuiceShop.owaspJuiceShopApi.cardApiPage.CardApiPage;
import owaspJuiceShop.pojoClasses.addNewCardPojo.AddNewCardPojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static owaspJuiceShop.configUtility.jsonReader.JsonReader.log;
import static owaspJuiceShop.configUtility.jsonReader.JsonReader.readJson;
import static owaspJuiceShop.enums.addCardNumberFields.wrongCardNumberFields.*;
import static owaspJuiceShop.utility.constants.apiConstants.addCardConstants.AddCardConstants.*;
import static owaspJuiceShop.utility.constants.apiConstants.apiStatusConstants.StatusCodeConstants.*;
import static owaspJuiceShop.utility.constants.communConstants.CommunConstants.*;

public class CardApiTests extends CardApiPage {

    /**
     * @Author Rim Gamoudi
     */


    HashMap<String, Object> addCardDataMap = new HashMap<>();
    String addCardJsonPath = "C:\\Users\\HP\\Desktop\\AutomationFrameworkSelenium\\Owasp-juice.shop\\owasp-juice.shop\\src\\main\\java\\jsonFiles\\addCardJson\\AddCardJson.json";
    AddNewCardPojo addNewCardPojo;

    @DataProvider
    public static Object[][] getWrongCardNum() {
        return new Object[][]{

                {MAX_CARD_NUMBER},
                {MIN_CARD_NUMBER}


        };
    }

    @DataProvider
    public static Object[][] getWrongExpMonth() {
        return new Object[][]{
                {MIN_EXP_MONTH},
                {MAX_EXP_MONTH}

        };
    }

    @DataProvider
    public static Object[][] getWrongExpYear() {
        return new Object[][]{

                {MIN_EXP_YEAR},
                {MAX_EXP_YEAR}

        };
    }


    @BeforeClass
    public void initialization() {
        addCardDataMap = readJson(addCardJsonPath);
        addNewCardPojo = new AddNewCardPojo(addCardDataMap);

    }


    //Method usefully to add card with correct values
    @Test(description = "Test for performing add card with correct data", groups = {"regression"})
    public void addCardNumberWithCorrectData() {
        Response res;
        Long cardNum;
        int expMonth;
        int expYear;
        String fullName;
        log.info("test for adding a card number");
        res = createCard(addNewCardPojo, getPropertyFromConfigFile(COMMUN_API) + getPropertyFromConfigFile(ADD_CARD_ENDPOINT));
        Assertions.assertThat(res.getStatusCode()).isEqualTo(SUCCESS_CREATION);
        log.info(res.getBody().prettyPrint());
        /** Assertions
         Assertions.assertThat(res.getStof response's keys **/
        cardNum = res.path(OBJECT_DATA + CARD_NUM_KEY);
        expMonth = res.path(OBJECT_DATA + EXP_MONTH_KEY);
        expYear = res.path(OBJECT_DATA + EXP_YEAR_KEY);
        fullName = res.path(OBJECT_DATA + FULL_NAME_KEY);
        Assertions.assertThat(cardNum).isEqualTo(addNewCardPojo.getCardNumber());
        Assertions.assertThat(expMonth).isEqualTo(Integer.parseInt(addNewCardPojo.getExpiryMonth()));
        Assertions.assertThat(expYear).isEqualTo(Integer.parseInt(addNewCardPojo.getExpiryYear()));
        Assertions.assertThat(fullName).isEqualTo(addNewCardPojo.getName());


    }


    //Method usefully to add card with incorrect card Numbers
    @Test(description = "Test for performing add Card with invalid card numbers", dataProvider = "getWrongCardNum")
    public void addCardNumberWithInCorrectCardNumber(wrongCardNumberFields wrongValue) {
        Response res;
        String maxNumCardErrorMessage;
        String minNumCardErrorMessage;
        if (wrongValue.equals(MAX_CARD_NUMBER)) {
            addNewCardPojo.setCardNumber(MAX_NUM_CARD_VALUE);
            res = createCard(addNewCardPojo, getPropertyFromConfigFile(COMMUN_API) + getPropertyFromConfigFile(ADD_CARD_ENDPOINT));
            maxNumCardErrorMessage = res.path(MESSAGE_KEY);
            log.info(res.getBody().prettyPrint());
            Assertions.assertThat(res.getStatusCode()).isEqualTo(BAD_REQUEST_CODE);
            Assertions.assertThat(maxNumCardErrorMessage).isEqualTo(MAX_NUM_CARD_ERROR_MESSAGE);
            log.info("The api  is successfully returning the error message when we provide a card Num length greater than the accepted one   :   " + MAX_NUM_CARD_ERROR_MESSAGE);
            addNewCardPojo.setCardNumber((Long) addCardDataMap.get("cardNum"));


        } else if (wrongValue.equals(MIN_CARD_NUMBER)) {
            addNewCardPojo.setCardNumber(MIN_NUM_CARD_VALUE);
            res = createCard(addNewCardPojo, getPropertyFromConfigFile(COMMUN_API) + getPropertyFromConfigFile(ADD_CARD_ENDPOINT));
            minNumCardErrorMessage = res.path(MESSAGE_KEY);
            Assertions.assertThat(res.getStatusCode()).isEqualTo(BAD_REQUEST_CODE);
            Assertions.assertThat(minNumCardErrorMessage).isEqualTo(MIN_NUM_CARD_ERROR_MESSAGE);
            log.info("The api  is successfully returning the error message when we provide a card Num length less than the accepted one   :   " + MIN_NUM_CARD_ERROR_MESSAGE);
            addNewCardPojo.setCardNumber((Long) addCardDataMap.get("cardNum"));

        } else {
            log.warn("check the field you're given it doesn't correspond to cardNumber");
            throw new IllegalArgumentException("the field given doesn't correspond to cardNumber");
        }


    }


    //Method usefully to add card with incorrect expiry year values
    @Test(description = "Test for performing add Card with invalid expiry year values", dataProvider = "getWrongExpYear")
    public void addCardNumberWithInCorrectExpiryYear(wrongCardNumberFields wrongExpiryYearField) {

        Response res;
        String maxExpiryYearErrorMessage;
        String minExpiryYearErrorMessage;
        if (wrongExpiryYearField.equals(MAX_EXP_YEAR)) {
            addNewCardPojo.setTheExpiryYear(MAX_EXPIRY_YEAR_VALUE);
            res = createCard(addNewCardPojo, getPropertyFromConfigFile(COMMUN_API) + getPropertyFromConfigFile(ADD_CARD_ENDPOINT));
            maxExpiryYearErrorMessage = res.path(MESSAGE_KEY);
            Assertions.assertThat(res.getStatusCode()).isEqualTo(BAD_REQUEST_CODE);
            Assertions.assertThat(maxExpiryYearErrorMessage).isEqualTo(MAX_EXPIRY_YEAR_ERROR_MESSAGE);
            log.info("The api  is successfully returning the error message when we provide an expiry year  length greater than the accepted one   :   " + MAX_EXPIRY_YEAR_ERROR_MESSAGE);
            addNewCardPojo.setTheExpiryYear(addCardDataMap.get("expYear").toString());


        } else if (wrongExpiryYearField.equals(MIN_EXP_YEAR)) {
            addNewCardPojo.setTheExpiryYear(MIN_EXPIRY_YEAR_VALUE);
            res = createCard(addNewCardPojo, getPropertyFromConfigFile(COMMUN_API) + getPropertyFromConfigFile(ADD_CARD_ENDPOINT));
            minExpiryYearErrorMessage = res.path(MESSAGE_KEY);
            Assertions.assertThat(res.getStatusCode()).isEqualTo(BAD_REQUEST_CODE);
            log.info(res.getBody().prettyPrint());
            Assertions.assertThat(minExpiryYearErrorMessage).isEqualTo(MIN_EXPIRY_YEAR_ERROR_MESSAGE);
            log.info("The api  is successfully returning the error message when we provide an expiry year  length less than the accepted one   :   " + MIN_EXPIRY_YEAR_ERROR_MESSAGE);
            addNewCardPojo.setTheExpiryYear(addCardDataMap.get("expYear").toString());


        } else {
            log.warn("check the field you're given it doesn't correspond to expiry year ");
            throw new IllegalArgumentException("the field given doesn't correspond to expiry year");
        }

    }

    //Method usefully to add card with incorrect expiry month values
    @Test(description = "Test for performing add Card with invalid expiry month values", dataProvider = "getWrongExpMonth")
    public void addCardNumberWithInCorrectExpiryMonth(wrongCardNumberFields wrongExpiryMonthField) {
        Response res;
        String maxExpiryMonthErrorMessage;
        String minExpiryMonthErrorMessage;
        if (wrongExpiryMonthField.equals(MAX_EXP_MONTH)) {
            addNewCardPojo.setTheExpiryMonth(MAX_EXPIRY_MONTH_VALUE);
            res = createCard(addNewCardPojo, getPropertyFromConfigFile(COMMUN_API) + getPropertyFromConfigFile(ADD_CARD_ENDPOINT));
            maxExpiryMonthErrorMessage = res.path(MESSAGE_KEY);
            Assertions.assertThat(res.getStatusCode()).isEqualTo(BAD_REQUEST_CODE);
            Assertions.assertThat(maxExpiryMonthErrorMessage).isEqualTo(MAX_EXPIRY_MONTH_ERROR_MESSAGE);
            log.info("The api  is successfully returning the error message when we provide an expiry month length greater than the accepted one   :   " + MAX_EXPIRY_MONTH_ERROR_MESSAGE);
            addNewCardPojo.setTheExpiryMonth(addCardDataMap.get("expMonth").toString());


        } else if (wrongExpiryMonthField.equals(MIN_EXP_MONTH)) {
            addNewCardPojo.setTheExpiryMonth(MIN_EXPIRY_MONTH_VALUE);
            res = createCard(addNewCardPojo, getPropertyFromConfigFile(COMMUN_API) + getPropertyFromConfigFile(ADD_CARD_ENDPOINT));
            minExpiryMonthErrorMessage = res.path(MESSAGE_KEY);
            Assertions.assertThat(res.getStatusCode()).isEqualTo(BAD_REQUEST_CODE);
            Assertions.assertThat(minExpiryMonthErrorMessage).isEqualTo(MIN_EXPIRY_MONTH_ERROR_MESSAGE);
            log.info("The api  is successfully returning the error message when we provide an expiry month length less than the accepted one   :   " + MIN_EXPIRY_MONTH_ERROR_MESSAGE);
            addNewCardPojo.setTheExpiryMonth(addCardDataMap.get("expMonth").toString());


        } else {
            log.warn("check the field you're given it doesn't correspond to expiry month ");
            throw new IllegalArgumentException("the field given doesn't correspond to expiry month");
        }


    }

    //Method usefully to extract card information
    @Test(description = "Test for extracting the information's of card")
    public void extractCardInformation() {
        String cardJsonBody;
        int cardDataLength;
        Response res;
        String statusKey;
        List<HashMap<String, Object>> listOfCards;
        String cardNum;
        int expMonth;
        int expYear;
        String fullName;

        log.info("test for extracting the card Information's");
        res = extractTheCardInformation(getPropertyFromConfigFile(COMMUN_API) + getPropertyFromConfigFile(ADD_CARD_ENDPOINT));
        cardJsonBody = res.body().asPrettyString();
        Assertions.assertThat(res.getStatusCode()).isEqualTo(SUCCESS_CODE);
        log.info("the card api is successfully passing with " + SUCCESS_CODE);
        log.info("the response body of card api is :  " + cardJsonBody);

        if (cardJsonBody.isEmpty()) {
            log.info("the response body is already empty no card exist:  ");

        } else {
            // cardData = res.path("data");
            listOfCards = res.jsonPath().getList("data");
            cardDataLength = listOfCards.size();
            log.info("the response body length is :  " + cardDataLength);
            System.out.println("the value is " + cardDataLength);
            statusKey = res.path(STATUS_KEY);
            Assertions.assertThat(statusKey).isEqualTo(VALUE_STATUS_KEY);
            for (HashMap<String, Object> cardItem : listOfCards) {
                System.out.println(cardItem);
                cardNum = cardItem.get(CARD_NUM_KEY).toString();
                expMonth = (Integer) cardItem.get(EXP_MONTH_KEY);
                expYear = (Integer) cardItem.get(EXP_YEAR_KEY);
                fullName = cardItem.get(FULL_NAME_KEY).toString();
                Assertions.assertThat(cardNum).isNotNull();
                Assertions.assertThat(expMonth).isNotNull();
                Assertions.assertThat(expYear).isNotNull();
                Assertions.assertThat(fullName).isNotNull();
            }


        }


    }


}
