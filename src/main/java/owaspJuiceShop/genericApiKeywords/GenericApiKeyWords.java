package owaspJuiceShop.genericApiKeywords;
import bases.apiBasePage.ApiBasePage;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.given;
import static owaspJuiceShop.configUtility.propertyReader.PropertyReader.getPropertyFromConfigFile;
import static owaspJuiceShop.utility.constants.apiConstants.basketApiConstants.BasketApiConstants.PATH_PARAMETER_ID;
import static owaspJuiceShop.utility.constants.communConstants.CommunConstants.BASE_URI;
import static owaspJuiceShop.utility.keyUtility.basketQuantityKeyUtility.BasketKeyUtility.ID;
import static owaspJuiceShop.utility.keyUtility.basketQuantityKeyUtility.BasketKeyUtility.ID_PATH_PARAMETER;

public class GenericApiKeyWords extends ApiBasePage {
    /**
     * @Author Rim Gammoudi
     *
     */
    RequestSpecification req = given();
    HashMap<String, String> headers = new HashMap<>();


    public RequestSpecification setupHeaders() {

        //return req=req.baseUri(getPropertyFromConfigFile(BASE_URI)).contentType(ContentType.JSON);
        //System.out.println(intializeTheHeaders());
       return req = req.baseUri(getPropertyFromConfigFile(BASE_URI)).headers(intializeTheHeaders());
    }

    //Method useful to extract object by query param given
    public Response extractObjectByQueryParam(Map<String, Object> queryParamToSend, String endPoint) {

        return setupHeaders().queryParams(queryParamToSend).contentType(ContentType.JSON).get(endPoint).then().extract().response();

    }

    //Method useful to extract object by path parameter
    public Response extractObjectByPathParameter(String pathParameterName, Object pathParameter, String endPoint) {

        return setupHeaders().pathParam(pathParameterName, pathParameter).contentType(ContentType.JSON).get(endPoint).then().extract().response();

    }

    //Method useful to extract object list
    public Response extractObject(String endPoint) {

        return setupHeaders().contentType(ContentType.JSON).get(endPoint).then().extract().response();

    }

    //Method useful to create object
    public Response createObject(Object payload, String endPoint) {

        return setupHeaders().body(payload).contentType(ContentType.JSON).post(endPoint).then().extract().response();

    }

    //Method useful to delete  object By path parameter
    public Response deleteObjectByPathParameter(String pathParameterName, Object pathParameter, String endPoint) {

        return setupHeaders().pathParam(pathParameterName, pathParameter).contentType(ContentType.JSON).delete(endPoint).then().extract().response();

    }

    //Method useful to update object By path parameter
    public Response updateObjectByPathParameter(String pathParameterName, int pathParameter, String endPoint) {

        return setupHeaders().pathParam(pathParameterName, pathParameter).contentType(ContentType.JSON).delete(endPoint).then().extract().response();

    }


    //Method useful to update object  or create itBy path parameter
    public Response updateOrCreateObject(HashMap<String,Object> map, String endPoint) {

        return setupHeaders().queryParams(map).contentType(ContentType.JSON).put(endPoint).then().extract().response();

    }


    //Method useful to update object  or create itBy path parameter and a given queryparam
    public Response updateOrCreateObjectWithPathParamAndQueryParam(HashMap<String,Object>mapOfPathParameter,HashMap<String,Object> map, String endPoint) {

        return setupHeaders().pathParams(mapOfPathParameter).body(map).contentType(ContentType.JSON).put(endPoint).then().extract().response();

    }
}
