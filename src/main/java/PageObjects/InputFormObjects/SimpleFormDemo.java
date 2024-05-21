package PageObjects.InputFormObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class SimpleFormDemo extends AbstractComponent {

    WebDriver driver;

    public SimpleFormDemo(WebDriver driver) {
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //SIMPLE FORM DEMO
    @FindBy(id = "user-message")
    WebElement enterMessage;
    @FindBy(id = "display")
    WebElement displayText;
    @FindBy(id = "value1")
    WebElement enterValueA;
    @FindBy(id = "value2")
    WebElement enterValueB;
    @FindBy(css = ".btn:nth-child(2)")
    WebElement showMessageBtn;
    @FindBy(css = ".btn:nth-child(3)")
    WebElement getTotalBtn;
    @FindBy(id = "displayvalue")
    WebElement displayValue;

    //SIMPLE FORM DEMO -------------------------------------------------------------------------------------------------
    public void singleInputField(String message) {
        try{
            Actions a = new Actions(driver);
            a.sendKeys(enterMessage, message).build().perform();
            a.click(showMessageBtn).build().perform();
            Assert.assertTrue(displayText.getText().contains(message));
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

    public void twoInputField(int valueA, int valueB) {
        try{
            Actions a = new Actions(driver);
            a.sendKeys(enterValueA, Integer.toString(valueA)).build().perform();
            a.sendKeys(enterValueB, Integer.toString(valueB)).build().perform();
            a.click(getTotalBtn).build().perform();
            Assert.assertTrue(displayValue.getText().equals(Integer.toString(valueA + valueB)));
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

}
