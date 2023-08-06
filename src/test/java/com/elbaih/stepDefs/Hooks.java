package com.elbaih.stepDefs;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.util.concurrent.TimeUnit;

public class Hooks {
  public static WebDriver driver ;

  @Before
    public static void init(){
   WebDriverManager.firefoxdriver().setup();
      FirefoxOptions options = new FirefoxOptions();
//      FirefoxProfile fp = new FirefoxProfile();
//      fp.setPreference("print.always_print_silent",true);
//      fp.setPreference("browser.download.folderList", 2);
//      fp.setPreference("browser.download.manager.showWhenStarting", false);
//      fp.setPreference("browser.download.dir", "D:\\java maven projects\\Guru99ECommerceDemo\\src\\main\\resources\\savedorders");
//      fp.setPreference("browser.helperApps.neverAsk.openFile", "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,document/pdf,application/pdf");
//      fp.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,document/pdf,application/pdf");
//      fp.setPreference("browser.helperApps.alwaysAsk.force", false);
//      fp.setPreference("browser.download.manager.alertOnEXEOpen", false);
//      fp.setPreference("browser.download.manager.focusWhenStarting", false);
//      fp.setPreference("browser.download.manager.useWindow", false);
//      fp.setPreference("browser.download.manager.showAlertOnComplete", false);
//      fp.setPreference("browser.download.manager.closeWhenDone", false);
//options.setProfile(fp);

      //config

      options.addPreference("browser.aboutConfig.showWarning", false);
      options.addPreference("pdfjs.disabled", true);
      options.addPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream;application/vnd.ms-excel;text/html,text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,document/pdf,application/pdf,application/x-pdf,document");
      options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream;application/vnd.ms-excel;text/html,text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,document/pdf,application/pdf,application/x-pdf,document");
      options.addPreference("browser.helperApps.alwaysAsk.force", false);
      options.addPreference("browser.helperApps.neverAsk.openFile", "application/octet-stream;application/vnd.ms-excel;text/html,text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,document/pdf,application/pdf,application/x-pdf,document");
      options.addPreference("browser.helperApps.neverAsk.saveToDisk", "application/octet-stream;application/vnd.ms-excel;text/html,text/csv,application/x-msexcel,application/excel,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,document/pdf,application/pdf,application/x-pdf,document");
      options.addPreference("browser.helperApps.alwaysAsk.force", false);

      //download options

//      options.addPreference("browser.download.folderList", 2);
//      options.addPreference("browser.download.manager.showWhenStarting", false);
//      options.addPreference("browser.download.dir", "D:\\java maven projects\\Guru99ECommerceDemo\\src\\main\\resources\\savedorders");
//      options.addPreference("browser.download.manager.alertOnEXEOpen", false);
//      options.addPreference("browser.download.manager.focusWhenStarting", false);
//      options.addPreference("browser.download.manager.useWindow", false);
//      options.addPreference("browser.download.manager.showAlertOnComplete", false);
//      options.addPreference("browser.download.manager.closeWhenDone", false);

      //printer config

      options.addPreference("print.always_print_silent",true);
      options.addPreference("print.save_print_settings",false);
      options.addPreference("print_printer", "Microsoft Print to PDF");
      options.addPreference("print.show_print_progress", false);
      options.addPreference("print.save_as_pdf.links.enabled", true);
      options.addPreference("print.printer_Microsoft_Print_to_PDF.print_to_file", true);
      options.addPreference("print.printer_Microsoft_Print_to_PDF.print_to_filename", "D:\\java maven projects\\Guru99ECommerceDemo\\src\\main\\resources\\savedorders\\order.pdf");
//      options.addPreference("print.printer_Mozilla_Save_to_PDF.print_paper_id", "iso_a4");
//      options.addPreference("print.printer_Microsoft_Print_to_PDF.print_to_filename", "{your odrder}");







      driver= new  FirefoxDriver(options);
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }



  @After
    public static void end(){

          try {
              Thread.sleep(3000);
             }catch(InterruptedException e){
              e.printStackTrace();}
//          driver.close();
          driver.quit();

  }
}
