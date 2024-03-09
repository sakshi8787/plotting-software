package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Sites {

    WebDriver driver;


    @FindBy(xpath = " //span[text()=\"Sites\"]")
    WebElement sitebutton;
    @FindBy(partialLinkText = "Add New Site")
    WebElement addnewsitebutton;

    @CacheLookup
    @FindBy(how = How.XPATH,using = "//input[@id=\"first-name\" and @name=\"name\"]")
    private  WebElement SiteName;

    @CacheLookup
    @FindBy(how = How.XPATH,using = "//input[@id=\"first-name\" and @name=\"location\"]")
    public WebElement SiteLocation;

    @CacheLookup
    @FindBy(how = How.XPATH,using = "//textarea[@name=\"description\"]")
    public WebElement SiteDescription;

    @CacheLookup
    @FindBy(how = How.NAME,using = "link")
    public WebElement Sitelink;

    @CacheLookup
    @FindBy(how = How.NAME,using = "image_filename")
    public WebElement SiteImages;

    @CacheLookup
    @FindBy(how = How.NAME,using = "submit")
    public WebElement SubmitButton;


    //=============================view plot====================================

    @CacheLookup
    @FindBy(how = How.XPATH,using = "//a[text()=\"View Sites\"]")
    public WebElement view_button;

    @CacheLookup
    @FindBy(how = How.XPATH,using = "//a[text()=\"Plot Management\"]")
    public WebElement plotmanagement;

    @CacheLookup
    @FindBy(how = How.NAME,using = "customer_id")
    public WebElement selectcustomer;

    @CacheLookup
    @FindBy(how = How.XPATH,using = "//input[@name=\"plotname\"]")
    public WebElement plotNumber;

    @CacheLookup
    @FindBy(how = How.XPATH,using = "//select[@name=\"plottype\"]")
    public WebElement selecttype;

    @CacheLookup
    @FindBy(how= How.NAME,using = "plotstatus")
    public WebElement selectstatus;

    @CacheLookup
    @FindBy(how = How.NAME,using = "plotarea")
    public WebElement plotarea;

    @CacheLookup
    @FindBy(how = How.NAME,using = "costpersqft")
    public WebElement costpersqft;
    @CacheLookup
    @FindBy(how = How.NAME,using = "totalcost")
    public WebElement totalcost;

    @CacheLookup
    @FindBy(how = How.NAME,using = "note")
    public WebElement note;
    @CacheLookup
    @FindBy(how = How.NAME,using = "save_plot")
    public WebElement sumbitbutton;


    // =============================add payment ==========================================

    @CacheLookup
    @FindBy(how = How.XPATH,using = "//a[text()=\"Add Payment\"]")
    public WebElement Addpayment;

    @CacheLookup
    @FindBy(how = How.NAME,using = "select_plot_id")
    public WebElement SelectPlot;


    @CacheLookup
    @FindBy(how = How.NAME,using = "paidamount")
    public WebElement SelectAmount;

    @CacheLookup
    @FindBy(how = How.NAME,using = "payment_date")
    public WebElement selectpaymentdate;
    @CacheLookup
    @FindBy(how = How.NAME,using = "payment_mode")
    public WebElement selectpaymentmode;

    @CacheLookup
    @FindBy(how = How.XPATH,using = "//textarea[@placeholder=\"Enter Payment Note\"]")
    public WebElement selectpaymentnote;

    @CacheLookup
    @FindBy(how = How.NAME,using = "save_payment")
    public WebElement selectsumbitpayment;




    public Sites( WebDriver driver){
            this.driver= driver;
        PageFactory.initElements(driver,this);
    }

    public void clickOnSitebutton(){
        sitebutton.click();
    }
    public void clickOnaddnewsitebutton(){
        addnewsitebutton.click();
    }

    public void SetSiteName(String Sitename){
        SiteName.sendKeys(Sitename);
    }
    public void SetSiteLocation(String location){
        SiteLocation.sendKeys(location);
    }
    public void SetSiteDescription(String description)
    {

        SiteDescription.sendKeys(description);
    }
    public void setSitelink(String youtubelink){

        Sitelink.sendKeys(youtubelink);
    }
    public void setSiteImages(String Siteimage){
        SiteImages.sendKeys(Siteimage);
    }

    public void setSubmit(){
        SubmitButton.click();
    }

    //===================================================================================

    public void setViewbutton(){
        view_button.click();
    }
    public void setPlotManage(){
        plotmanagement.click();
    }
    public void setSelectcus(String Selectcustomer){
        Select s = new Select(selectcustomer);
        s.selectByVisibleText(Selectcustomer);
    }

    public void setPlotnum(String plotno){
        plotNumber.sendKeys(plotno);
    }
    public void setSelecttype(String type){
        Select s = new Select(selecttype);
        s.selectByVisibleText(type);
    }
    public void setstatus(String status){
        Select s = new Select(selectstatus);
        s.selectByVisibleText(status);
    }
    public void setplotArea(String plot_Area){
       plotarea.sendKeys(plot_Area);

    }
    public void setselectRate(String rate){
        costpersqft.sendKeys(rate);
    }
    public void setcost(){
        totalcost.click();
    }
    public void setNote(String notes){
        note.sendKeys(notes);
    }
    public void setsumbitbutton(){
        sumbitbutton.click();
    }


    //==========================add payment ================================

    public void setAddapymentbutton(){
        Addpayment.click();
    }
    public void setSelectPlot(String selectingPlot){
        SelectPlot.sendKeys(selectingPlot);
    }
    public void selectamount(String paidamount){
        SelectAmount.sendKeys(paidamount);
    }
    public void date(String selectDate){
        selectpaymentdate.sendKeys(selectDate);
    }
    public void modeOfPayment(String mode){
        Select s = new Select(selectpaymentmode);
        s.selectByVisibleText(mode);
    }
    public void note(String Notes){
        selectpaymentnote.sendKeys(Notes);

    }
    public void addpaymentSubmit(){
        selectsumbitpayment.click();
    }






}
