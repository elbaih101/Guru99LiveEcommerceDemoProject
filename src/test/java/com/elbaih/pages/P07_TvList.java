package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P07_TvList {

   public P07_TvList(){PageFactory.initElements(Hooks.driver,this);}



    @FindBy(css = ".item.last")
    public List<WebElement> tvList;
   @FindBy(xpath = "//a[@title=\"LG LCD\"]//..//a[@class=\"link-wishlist\"]")
    public WebElement lgLcdWishButton;
}
