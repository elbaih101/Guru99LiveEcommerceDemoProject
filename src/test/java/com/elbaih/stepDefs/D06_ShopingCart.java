package com.elbaih.stepDefs;

import com.elbaih.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class D06_ShopingCart {

    SoftAssert assrt =new SoftAssert();
    P01_HomePage homePage=new P01_HomePage();
    P08_WishList wishList=new P08_WishList();
    P09_LoginPage loginPage=new P09_LoginPage();
    P10_CustomerPage customerPage=new P10_CustomerPage();
    P11_ShopingCart shopingCart=new P11_ShopingCart();
    P12_Checkout checkout=new P12_Checkout();
    @And("user clicks on the account link then the login link")
    public void userClicksOnTheAccountLinkThenTheLoginLink() {
        homePage.accountlink.click();
        homePage.loginLink.click();
        loginPage.emaiField.sendKeys("zobazoba@zoba.com");
        loginPage.passField.sendKeys("zobazoba");
        loginPage.loginButton.click();
    }

    @And("user clicks on my wish list link")
    public void userClicksOnMyWishListLink() {
        customerPage.wishListLink.click();
    }

    @When("user clisks on add to cart in wish list page he is directed to shoping cart page")
    public void userClisksOnAddToCartInWishListPageHeIsDirectedToShopingCartPage() {
        wishList.addtoCartButton.click();
    }

    @Then("user enter chooses thecountry {string} and the region {string} and enter thr post code {string}")
    public void userEnterChoosesThecountryAndTheRegionAndEnterThrPostCode(String country, String region, String zipCode) {
         Select countryList =new Select(shopingCart.countrys);
        countryList.selectByVisibleText(country);
      Select regionList =new Select(shopingCart.regions);
       regionList.selectByVisibleText(region);
        shopingCart.zipCodeField.sendKeys(zipCode);
    }

    @And("user clisks estimate then chooses the fixed flatrate and cliks updatetotal")
    public void userClisksEstimateThenChoosesTheFixedFlatrateAndCliksUpdatetotal() {
        shopingCart.estimateButton.click();
        shopingCart.flatRateRadioButton.click();
        shopingCart.updateTotalButton.click();
    }

    @Then("verify that the flate rate is added to the subtotal in the grand total")
    public void verifyThatTheFlateRateIsAddedToTheSubtotalInTheGrandTotal() {
        NumberFormat format =NumberFormat.getCurrencyInstance();
       List<Double> prices=new ArrayList<Double>();
        for (WebElement price:shopingCart.prices) {
            try {
                prices.add(format.parse(price.getText()).doubleValue());
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }
        prices.sort(null);
        assrt.assertEquals(prices.get(0)+prices.get(1),prices.get(2));
        assrt.assertAll();
    }

    @When("user clicks on procede to checkout he is directed to checkoutpage")
    public void userClicksOnProcedeToCheckoutHeIsDirectedToCheckoutpage() {
        shopingCart.proceedtoCheckoutButton.click();
    }

    @And("user cliks on containue button and containue button")
    public void userCliksOnContainueButtonAndContainueButton() {
       checkout.addressField.sendKeys("ABC");
       checkout.cityField.sendKeys("New York");
       Select countryList = new Select(checkout.countrys);
      countryList.selectByVisibleText("United States");
      Select regionList = new Select(checkout.regions);
       regionList.selectByVisibleText("New York");
       checkout.zipCodeField.sendKeys("542896");
       checkout.telField.sendKeys("123456");

        checkout.billingInfoContainueButton.click();
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        checkout.shippingMethodContainueButton.click();

    }

    @Then("user chooses  payment method by check and clicks containue")
    public void userChoosesPaymentMethodByCheckAndClicksContainue() {
        checkout.checkPAyMethodRadioButton.click();
        checkout.paymentInfoContainueButton.click();
    }

    @And("user place orderbutton")
    public void userPlaceOrderbutton() {
        checkout.submitButton.click();
    }

    @Then("success message is shown containing {string}")
    public void successMessageIsShownContaining(String arg0) {
        assrt.assertTrue(checkout.succesMsg.getText().contains(arg0));
        assrt.assertAll();
    }
}
