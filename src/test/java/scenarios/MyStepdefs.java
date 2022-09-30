package scenarios;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static io.restassured.RestAssured.*;

public class MyStepdefs {
    int firstValue;
    int secondValue;
    String function;

    @Given("I have {int}")
    public void iHaveOpeningBalance(int firstValue) {
        this.firstValue = firstValue;
    }

    @When("I add {int}")
    public void iAddAdded(int secondValue) {
        this.secondValue = secondValue;
    }

    @Then("I should have {int}")
    public void iShouldHaveTotal(int balance) {
        int returnedBalance = Integer.parseInt(given()
                .when()
                .get("http://127.0.0.1:8080/calculator/add/" + firstValue + "/" + secondValue).body().asString());
        Assertions.assertEquals(returnedBalance,  balance);

    }

    @When("I have {string} {int}")
    public void iProccess(String function, int secondValue){
        this.function = function;
        this.secondValue = secondValue;
    }

}
