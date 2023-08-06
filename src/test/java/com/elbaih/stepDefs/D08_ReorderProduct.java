package com.elbaih.stepDefs;

import com.elbaih.pages.P04_Cart;
import com.elbaih.pages.P10_CustomerPage;
import com.elbaih.pages.P11_ShopingCart;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class D08_ReorderProduct {

    SoftAssert assrt =new SoftAssert();
    WebDriverWait wait =new WebDriverWait(Hooks.driver, Duration.ofSeconds(2));
    P10_CustomerPage customerPage=new P10_CustomerPage();
    P11_ShopingCart shopingCart =new P11_ShopingCart();
    P04_Cart cart=new P04_Cart();
    double odlPrice;
    double updatedPrice;
    NumberFormat format =NumberFormat.getCurrencyInstance();
    List<Double> prices=new ArrayList<Double>();
    String orderNum;
    @When("user clicks on reorder link and change quantity and click update")
    public void userClicksOnReorderLinkAndChangeQuantityAndClickUpdate() {
        customerPage.latestOrder.findElement(By.xpath("a[contains(text(),\"View Order\")]")).click();
        cart.quantityField.click();
        cart.quantityField.sendKeys("5");

        for (WebElement price:shopingCart.prices) {
            try {
                prices.add(format.parse(price.getText()).doubleValue());
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
       prices.sort(null);
        odlPrice= prices.get(prices.size()-1);

        wait.until(ExpectedConditions.visibilityOf(cart.updateButton));
        cart.updateButton.click();
    }

    @Then("the grand total price is changed")
    public void theGrandTotalPriceIsChanged() {

        for (WebElement price:shopingCart.prices) {
            try {
                prices.add(format.parse(price.getText()).doubleValue());
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        prices.sort(null);
        updatedPrice= prices.get(prices.size()-1);
        assrt.assertNotEquals(odlPrice,updatedPrice);
        assrt.assertAll();

    }

    @Then("note the order number and verify its generated")
    public void noteTheOrderNumberAndVerifyItsGenerated() {

    }
}
