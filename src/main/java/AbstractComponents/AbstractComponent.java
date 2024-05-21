package AbstractComponents;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {

    WebDriver driver;
    public AbstractComponent(WebDriver driver) {
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void waitForWebElementToDisappear(WebElement ele){
        //Initialize wait element invisibility
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Wait until element is invisible
        wait.until(ExpectedConditions.invisibilityOf(ele));
    }

    public void waitForWebElementToAppear(WebElement findBy){
        //Initialize wait for landing page visibility
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        //Wait until products are visible
        wait.until(ExpectedConditions.visibilityOf(findBy));
    }


}
