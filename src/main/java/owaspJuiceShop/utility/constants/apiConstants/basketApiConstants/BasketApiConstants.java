package owaspJuiceShop.utility.constants.apiConstants.basketApiConstants;

public class BasketApiConstants {

    //Params constants
    public static String QUANTITY = "quantity";
    public static String PATH_PARAMETER_ID = "id";

    // Values of basketApi parameters

    public static int ID_VALUE = 6;
    public static int WRONG_ID_VALUE = 0;

    public static int ID_VALUE_TO_DELETE = 6;

    // Error messages of BasketItems
    public static String NOT_FOUND_MESSAGE = "Not Found";
    public static String BYPASS_ERROR_MESSAGE="You can order only up to 5 items of this product.";

    //Basket Endpoint
    public static String BASKET_ENDPOINT = "basketEndpoint";

    //Basket json path
    public static String BASKET_JSON_PATH ="C:\\Users\\HP\\Desktop\\AutomationFrameworkSelenium\\Owasp-juice.shop\\owasp-juice.shop\\src\\main\\java\\jsonFiles\\basket\\basket.json";

    //Basket Keys for response body
    public static String BASKET_MESSAGE_KEY = "message";
    public static String BASKET_STATUS_KEY = "status";
    public static String BASKET_ERROR_KEY = "error";
    public static String BASKET_QUANTITY_KEY= "data.quantity";



    //Basket keys values from body's response
    public static String BASKET_STATUS_VALUE = "success";






}
