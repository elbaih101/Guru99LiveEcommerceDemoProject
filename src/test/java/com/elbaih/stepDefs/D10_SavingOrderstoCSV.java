package com.elbaih.stepDefs;

import com.elbaih.pages.P14_AdminPage;
import com.elbaih.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;
import org.testng.reporters.EmailableReporter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

public class D10_SavingOrderstoCSV {

    P14_AdminPage adminPage=new P14_AdminPage();
    WebDriverWait wait=new WebDriverWait(Hooks.driver, Duration.ofSeconds(20));
Actions actions=new Actions(Hooks.driver);
SoftAssert assrt =new SoftAssert();





    @And("enters the user name {string} and password {string} and clicks login")
    public void entersTheUserNameAndPasswordAndClicksLogin(String user, String pass) {
        adminPage.usernameField.sendKeys(user);
        adminPage.passwordField.sendKeys((pass));
        adminPage.loginButton.click();
    }

    @And("user closes the pop up and hovers over the sales link then click the orders link")
    public void userClosesThePopUpAndHoversOverTheSalesLinkThenClickTheOrdersLink() {
       wait.until(ExpectedConditions.visibilityOf(adminPage.popUpCloseButton));
        adminPage.popUpCloseButton.click();
       actions.moveToElement(adminPage.salesLink).perform();


       wait.until(ExpectedConditions.visibilityOf(adminPage.ordersLink));
       adminPage.ordersLink.click();
    }

    @When("user chooses the export type as csv and then cliks export")
    public void userChoosesTheExportTypeAsCsvAndThenCliksExport() {
        wait.until(ExpectedConditions.visibilityOf(adminPage.exportTypeList));
        Select select =new Select(adminPage.exportTypeList);
        select.selectByVisibleText("CSV");
        adminPage.exportButton.click();

    }

    @Then("a csv file containing the orders data is downloaded to distination folder")
    public void aCsvFileContainingTheOrdersDataIsDownloadedToDistinationFolder() {

    wait.until(d-> Utils.isFileDownloaded("src/main/resources/savedorders", "orders.csv"));
    assrt.assertTrue(Utils.isFileDownloaded("src/main/resources/savedorders", "orders.csv"));


        assrt.assertAll();
    }

    @Then("the file is logged in console and maileed to email")
    public void theFileIsLoggedInConsoleAndMaileedToEmail() {
        File orders =new File("src/main/resources/savedorders/orders.csv");
        try {
            FileReader reader=new FileReader(orders);
            int i;
            while((i=reader.read())!=-1)
                System.out.print((char)i);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
