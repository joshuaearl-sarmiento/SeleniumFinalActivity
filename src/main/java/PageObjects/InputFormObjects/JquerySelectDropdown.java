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

public class JquerySelectDropdown extends AbstractComponent {

    WebDriver driver;

    public JquerySelectDropdown(WebDriver driver) {
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //JQUERY SELECT DROPDOWN
    @FindBy(id = "select2-country-container")
    WebElement singleSelectDropdown;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[2]")
    WebElement singleSelectDropdownSearchBox;
    @FindBy(css = "li[class*='select2-results__option']")
    List<WebElement> jqueryListResults;
    @FindBy(xpath = "(//input[@class='select2-search__field'])[1]")
    WebElement multiSelectSearchBox;
    @FindBy(xpath = "(//span[@class='selection'])[3]")
    WebElement dropdownWithDisabledBox;
    @FindBy(id = "files")
    WebElement dropdownWithCategoryBox;
    @FindBy(xpath = "//ul[contains(@class, 'select2-selection__rendered')]")
    WebElement multiSelectSearchBoxValues;

    //JQUERY SELECT DROPDOWN -------------------------------------------------------------------------------------------------
    public void jquerySearchAndSelectCountry(String searchCountry, String setCountry){
        try{
            Actions a = new Actions(driver);
            a.click(singleSelectDropdown).build().perform();
            a.sendKeys(singleSelectDropdownSearchBox, searchCountry).build().perform();
            for (WebElement option : jqueryListResults) {
                if (option.getText().equalsIgnoreCase(setCountry)) {
                    a.click(option).build().perform();
                    break;
                }
            }
            Assert.assertTrue(singleSelectDropdown.getAttribute("title").contains(setCountry));
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

    public void jquerySelectMultipleValues(String searchState1, String searchState2, String setState1, String setState2){
        try{
            Actions a = new Actions(driver);
            a.click(multiSelectSearchBox).build().perform();
            a.sendKeys(multiSelectSearchBox, searchState1).build().perform();
            for (WebElement option : jqueryListResults) {
                if (option.getText().equalsIgnoreCase(setState1)) {
                    a.click(option).build().perform();
                    break;
                }
            }
            a.sendKeys(multiSelectSearchBox, searchState2).build().perform();
            for (WebElement option : jqueryListResults) {
                if (option.getText().equalsIgnoreCase(setState2)) {
                    a.click(option).build().perform();
                    break;
                }
            }
            Assert.assertTrue(multiSelectSearchBoxValues.getAttribute("textContent").contains(setState1));
            Assert.assertTrue(multiSelectSearchBoxValues.getAttribute("textContent").contains(setState2));
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

    public void jqueryDropdownWithDisabledValues(String jqueryOption){
        try{
            Actions a = new Actions(driver);
            a.click(dropdownWithDisabledBox).build().perform();

            for (WebElement jqueryListResult : jqueryListResults) {
                if (jqueryListResult.getText().equalsIgnoreCase(jqueryOption)) {
                    a.click(jqueryListResult).build().perform();
                    break;
                }
            }
            Assert.assertTrue(dropdownWithDisabledBox.getText().equalsIgnoreCase(jqueryOption));
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

    public void jqueryDropdownWithCategoryRelatedOptions(){
        try{
            Actions a = new Actions(driver);
            Select dropdown = new Select(dropdownWithCategoryBox);
            List<WebElement> dropdownList = dropdown.getOptions();
            for (int i = 0; i < dropdownList.size(); i++) {
                dropdown.selectByVisibleText(dropdownList.get(i).getText());
            }
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }
}
