package com.elbaih.stepDefs;

import com.elbaih.pages.P02_MobileList;
import com.elbaih.pages.P05_ComparePage;
import com.elbaih.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public class D04_Compare {
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(2));
    SoftAssert assrt = new SoftAssert();

    P02_MobileList mobileList = new P02_MobileList();
    P05_ComparePage compare = new P05_ComparePage();

    @When("user clicks on add to compare button for two mobile phones {string} and {string}")
    public void userClicksOnAddToCompareButtonForTwoMobilePhonesAnd(String arg0, String arg1) {
        WebElement galaxycomparebutton;
        WebElement sonycomparebutton;
        for (WebElement mobile : mobileList.mobilelist) {
            galaxycomparebutton = Utils.retryingFind(mobile, By.xpath("//*/a[@title=\"Samsung Galaxy\"]/..//following-sibling::*//ul//a[@class=\"link-compare\"]"));
            if (galaxycomparebutton != null)
                galaxycomparebutton.click();

        }
        wait.until(ExpectedConditions.visibilityOf(mobileList.succesMsg));
        for (WebElement mobile : mobileList.mobilelist) {
            sonycomparebutton = Utils.retryingFind(mobile, By.xpath("//*/a[@title=\"Sony Xperia\"]/..//following-sibling::*//ul//a[@class=\"link-compare\"]"));
            if (sonycomparebutton != null)
                sonycomparebutton.click();
        }
    }

    @And("user clicks on the compare button on the compare menue")
    public void userClicksOnTheCompareButtonOnTheCompareMenue() {
        wait.until(ExpectedConditions.visibilityOf(mobileList.compareButton));
        mobileList.compareButton.click();
    }

    @Then("a pop up window pops containing the two products")
    public void aPopUpWindowPopsContainingTheTwoProducts() {
        ArrayList<String> windows = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(windows.get(1));
        assrt.assertTrue(compare.compareTable.findElement(By.xpath(compare.xperiaNameXpath)).isDisplayed() && compare.compareTable.findElement(By.xpath(compare.galaxyNameXpath)).isDisplayed());

    }

    @Then("user closes the pop up window")
    public void userClosesThePopUpWindow() {
        Hooks.driver.close();
    }
}
