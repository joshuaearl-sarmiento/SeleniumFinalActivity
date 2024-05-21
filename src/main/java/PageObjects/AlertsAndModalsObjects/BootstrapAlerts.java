package PageObjects.AlertsAndModalsObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Set;

public class BootstrapAlerts extends AbstractComponent {

    WebDriver driver;
    public BootstrapAlerts(WebDriver driver){
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //SUCCESS BUTTON
    @FindBy(id = "autoclosable-btn-success")
    WebElement autoCloseSuccessAlertBtn;
    @FindBy(id = "normal-btn-success")
    WebElement normalSuccessAlertBtn;
    //WARNING BUTTON
    @FindBy(id = "autoclosable-btn-warning")
    WebElement autoCloseWarningAlertBtn;
    @FindBy(id = "normal-btn-warning")
    WebElement normalWarningAlertBtn;
    //DANGER BUTTON
    @FindBy(id = "autoclosable-btn-danger")
    WebElement autoCloseDangerAlertBtn;
    @FindBy(id = "normal-btn-danger")
    WebElement normalDangerAlertBtn;
    //INFO BUTTON
    @FindBy(id = "autoclosable-btn-info")
    WebElement autoCloseInfoAlertBtn;
    @FindBy(id = "normal-btn-info")
    WebElement normalInfoAlertBtn;
    //CLOSE ALERTS
    @FindBy(xpath = "(//button[@class='close'])[1]")
    WebElement successAlertClose;
    @FindBy(xpath = "(//button[@class='close'])[2]")
    WebElement warningAlertClose;
    @FindBy(xpath = "(//button[@class='close'])[3]")
    WebElement dangerAlertClose;
    @FindBy(xpath = "(//button[@class='close'])[4]")
    WebElement infoAlertClose;
    //AUTOCLOSE ALERTS' WEBELEMENT
    @FindBy(css = "[class*='alert-autocloseable-success']")
    WebElement autoCloseSuccessAlert;
    @FindBy(css = "[class*='alert-autocloseable-warning']")
    WebElement autoCloseWarningAlert;
    @FindBy(css = "[class*='alert-autocloseable-danger']")
    WebElement autoCloseDangerAlert;
    @FindBy(css = "[class*='alert-autocloseable-info']")
    WebElement autoCloseInfoAlert;
    //NORMAL ALERTS' WEBELEMENT
    @FindBy(css = "[class*='alert-normal-success']")
    WebElement normalSuccessAlert;
    @FindBy(css = "[class*='alert-normal-warning']")
    WebElement normalWarningAlert;
    @FindBy(css = "[class*='alert-normal-danger']")
    WebElement normalDangerAlert;
    @FindBy(css = "[class*='alert-normal-info']")
    WebElement normalInfoAlert;

    //BOOTSTRAP ALERTS
    public void bootstrapAlerts(){
        try{
            Actions a = new Actions(driver);
            //SUCCESS ALERT
            a.click(autoCloseSuccessAlertBtn).build().perform();
            System.out.println(autoCloseSuccessAlert.getText());
                Assert.assertTrue(autoCloseSuccessAlert.getText().contains("I'm an autocloseable success message"));
            a.click(normalSuccessAlertBtn).build().perform();
            System.out.println(normalSuccessAlert.getText());
                Assert.assertTrue(normalSuccessAlert.getText().contains("I'm a normal success message"));
                waitForWebElementToDisappear(autoCloseSuccessAlert);
            a.click(successAlertClose).build().perform();
            //WARNING ALERT
            a.click(autoCloseWarningAlertBtn).build().perform();
                Assert.assertTrue(autoCloseWarningAlert.getText().contains("I'm an autocloseable warning message"));
            a.click(normalWarningAlertBtn).build().perform();
                Assert.assertTrue(normalWarningAlert.getText().contains("I'm a normal warning message"));
                waitForWebElementToDisappear(autoCloseWarningAlert);
            a.click(warningAlertClose).build().perform();
            //DANGER ALERT
            a.click(autoCloseDangerAlertBtn).build().perform();
                Assert.assertTrue(autoCloseDangerAlert.getText().contains("I'm an autocloseable danger message"));
            a.click(normalDangerAlertBtn).build().perform();
                Assert.assertTrue(normalDangerAlert.getText().contains("I'm a normal danger message"));
                waitForWebElementToDisappear(autoCloseDangerAlert);
            a.click(dangerAlertClose).build().perform();
            //INFO ALERT
            a.click(autoCloseInfoAlertBtn).build().perform();
                Assert.assertTrue(autoCloseInfoAlert.getText().contains("I'm an autocloseable info message"));
            a.click(normalInfoAlertBtn).build().perform();
                Assert.assertTrue(normalInfoAlert.getText().contains("I'm a normal info message"));
                waitForWebElementToDisappear(autoCloseInfoAlert);
            a.click(infoAlertClose).build().perform();
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

}
