package PageObjects.DatePickersObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DatePickers extends AbstractComponent {

    WebDriver driver;
    public DatePickers(WebDriver driver){
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //DATE EXAMPLE
    @FindBy(xpath = "//*[contains(@class, 'glyphicon-th')]")
    WebElement dateChocolateMenu;
    @FindBy(xpath = "(//th[@class='datepicker-switch'])[1]")
    WebElement switchYear1;
    @FindBy(xpath = "(//th[@class='datepicker-switch'])[2]")
    WebElement switchYear2;
    @FindBy(xpath = "//span[text()='2022']")
    WebElement selectYear;
    @FindBy(xpath = "//span[text()='May']")
    WebElement selectMonth;
    @FindBy(xpath = "//td[text()='26']")
    WebElement selectDay1;
    @FindBy(xpath = "//td[text()='28']")
    WebElement selectDay2;
    @FindBy(xpath = "//div[@class='datepicker-days']/table/tfoot/tr/th[@class='today']")
    WebElement dateExampleToday;
    @FindBy(xpath = "//div[@class='datepicker-days']/table/tfoot/tr/th[@class='clear']")
    WebElement dateExampleClear;
    @FindBy(xpath = "(//div[@class='panel-heading'])[2]")
    WebElement dateExampleHeading;

    //DATE RANGE EXAMPLE
    @FindBy(xpath = "(//div[@id='datepicker']/input)[1]")
    WebElement dateRangeStartDate;
    @FindBy(xpath = "(//div[@id='datepicker']/input)[2]")
    WebElement dateRangeEndDate;

    //BOOTSTRAP DATE PICKER
    public void bootstrapDateExample(){
        try{
            Actions a = new Actions(driver);
            a.click(dateChocolateMenu).build().perform();
            a.click(switchYear1).build().perform();
            a.click(switchYear2).build().perform();
            a.click(selectYear).build().perform();
            a.click(selectMonth).build().perform();
            a.click(selectDay1).build().perform();
            a.click(dateChocolateMenu).build().perform();
            a.click(dateExampleToday).build().perform();
            a.click(dateChocolateMenu).build().perform();
            a.click(dateExampleClear).build().perform();
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

    //BOOTSTRAP DATE RANGE
    public void bootstrapDateRangeExample(){
        Actions a = new Actions(driver);
        try{
            a.click(dateRangeStartDate).build().perform();
            a.click(switchYear1).build().perform();
            a.click(switchYear2).build().perform();
            a.click(selectYear).build().perform();
            a.click(selectMonth).build().perform();
            a.click(selectDay1).build().perform();
            a.click(dateRangeEndDate).build().perform();
            a.click(switchYear1).build().perform();
            a.click(switchYear2).build().perform();
            a.click(selectYear).build().perform();
            a.click(selectMonth).build().perform();
            a.click(selectDay2).build().perform();
            Assert.assertTrue(dateExampleHeading.isEnabled());
            a.click(dateExampleHeading).build().perform();
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }
}
