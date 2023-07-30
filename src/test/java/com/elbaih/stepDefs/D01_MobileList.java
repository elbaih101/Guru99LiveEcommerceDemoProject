package com.elbaih.stepDefs;

import com.elbaih.pages.P01_HomePage;
import com.elbaih.pages.P02_MobileList;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.sql.Time;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class D01_MobileList {
    WebDriver driver = Hooks.driver;
    P01_HomePage homePage =new P01_HomePage();
    P02_MobileList mobileList = new P02_MobileList();

    SoftAssert assrt = new SoftAssert();

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    @Given("user goes to the home page {string}")
    public void userGoesToTheHomePage(String url) {
        driver.get(url);
    }

    @Then("verify the title of the page is {string}")
    public void verify_the_title_of_the_page_is(String title) {
        assrt.assertTrue(driver.getTitle().contains(title));
        assrt.assertAll();
    }

    @Then("text {string} is shown on home page")
    public void text_is_shown_on_home_page(String expecetd_text) {
        assrt.assertTrue(homePage.pagetitle.getText().contains(expecetd_text));
        assrt.assertAll();

    }

    @When("user clicks on the Mobile menu")
    public void user_clicks_on_the_mobile_menu() {
        homePage.mobilelist.click();
    }

    @Then("user is directed to the mobile list page and verify the title is {string}")
    public void user_is_directed_to_the_mobile_list_page_and_verify_the_title_is(String page_title) {
        wait.until(ExpectedConditions.urlContains("http://live.techpanda.org/index.php/mobile.html"));
        assrt.assertTrue(driver.getTitle().contains(page_title));
    }

    @When("user selects sort by {string}")
    public void user_selects_sort_by(String name) {
        Select select = new Select(mobileList.sortlist);
        select.selectByVisibleText(name);
    }

    @Then("all {int} elemnts are sorted by name")
    public void all_elemnts_are_sorted_by_name(Integer int1) {
        List<String> names = new ArrayList<>();
        for (WebElement e : mobileList.mobilelist) {
            names.add(e.findElement(By.cssSelector("h2 a[title]")).getText());
        }

        String prev = "";
        for (String current : names) {
            assrt.assertTrue(current.compareTo(prev) > 0);
            assrt.assertAll();
            prev = current;
        }

    }


}
