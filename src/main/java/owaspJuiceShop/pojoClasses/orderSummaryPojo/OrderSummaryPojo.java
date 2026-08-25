package owaspJuiceShop.pojoClasses.orderSummaryPojo;

import java.util.HashMap;

public class OrderSummaryPojo {

    //Properties of orderSummaryPojo

    private String couponData;
    private String addressId;
    private String deliveryMethodId;
    private String paymentId;

    public OrderSummaryPojo(HashMap<String, Object> mapOfUserRegistration) {

        this.couponData = mapOfUserRegistration.get("couponData").toString();
        this.addressId = mapOfUserRegistration.get("addressId").toString();
        this.deliveryMethodId = mapOfUserRegistration.get("deliveryMethodId").toString();
        this.paymentId = mapOfUserRegistration.get("paymentId").toString();
    }

    //getters of orderSummary pojo

    public String getCoupon() {
        return couponData;
    }

    public String getAddressId() {
        return addressId;
    }

    public String getDeliveryMethodId() {
        return deliveryMethodId;
    }

    public String getPaymentId() {
        return paymentId;
    }



    //setters of orderSummary pojo

    public void setCoupon(String couponData) {
        this.couponData = couponData;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public void setDeliveryMethodId(String deliveryMethodId) {
        this.deliveryMethodId = deliveryMethodId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }


}
