package testCases;

import Utilities.Excel;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.Sites;

import java.io.IOException;
import java.time.Duration;

public class TC_Site extends baseClass{

    @Test(dataProvider = "SiteInfo")
    public void addSite(String Sitename, String Sitelocation,String description,String Youtubelink,String customer, String plotno,String selecttype ,String status, String plotarea,String rate,String note, String Select_plot ,String amount,String Date ,String paymentmode , String Notes){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        Sites s = new Sites(driver);
        s.clickOnSitebutton();
        s.clickOnaddnewsitebutton();
        s.SetSiteName(Sitename);
        s.SetSiteLocation(Sitelocation);
        s.SetSiteDescription(description);
        s.setSitelink(Youtubelink);
        s.setSiteImages("C:\\Users\\S-TECH\\IdeaProjects\\Maven\\untitled\\src\\images\\dive.jpg");
        s.setSubmit();
        s.setViewbutton();
        s.setPlotManage();
        s.setSelectcus(customer);
        s.setPlotnum(plotno);
        s.setSelecttype(selecttype);
        s.setstatus(status);
        s.setplotArea(plotarea);
        s.setselectRate(rate);
        s.setcost();
        s.setNote(note);
        s.setsumbitbutton();
        s.setAddapymentbutton();
        s.setSelectPlot(Select_plot);
        s.selectamount(amount);
        s.date(Date);
        s.modeOfPayment(paymentmode);
        s.note(Notes);
        s.addpaymentSubmit();




    }

    @DataProvider(name = "SiteInfo")
    public String [][] getSiteData() throws IOException
    {
        String path ="C:\\Users\\S-TECH\\IdeaProjects\\Maven\\untitled\\src\\main\\resources\\Site.xlsx";
        int rownum = Excel.getRowCount(path,"Sheet1");
        int cellnum = Excel.getCellCount(path,"Sheet1",1);

        String SiteData[][] = new String[rownum][cellnum];
        for (int i =1; i<=rownum;i++){
            for (int j=0; j<cellnum;j++){


                SiteData[i-1][j] = Excel.getCellData(path,"Sheet1",i,j);
               // System.out.println(SiteData[i][j]);

            }
        }
        return SiteData;
    }
}
