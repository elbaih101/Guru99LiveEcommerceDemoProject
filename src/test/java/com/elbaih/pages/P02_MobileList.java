package com.elbaih.pages;

import com.elbaih.stepDefs.Hooks;
import io.cucumber.messages.types.Hook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
public class P02_MobileList {
    WebDriver driver = Hooks.driver;

    public P02_MobileList(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "select[title=\"Sort By\"]")
   public WebElement sortlist;

    @FindBy(css = ".item.last")
    public List<WebElement> mobilelist;
}
