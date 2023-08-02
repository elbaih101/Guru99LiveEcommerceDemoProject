package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class P08_WishList {
    public P08_WishList() {
        PageFactory.initElements(Hooks.driver, this);
    }

    @FindBy(className = "success-msg")
    public WebElement successMsg;
    //LG LCD has been added to your wishlist
    @FindBy(css = "Button[title=\"Share Wishlist\"]")
    public WebElement shareWishListButton;
    @FindBy(id = "email_address")
    public WebElement emailField;
    @FindBy(id = "message")
    public WebElement messageField;

}
