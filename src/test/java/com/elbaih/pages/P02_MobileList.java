package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class P02_MobileList {
    final WebDriver driver = Hooks.driver;

    public P02_MobileList() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "select[title=\"Sort By\"]")
    public WebElement sortlist;

    @FindBy(css = ".item.last")
    public List<WebElement> mobilelist;

    @FindBy(css = "div[class=\"block block-list block-compare\"] div[class=\"actions\"] button[class=\"button\"]")
    public WebElement compareButton;
    @FindBy(className = "success-msg")
    public WebElement succesMsg;
}
