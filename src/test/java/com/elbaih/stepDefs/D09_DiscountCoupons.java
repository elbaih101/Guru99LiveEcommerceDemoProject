package com.elbaih.stepDefs;

import com.elbaih.pages.P02_MobileList;
import com.elbaih.pages.P11_ShopingCart;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import javax.swing.text.NumberFormatter;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class D09_DiscountCoupons {
    SoftAssert assrt =new SoftAssert();
P02_MobileList mobileList=new P02_MobileList();
P11_ShopingCart cart=new P11_ShopingCart();

    final AtomicReference<WebElement> temp = new AtomicReference<>(null);
    @And("user click on the add to cart button for the Iphone")
    public void userClickOnTheAddToCartButtonForTheIphone() {
        mobileList.mobilelist.forEach(WebElement -> temp.set(WebElement.findElement(By.xpath("//*/a[@title=\"IPhone\"]/..//following-sibling::div[@class=\"actions\"]/button[@title=\"Add to Cart\"]"))));
        if (temp != null)
            temp.get().click();
    }

    @When("user enters the coupon {string} and click apply")
    public void userEntersTheCouponAndClickApply(String coupon) {
        cart.couponeField.sendKeys(coupon);
        cart.applyCouponButton.click();
    }
    @Then("success message containing Coupon code {string} was applied is shown")
    public void successMessageContainingCouponCodeWasAppliedIsShown(String coupon) {
      assrt.assertTrue( cart.succesmsg.getText().contains(coupon));
      assrt.assertAll();

    }
    @And("the price is discounted by {int}%")
    public void thePriceIsDiscountedBy(int arg0) {
        NumberFormat format=NumberFormat.getCurrencyInstance();
        List<Double> prices =new ArrayList<>();
        for (WebElement price:cart.prices) {

            try {
                prices.add(format.parse(price.getText()).doubleValue());
            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        prices.sort(null);

        assrt.assertTrue(Math.abs(prices.get(0)) ==Math.abs(prices.get(1))*0.05);
        assrt.assertAll();
    }


}
