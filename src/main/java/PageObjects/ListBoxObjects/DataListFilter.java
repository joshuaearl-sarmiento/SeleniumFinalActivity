package PageObjects.ListBoxObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class DataListFilter extends AbstractComponent {

    WebDriver driver;
    public DataListFilter(WebDriver driver){
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //DATA LIST FILTER
    @FindBy(id = "input-search")
    WebElement dataListSearchBox;
    @FindBy(css = "[style*='display: block;']")
    List<WebElement> visibleItems;

    //DATA LIST FILTER
    public void dataListFilter(String searchInput){
        try{
            Actions a = new Actions(driver);
            a.sendKeys(dataListSearchBox, searchInput).build().perform();
            for (WebElement webElement : visibleItems) {
                Assert.assertTrue(webElement.getText().toLowerCase().contains(searchInput.toLowerCase())); //Shift all text to lowercase for comparison
            }
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

}
