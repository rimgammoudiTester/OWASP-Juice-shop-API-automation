package owaspJuiceShop.utility.constants.apiConstants.addCardConstants;

public class AddCardConstants {
    /**@Author
     * Rim Gammoudi
     */


    public static final String ADD_CARD_ENDPOINT="addCardEndpoint";

    /**add new car response's keys **/
    public static final String CARD_NUM_KEY="cardNum";
    public static final String EXP_MONTH_KEY="expMonth";
    public static final String EXP_YEAR_KEY="expYear";
    public static final String FULL_NAME_KEY="fullName";
    /** Name of Object **/
    public static final String OBJECT_DATA="data.";






    /** add new Card wrong data
     *
     */
    // Wrong card Number values
    public static final int MIN_NUM_CARD_VALUE=12;
    public static final long  MAX_NUM_CARD_VALUE =1230456789104235489L;

    // Wrong expiry Month values
    public static final String MIN_EXPIRY_MONTH_VALUE="0";
    public static final String MAX_EXPIRY_MONTH_VALUE="13";

    // Wrong expiry Year values
    public static final String MIN_EXPIRY_YEAR_VALUE="0";
    public static final String MAX_EXPIRY_YEAR_VALUE="5600";




    /** add new card response's error message **/

    /**Card num error message **/
    public static final String MIN_NUM_CARD_ERROR_MESSAGE="Validation error: Validation min on cardNum failed";
    public static final String MAX_NUM_CARD_ERROR_MESSAGE="Validation error: Validation max on cardNum failed";

    /** Expiry year error message **/
    public static final String MIN_EXPIRY_YEAR_ERROR_MESSAGE="Validation error: Validation min on expYear failed";
    public static final String MAX_EXPIRY_YEAR_ERROR_MESSAGE="Validation error: Validation max on expYear failed";

    /** Expiry month error message **/
    public static final String MIN_EXPIRY_MONTH_ERROR_MESSAGE="Validation error: Validation min on expMonth failed";
    public static final String MAX_EXPIRY_MONTH_ERROR_MESSAGE="Validation error: Validation max on expMonth failed";


}
