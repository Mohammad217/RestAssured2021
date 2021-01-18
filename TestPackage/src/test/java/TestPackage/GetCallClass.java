package TestPackage;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.Assert;
public class GetCallClass {
    @Test
    public void learnGetCall(){
        RestAssured.baseURI="https://reqres.in/";
        Response res = RestAssured.given()
                .header("Content_Type", "application/json")
                .accept("ContentType.JSON")
                .get("api/users?page=2");
//        System.out.println("Response Code "+res.statusCode());
//        Assert.assertEquals(res.statusCode(),200);
        System.out.println(res.getBody().asString());
//
//        System.out.println(res.time());
//        System.out.println(res.getHeaders());
//        System.out.println(res.getHeader("Content-Type"));
//        System.out.println(res.getHeader("Date"));
//
        JsonPath js = res.jsonPath();
//        System.out.println(js.get("data.id[1]"));
//        System.out.println(js.get("data.last_name[3]"));
//        System.out.println(js.get("total"));
        //Assertion with try catch
//        try {
//            Assert.assertEquals(res.statusCode(), 200);
//        }catch(AssertionError  er){
//            System.err.println(er);
//        }
//        System.out.println(js.get("total"));
//        System.out.println(js.get("data.last_name[3]"));
        //System.out.println(res.getBody().asString());
        int len=js.getList("data").size();
        for(int i=0;i<len;i++){
            System.out.println(js.get("data.last_name["+i+"]"));
            System.out.println(js.get("data.first_name["+i+"]"));
        }
    }
}