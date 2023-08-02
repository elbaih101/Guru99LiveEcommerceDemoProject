package com.elbaih.stepDefs;
import com.elbaih.pages.P01_HomePage;
import com.elbaih.pages.P06_RegisterPage;
import com.elbaih.pages.P07_TvList;
import com.elbaih.pages.P08_WishList;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import com.github.javafaker.*;

import java.time.Duration;

public class D05_WishList {
    Faker faker=new Faker();
WebDriverWait wait =new WebDriverWait(Hooks.driver, Duration.ofSeconds(2));
P01_HomePage homePage=new P01_HomePage();
P06_RegisterPage registerPage=new P06_RegisterPage();
P07_TvList tvList=new P07_TvList();
P08_WishList wishList= new P08_WishList();
SoftAssert assrt =new SoftAssert();

    @And("user clicks on the account link then the register link")
    public void userClicksOnTheAccountLinkThenTheRegisterLink() {
        homePage.accountlink.click();
        wait.until(ExpectedConditions.visibilityOf(homePage.registerlink));
        homePage.registerlink.click();

    }

    @Then("user is directed to register page and fills the requierd data firstname {string} last name {string} email {string} password {string}")
    public void userIsDirectedToRegisterPageAndFillsTheRequierdDataFirstnameLastNameEmailPassword(String firstname, String lastname, String email, String password) {
        wait.until(ExpectedConditions.urlContains("account/create/"));
        registerPage.firstNameField.sendKeys(faker.name().firstName());
        registerPage.lastNameField.sendKeys(faker.name().lastName());
        registerPage.emailField.sendKeys(faker.internet().emailAddress());
        password=faker.internet().password();
        registerPage.passwordField.sendKeys(password);
        registerPage.confirmPasswordField.sendKeys(password);

    }

    @And("clicks on register button")
    public void clicksOnRegisterButton() {
        registerPage.registerButton.click();
    }

    @Then("a message indicating succesful registration is shown containing {string}")
    public void aMessageIndicatingSuccesfulRegistrationIsShownContaining(String expectedMsg) {
       assrt.assertTrue(registerPage.successMsg.getText().contains(expectedMsg),"messag doesnt match");
       assrt.assertAll();
    }

    @And("user clicks on the Tv link to get directed to tv menu")
    public void userClicksOnTheTvLinkToGetDirectedToTvMenu() {
        homePage.tvList.click();
    }

    @Then("user adds product {string} to wish list")
    public void userAddsProductToWishList(String arg0) {

               tvList.lgLcdWishButton.click();

        }


    @When("user clicks share list user is directed to sharing page message containing {string} should appear")
    public void userClicksShareListUserIsDirectedToSharingPageMessageContainingShouldAppear(String expectedMSg) {
        wait.until(ExpectedConditions.urlContains("/wishlist"));
        assrt.assertTrue(wishList.successMsg.getText().contains(expectedMSg));
        assrt.assertAll();
        wishList.shareWishListButton.click();
    }

    @Then("user enters email addres {string} and message {string}")
    public void userEntersEmailAddresAndMessage(String email, String msg) {
        wishList.emailField.sendKeys(email);
        wishList.messageField.sendKeys(msg);
        wishList.shareWishListButton.click();
    }

    @Then("confirmation message appears containing {string}")
    public void confirmationMessageAppearsContaining(String msg) {
        assrt.assertTrue(wishList.successMsg.getText().contains(msg));
        assrt.assertAll();
    }
}
