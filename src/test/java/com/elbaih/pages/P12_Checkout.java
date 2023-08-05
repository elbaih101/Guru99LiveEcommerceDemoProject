package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import io.cucumber.java.eo.Se;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.nio.file.WatchEvent;

public class P12_Checkout {

    public P12_Checkout() {
        PageFactory.initElements(Hooks.driver, this);

    }

    @FindBy(id = "billing:street1")
    public WebElement addressField;
    @FindBy(id = "billing:city")
    public WebElement cityField;

    @FindBy(id = "billing:region_id")
    public WebElement regions;


    @FindBy(id = "billing:postcode")
    public WebElement zipCodeField;
    @FindBy(id = "billing:country_id")
    public WebElement countrys;

    @FindBy(id = "billing:telephone")
    public WebElement telField;
    @FindBy(css = "div[id=\"checkout-step-billing\"] Button[title=\"Continue\"]")
    public WebElement billingInfoContainueButton;
    @FindBy(css = "Button[onclick=\"shippingMethod.save()\"]")
    public WebElement shippingMethodContainueButton;
    @FindBy(id = "p_method_checkmo")
    public WebElement checkPAyMethodRadioButton;
    @FindBy(css = "Button[onclick=\"payment.save()\"]")
    public WebElement paymentInfoContainueButton;
    @FindBy(css = "Button[title=\"Place Order\"]")
    public WebElement submitButton;
    @FindBy(className = "page-title")
    public WebElement succesMsg;

}
