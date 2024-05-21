package PageObjects.ProgressBarAndSlidersObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class BootstrapProgressBar extends AbstractComponent {

    WebDriver driver;
    public BootstrapProgressBar(WebDriver driver){
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //BOOTSTRAP PROGRESS BAR
    @FindBy(id = "cricle-btn")
    WebElement downloadBtn;
    @FindBy(className = "percenttext")
    WebElement percentText;
    @FindBy(xpath = "//div[contains(text(),'100')]")
    WebElement downloadComplete;

    //BOOTSTRAP PROGRESS BAR
    public void bootstrapProgressBar(){
        try{
            Actions a = new Actions(driver);
            a.click(downloadBtn).build().perform();
            waitForWebElementToAppear(downloadComplete);
            System.out.println(percentText.getText());
            Assert.assertTrue(percentText.getText().equals("100%"));
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

}
