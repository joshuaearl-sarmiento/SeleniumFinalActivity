package PageObjects.TableDemoObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TableSortAndSearch extends AbstractComponent {

    WebDriver driver;
    public TableSortAndSearch(WebDriver driver){
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //TABLE SORT AND SEARCH
    @FindBy(xpath = "(//thead/tr/th[contains(@class, 'sorting')])[1]")
    WebElement sortName;
    @FindBy(xpath = "(//thead/tr/th[contains(@class, 'sorting')])[2]")
    WebElement sortPosition;
    @FindBy(xpath = "(//thead/tr/th[contains(@class, 'sorting')])[3]")
    WebElement sortOffice;
    @FindBy(xpath = "(//thead/tr/th[contains(@class, 'sorting')])[4]")
    WebElement sortAge;
    @FindBy(xpath = "(//thead/tr/th[contains(@class, 'sorting')])[5]")
    WebElement sortStartDate;
    @FindBy(xpath = "(//thead/tr/th[contains(@class, 'sorting')])[6]")
    WebElement sortSalary;
    @FindBy(xpath = "//input[@type='search']")
    WebElement searchInputBox;
    @FindBy(id = "example_previous")
    WebElement paginationPrevious;
    @FindBy(id = "example_next")
    WebElement paginationNext;

    //TABLE SORT AND SEARCH
    public void tableSortAndSearch(String searchInput){
        try{
            Actions a = new Actions(driver);
            a.doubleClick(sortName).build().perform();
            a.doubleClick(sortPosition).build().perform();
            a.doubleClick(sortOffice).build().perform();
            a.doubleClick(sortOffice).build().perform();
            a.doubleClick(sortAge).build().perform();
            a.doubleClick(sortSalary).build().perform();
            a.click(paginationNext).build().perform();
            a.click(paginationNext).build().perform();
            a.click(paginationPrevious).build().perform();
            a.click(paginationPrevious).build().perform();
            a.sendKeys(searchInputBox, searchInput).build().perform();
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }
}
