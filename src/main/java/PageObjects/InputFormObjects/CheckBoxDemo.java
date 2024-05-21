package PageObjects.InputFormObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class CheckBoxDemo extends AbstractComponent {

    WebDriver driver;

    public CheckBoxDemo(WebDriver driver) {
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //CHECKBOX DEMO
    @FindBy(id = "isAgeSelected")
    WebElement singleCheckbox;
    @FindBy(id = "txtAge")
    WebElement successText;
    @FindBy(xpath = "(//input[@class='cb1-element'])[1]")
    WebElement checkbox1;
    @FindBy(id = "check1")
    WebElement checkBtn;

    //CHECKBOX DEMO -------------------------------------------------------------------------------------------------
    public void singleCheckBoxDemo() {
        try{
            Actions a = new Actions(driver);
            a.click(singleCheckbox).build().perform();
            Assert.assertTrue(successText.getText().equals("Success - Check box is checked"));
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

    public void multipleCheckBoxDemo() {
        try{
            Actions a = new Actions(driver);
            a.click(checkbox1).build().perform();
            a.click(checkBtn).build().perform();
            Assert.assertTrue(checkBtn.getAttribute("value").equals("Uncheck All"));
            a.click(checkbox1).build().perform();
            Assert.assertTrue(checkBtn.getAttribute("value").equals("Check All"));
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

}
