package testCases;

import Utilities.Excel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.Sites;
import pageObject.loginpage;

import java.io.IOException;

public class TC_LoginDDT extends baseClass{
   @Test(dataProvider = "loginData")
    public void loginDDT(String user, String pwd) throws InterruptedException {
       System.out.println("Testing with username: " + user + " and password: " + pwd);

       loginpage l = new loginpage(driver);
       l.setUserName(user);
       l.setPassword(pwd);
       l.clickOnSignUp();
       Thread.sleep(4000);

       WebElement sucess = driver.findElement(By.xpath("//strong[text()=\"Success!\"]"));
       if (sucess.isDisplayed()){
           System.out.println("login successfully");
       }
       else
       {
           System.out.println("logout!!!!");
       }


       if (driver.getTitle().equals("Dashboard | Mahalaxmi Plotting ")){
           Assert.assertTrue(true);
       }
       else {
           Assert.assertTrue(false);
       }


   }
   @DataProvider(name = "loginData")
    public String [][] getData() throws IOException
   {
        String path ="C:\\Users\\S-TECH\\IdeaProjects\\Maven\\untitled\\src\\main\\resources\\plot.xlsx";
        int rownum = Excel.getRowCount(path,"Sheet1");
        int cellnum = Excel.getCellCount(path,"Sheet1",1);

        String loginData[][] = new String[rownum][cellnum];
        for (int i =1; i<=rownum;i++){
            for (int j=0; j<cellnum;j++){


                loginData[i-1][j] = Excel.getCellData(path,"Sheet1",i,j);

            }
        }
        return loginData;
    }
}
