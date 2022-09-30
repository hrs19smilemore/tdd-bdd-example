import io.restassured.path.json.JsonPath;
import org.apache.http.util.Asserts;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.StringContains.containsString;

public class ApplicationTest {
    @Test
    public void basicPingTest(){
        List<Person> list = (List<Person> )given().when().get("http://127.0.0.1:8080/person").then().statusCode(200).and().extract().as(List.class);
        String name = "Sharven";
        String foundName = null;
        for(var l : list){
            if (l.name.equals(name)){
                foundName = l.name;
            }
        }
        Assert.assertEquals(name, foundName);

    }

    @Test
    public void personListTest(){
        JsonPath jsonPath = given().when().get("http://127.0.0.1:8080/person").jsonPath();
        boolean found = true;
        String name = "";
        do{
            name = jsonPath.get("name");
            if (name.equals("Sharven")){
                found = false;
                break;
            }
        } while (found);
    }
}
