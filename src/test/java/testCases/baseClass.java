package testCases;

import Utilities.readConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.*;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObject.loginpage;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

public class baseClass {
    public static WebDriver driver;
    private static Logger log;
    public static ExtentReports extentReports;
    public static ExtentTest extentTest;
    public static String screenshotsubfoldername;




    //log= LogManager.getLogger(baseClass.class);
    readConfig read = new readConfig();
    public  String Appurl= read.getBrowserName();
    public  String username = read.getUsername();
    public String password = read.getPassword();


    @Parameters("browser")
    @BeforeTest
    public void setun(ITestContext context, @Optional("chrome") String browser){
        switch(browser){
            case "chrome":
               driver = new ChromeDriver();
               log.info("open Tc in Chromedriver");
            break;
            case "firefox":
                driver = new FirefoxDriver();
            break;

        }
        driver.get(Appurl);
       // log.info("URL is opened");
//        Capabilities cap = ((RemoteWebDriver).driver).getCap
//        String device= cap.getBrowserName()+" "+cap.getBrowserVersion();
        extentReports.createTest(context.getName());


            loginpage l = new loginpage(driver);
            l.setUserName(username);
            l.setPassword(password);
            l.clickOnSignUp();

    }
    @BeforeSuite
    public void initialiseExtentReports(){

        extentReports = new ExtentReports();
        ExtentSparkReporter sparkreporter = new ExtentSparkReporter("AllTests.html");
        extentReports.attachReporter(sparkreporter);
        extentReports.setSystemInfo("OS",System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version",System.getProperty("java version"));
    }
    @AfterSuite
    public void generateExtentReports() throws IOException {
        extentReports.flush();
        Desktop.getDesktop().browse(new File("AllTests.html").toURI());
    }
    @AfterMethod
    public void checkStatus(Method m, ITestResult result){

        if (result.getStatus()==ITestResult.FAILURE){
            String screenshotpath =null;
            screenshotpath =captureScreenshot(result.getTestClass().getName()+" " +result.getMethod().getMethodName()+".jpg");
            extentTest.addScreenCaptureFromPath(screenshotpath);
            extentTest.fail(result.getThrowable());
        } else if (result.getStatus()==ITestResult.SUCCESS) {
            extentTest.pass("TestCase is Passed");
        }
        extentTest.assignCategory(m.getAnnotation(Test.class).groups());

    }
    public String captureScreenshot(String fileName) {
        if (screenshotsubfoldername == null) {
            LocalDateTime myDateObj = LocalDateTime.now();
            System.out.println("Before formatting: " + myDateObj);
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("ddMMyyyy-HHmmss");
            screenshotsubfoldername = myDateObj.format(myFormatObj);


        }
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File destFile = new File("./screenshot/" + screenshotsubfoldername + "/" + fileName);
        try {
            FileUtils.copyFile(sourceFile, destFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("screenshot save successfully");

        return fileName;
    }
    @AfterTest
    public void tearDown(){
       // driver.quit();
    }



}
