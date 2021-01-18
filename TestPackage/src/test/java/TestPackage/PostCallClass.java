package TestPackage;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;
public class PostCallClass {
    @Test
    public void postCall(){
        RestAssured.baseURI="https://reqres.in/";
        Response res = RestAssured.given()
                .contentType("application/json")
                .body("{\n" +
                        "    \"name\": \"Rest\",\n" +
                        "    \"job\": \"qa\"\n" +
                        "}")
                .post("/api/users");
        //System.out.println(res.getBody().asString());
        JsonPath con = res.jsonPath();
        System.out.println(con.get("id"));
    }
    @Test
    public void post_student_Details(){
        RestAssured.baseURI="http://thetestingworldapi.com";
        Response res = RestAssured.given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"first_name\": \"sample string 233\",\n" +
                        "  \"middle_name\": \"sample string 333\",\n" +
                        "  \"last_name\": \"sample string 4333\",\n" +
                        "  \"date_of_birth\": \"sample string 5333\"\n" +
                        "}")
                .post("api/studentsDetails");
        System.out.println(res.getBody().asString());
        JsonPath th = res.jsonPath();
        System.out.println(th.get("date_of_birth"));
    }
}