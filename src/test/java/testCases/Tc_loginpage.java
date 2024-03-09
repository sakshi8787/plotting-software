package testCases;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.Sites;
import pageObject.loginpage;

import java.util.Map;

public class Tc_loginpage extends baseClass{
//    @Test
//    public void loginwithValidCreadential(){
//        loginpage l = new loginpage(driver);
//        l.setUsername(username);
//      //  log.info("Enter username");
//        l.setPassword(password);
//       // log.info("Enter Password");
//
//        l.ClickOnSignUpButton();
//      //  log.info("Clicked on Sign Up Button");
//
//
//
//    }
    //@DataProvider(name ="LoginData" )
//    public Object[][] getData() throws Exception {
//
//        String filePath = "C:\\Users\\S-TECH\\IdeaProjects\\Maven\\untitled\\src\\main\\resources\\plot.xlsx";
//        //Object [][] addContentData =  getExcelMapData(filePath);
//
//       // return addContentData;
//
//    }
    @Test
    public void site(){
        loginpage l = new loginpage(driver);
        l.setUserName(username);
        l.setPassword(password);
        l.clickOnSignUp();

        Sites s = new Sites(driver);
        s.clickOnSitebutton();
        s.clickOnaddnewsitebutton();
    }

}
