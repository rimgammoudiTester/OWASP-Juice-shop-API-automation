package owaspJuiceShop.pojoClasses.addNewCardPojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class AddNewCardPojo {
    /**
     * @Auhtor Rim Gammoudi
     */


    //Properties of add New CardPojo
   @JsonProperty("fullName")
    private String name;
    @JsonProperty("cardNum")
    private long cardNumber;
    @JsonProperty("expMonth")
    private String expiryMonth;
    @JsonProperty("expYear")
    private String expiryYear;


    public AddNewCardPojo(HashMap<String, Object> map) {
        this.name = map.get("fullName").toString();
        this.cardNumber = (long) map.get("cardNum");
        this.expiryMonth = map.get("expMonth").toString();
        this.expiryYear = map.get("expYear").toString();


    }


    // Getters for add new card Pojo
    public long getCardNumber() {
        return this.cardNumber;
    }

    public String getName() {
        return this.name;
    }

    public String getExpiryMonth() {
        return this.expiryMonth;
    }

    public String getExpiryYear() {
        return this.expiryYear;
    }


    // Setters for add new card Pojo
    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTheExpiryMonth(String expiryMonth) {
        this.expiryMonth = expiryMonth;
    }

    public void setTheExpiryYear(String expiryYear) {
        this.expiryYear = expiryYear;
    }


}

