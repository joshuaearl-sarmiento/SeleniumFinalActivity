package PageObjects.InputFormObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AjaxFormSubmit extends AbstractComponent {

    WebDriver driver;

    //AJAX FORM SUBMIT
    String firstName = "Shoyou";
    String lastName = "Hinata";
    String projectDescription = "Volleyball Nationals";

    //JQUERY SEARCH DEMO
    String country = "Jap";

    public AjaxFormSubmit(WebDriver driver) {
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //AJAX FORM SUBMIT
    @FindBy(id = "title")
    WebElement ajaxName;
    @FindBy(id = "description")
    WebElement ajaxDescription;
    @FindBy(id = "btn-submit")
    WebElement ajaxSubmitBtn;
    @FindBy(id = "submit-control")
    WebElement ajaxConfirm;
    @FindBy(xpath = "img[@src='LoaderIcon.gif']")
    WebElement ajaxLoadingImg;

    //AJAX FORM SUBMIT -------------------------------------------------------------------------------------------------
    public void ajaxFormSubmit(String firstName, String lastName, String projectDescription) {
        try {
            Actions a = new Actions(driver);
            a.sendKeys(ajaxName, firstName + " " + lastName).build().perform();
            a.sendKeys(ajaxDescription, projectDescription).build().perform();
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,500)");
            a.click(ajaxSubmitBtn).build().perform();
            waitForWebElementToDisappear(ajaxLoadingImg);
            Assert.assertTrue(ajaxConfirm.getText().equals("Form submited Successfully!"));
        } catch (Exception e) {
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

    public String getAjaxConfirmText() {
        waitForWebElementToAppear(ajaxConfirm);
        return ajaxConfirm.getText();
    }
}
