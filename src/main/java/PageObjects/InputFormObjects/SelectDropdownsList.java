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

public class SelectDropdownsList extends AbstractComponent {

    WebDriver driver;

    public SelectDropdownsList(WebDriver driver) {
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //SELECT DROPDOWNS LIST
    @FindBy(id = "select-demo")
    WebElement staticDropdown;
    @FindBy(css = "p[class='selected-value']")
    WebElement selectListDisplay;
    @FindBy(xpath = "//select[@name='States']/option")
    List<WebElement> statesList;
    @FindBy(id = "printMe")
    WebElement firstSelectedBtn;
    @FindBy(css = "p[class='getall-selected']")
    WebElement statesDisplay;
    @FindBy(id = "multi-select")
    WebElement multiSelectBox;

    //SELECT DROPDOWNS LIST -------------------------------------------------------------------------------------------------
    public void selectListDemo() {
        try{
            Select dropdown = new Select(staticDropdown);
            List<WebElement> dropdownList = dropdown.getOptions();
            for (int i = 1; i < dropdownList.size(); i++) {
                dropdown.selectByIndex(i);
                Assert.assertTrue(selectListDisplay.getText().contains(dropdown.getFirstSelectedOption().getText()));
            }
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

    public void multiSelectListDemo() {
        try{
            Actions a = new Actions(driver);
            a.click(multiSelectBox).build().perform();
            for (WebElement webElement : statesList) {
                a.click(webElement).build().perform();
                a.click(firstSelectedBtn).build().perform();
                Assert.assertTrue(statesDisplay.getText().contains(webElement.getText()));
            }
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

}
