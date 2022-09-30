package scenarios;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.given;

public class MyStepdefs {
    Integer balance;

    @Given("I have {int}")
    public void iHaveOpeningBalance(int balance) {
        this.balance = given()
                .pathParam("balance", balance)
                .when().post("127.0.0.1:8080/calculator/set/{balance}").then().extract().as(Integer.class);
    }

    @When("I add {int}")
    public void iAddAdded(int added) {
         given()
                .pathParam("value", added)
                .when()
                .post("127.0.0.1:8080/calculator/add/{value}");
    }

    @Then("I should have {int}")
    public void iShouldHaveTotal(int updatedBalance) {
        this.balance = given().when().get("127.0.0.1:8080/calculator/balance").then().extract().as(Integer.class);
        Assertions.assertEquals(this.balance, updatedBalance);
    }

}
