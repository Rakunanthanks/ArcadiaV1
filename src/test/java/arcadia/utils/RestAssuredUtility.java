package arcadia.utils;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import java.util.Map;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.Json;

public class RestAssuredUtility {

    private static Response response;
    public String getComponentDbResponse(String component, WebDriver driver)
    {
        String BASE_URL=ConfigLoader.getInstance().getBaseUrl() + System.getProperty("testInstance")+"/index.lp";
        String database = System.getProperty("componentDB");
        String url="?app=componentsv2&database="+database+"&form="+component+"&ajax=true&hidden=true&command=ajaxgrid&company=CADONIX&order=asc&offset=0&limit=0";
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        String cookie=getCookie(driver);
        request.header("authority","qa.cadonix.online");
        request.header("accept","application/json");
        request.header("content-type","application/json");
        request.header("cookie", "ArchonixAuth="+cookie+"");
        response = request.get(url);
        String jsonString = response.asString();
        return jsonString;
    }
    public String getEditorResponse(WebDriver driver,String url){
        String BASE_URL=ConfigLoader.getInstance().getBaseUrl() + System.getProperty("testInstance")+"/index.lp";
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        String cookie=getCookie(driver);
        request.header("authority","qa.cadonix.online");
        request.header("accept","application/json");
        request.header("content-type","application/x-www-form-urlencoded; charset=UTF-8");
        request.header("cookie", "ArchonixAuth="+cookie+"");
        request.formParam("sQuery", "");
        response = request.post(url);
        String jsonString = response.asString();
        return jsonString;
    }
    public String getwireEditorResponse(WebDriver driver,String url){
        String BASE_URL=ConfigLoader.getInstance().getBaseUrl() + System.getProperty("testInstance")+"/index.lp";
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        String cookie=getCookie(driver);
        request.header("authority","qa.cadonix.online");
        request.header("accept","application/json");
        request.header("content-type","application/x-www-form-urlencoded; charset=UTF-8");
        request.header("cookie", "ArchonixAuth="+cookie+"");
        response = request.post(url);
        String jsonString = response.asString();
        return jsonString;
    }


    public String getCookie(WebDriver driver)
    {
        String token=driver.manage().getCookieNamed("ArchonixAuth").getValue();
        return token;
    }
}
