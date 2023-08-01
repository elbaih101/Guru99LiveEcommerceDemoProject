package com.elbaih.stepDefs;

import com.elbaih.pages.P02_MobileList;
import com.elbaih.pages.P04_Cart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.atomic.AtomicReference;

public class D03_VerifyCart {
    SoftAssert assrt=new SoftAssert();

    P02_MobileList mobileList = new P02_MobileList();
    P04_Cart cart = new P04_Cart();

    AtomicReference<WebElement> temp = new AtomicReference<>(null);

    @When("user click on the add to cart button for the sony xperia phone")
    public void userClickOnTheAddToCartButtonForTheSonyXperiaPhone() {
        mobileList.mobilelist.forEach(WebElement -> temp.set(WebElement.findElement(By.xpath("//*/a[@title=\"Sony Xperia\"]/..//following-sibling::div[@class=\"actions\"]/button[@title=\"Add to Cart\"]"))));
        if (temp != null)
            temp.get().click();
    }

    @And("set the quantity to {string} and click the update button")
    public void setTheQuantityToAndClickTheUpdateButton(String quantity) {
        cart.quantityField.click();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        cart.quantityField.sendKeys(quantity);
        if (cart.updateButton.isDisplayed())
            cart.updateButton.click();
    }


    @Then("an error message should appear")
    public void anErrorMessageShouldAppear() {
        String expectedErorrMessage="Some of the products cannot be ordered in requested quantity";
        assrt.assertTrue(cart.errorMessage.isDisplayed());
        assrt.assertTrue(cart.errorMessage.getText().contains(expectedErorrMessage));
        assrt.assertAll();
    }

    @When("clicking the empty cart")
    public void clickingTheEmptyCart() {
        cart.emptyCartButton.click();
    }

    @Then("the cart should be empty")
    public void theCartShouldBeEmpty() {
        String expectedTitle="Shopping Cart is Empty";
        assrt.assertEquals(cart.cartPageTitle.getText().toLowerCase(),expectedTitle.toLowerCase());
        assrt.assertAll();
    }



}
