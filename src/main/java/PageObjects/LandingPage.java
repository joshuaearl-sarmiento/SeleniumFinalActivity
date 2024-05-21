package PageObjects;

import AbstractComponents.AbstractComponent;
import PageObjects.AlertsAndModalsObjects.BootstrapAlerts;
import PageObjects.AlertsAndModalsObjects.BootstrapModals;
import PageObjects.AlertsAndModalsObjects.WindowPopupModal;
import PageObjects.DatePickersObjects.DatePickers;
import PageObjects.InputFormObjects.*;
import PageObjects.ListBoxObjects.BootstrapListBox;
import PageObjects.ListBoxObjects.DataListFilter;
import PageObjects.ProgressBarAndSlidersObjects.BootstrapProgressBar;
import PageObjects.TableDemoObjects.TableSortAndSearch;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {

    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //PAGE FACTORY
    @FindBy(xpath = "(//li[@class='tree-branch'])[2]")
    WebElement inputForms; //INPUT FORMS LINK
    @FindBy(xpath = "(//li[@class='tree-branch'])[3]")
    WebElement datePickers; //DATE PICKERS LINK
    @FindBy(xpath="(//li[@class='tree-branch'])[4]")
    WebElement table; //TABLE LINK
    @FindBy(xpath = "(//li[@class='tree-branch'])[5]")
    WebElement progressBarsAndSliders; //PROGRESS BARS AND SLIDERS LINK
    @FindBy(xpath = "(//li[@class='tree-branch'])[6]")
    WebElement alertsAndModals; //ALERTS AND MODALS LINK
    @FindBy(xpath="(//li[@class='tree-branch'])[7]")
    WebElement listBox; //LIST BOX LINK

    public void goToHome(){
        driver.get("https://demo.seleniumeasy.com//");
        //Script to scroll website to table
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
    }

    //INPUT FORMS NAVIGATION -------------------------------------------------------------------------------------------------
    public SimpleFormDemo goToSimpleFormDemo(){
        Actions a = new Actions(driver);
        a.click(inputForms).build().perform();
        a.click(inputForms.findElements(By.tagName("a")).get(1)).build().perform();
        SimpleFormDemo simpleFormDemo = new SimpleFormDemo(driver);
        return simpleFormDemo;
    }
    public CheckBoxDemo goToCheckboxDemo() {
        Actions a = new Actions(driver);
        a.click(inputForms).build().perform();
        a.click(inputForms.findElements(By.tagName("a")).get(2)).build().perform();
        CheckBoxDemo checkBoxDemo = new CheckBoxDemo(driver);
        return checkBoxDemo;
    }
    public RadioButtonDemo goToRadioButtonsDemo() {
        Actions a = new Actions(driver);
        a.click(inputForms).build().perform();
        a.click(inputForms.findElements(By.tagName("a")).get(3)).build().perform();
        RadioButtonDemo radioButtonDemo = new RadioButtonDemo(driver);
        return radioButtonDemo;
    }
    public SelectDropdownsList goToSelectDropdownList() {
        Actions a = new Actions(driver);
        a.click(inputForms).build().perform();
        a.click(inputForms.findElements(By.tagName("a")).get(4)).build().perform();
        SelectDropdownsList selectDropdownsList = new SelectDropdownsList(driver);
        return selectDropdownsList;
    }
    public InputFormSubmit goToInputFormSubmit() {
        Actions a = new Actions(driver);
        a.click(inputForms).build().perform();
        a.click(inputForms.findElements(By.tagName("a")).get(5)).build().perform();
        InputFormSubmit inputFormSubmit = new InputFormSubmit(driver);
        return inputFormSubmit;
    }
    public AjaxFormSubmit goToAjaxFormSubmit() {
        Actions a = new Actions(driver);
        a.click(inputForms).build().perform();
        a.click(inputForms.findElements(By.tagName("a")).get(6)).build().perform();
        AjaxFormSubmit ajaxFormSubmit = new AjaxFormSubmit(driver);
        return ajaxFormSubmit;
    }
    public JquerySelectDropdown goToJquerySelectDropdown() {
        Actions a = new Actions(driver);
        a.click(inputForms).build().perform();
        a.click(inputForms.findElements(By.tagName("a")).get(7)).build().perform();
        JquerySelectDropdown jquerySelectDropdown = new JquerySelectDropdown(driver);
        return jquerySelectDropdown;
    }
    //DATE PICKERS NAVIGATION -------------------------------------------------------------------------------------------------
    public DatePickers goToDatePickersDemo() {
        Actions a = new Actions(driver);
        a.click(datePickers).build().perform();
        a.click(datePickers.findElements(By.tagName("a")).get(1)).build().perform();
        DatePickers datePickers = new DatePickers(driver);
        return datePickers;
    }
    //TABLE NAVIGATION -------------------------------------------------------------------------------------------------
    public TableSortAndSearch goToTableSortAndSearch() {
        Actions a = new Actions(driver);
        a.click(table).build().perform();
        a.click(table.findElements(By.tagName("a")).get(4)).build().perform();
        TableSortAndSearch tableSortAndSearch = new TableSortAndSearch(driver);
        return tableSortAndSearch;
    }
    //PROGRESS BAR AND SLIDERS NAVIGATION -------------------------------------------------------------------------------------------------
    public BootstrapProgressBar goToBootstrapProgressBar() {
        Actions a = new Actions(driver);
        a.click(progressBarsAndSliders).build().perform();
        a.click(progressBarsAndSliders.findElements(By.tagName("a")).get(2)).build().perform();
        BootstrapProgressBar bootstrapProgressBar = new BootstrapProgressBar(driver);
        return bootstrapProgressBar;
    }
    //ALERTS AND MODALS NAVIGATION -------------------------------------------------------------------------------------------------
    public BootstrapAlerts goToBootstrapAlerts() {
        Actions a = new Actions(driver);
        a.click(alertsAndModals).build().perform();
        a.click(alertsAndModals.findElements(By.tagName("a")).get(1)).build().perform();
        BootstrapAlerts bootstrapAlerts = new BootstrapAlerts(driver);
        return bootstrapAlerts;
    }
    public BootstrapModals goToBootstrapModals() {
        Actions a = new Actions(driver);
        a.click(alertsAndModals).build().perform();
        a.click(alertsAndModals.findElements(By.tagName("a")).get(2)).build().perform();
        BootstrapModals bootstrapModals = new BootstrapModals(driver);
        return bootstrapModals;
    }
    public WindowPopupModal goToWindowPopupModal() {
        Actions a = new Actions(driver);
        a.click(alertsAndModals).build().perform();
        a.click(alertsAndModals.findElements(By.tagName("a")).get(3)).build().perform();
        WindowPopupModal windowPopupModal = new WindowPopupModal(driver);
        return windowPopupModal;
    }
    //LIST BOX NAVIGATION -------------------------------------------------------------------------------------------------
    public BootstrapListBox goToBootstrapListBox() {
        Actions a = new Actions(driver);
        a.click(listBox).build().perform();
        a.click(listBox.findElements(By.tagName("a")).get(1)).build().perform();
        BootstrapListBox bootstrapListBox = new BootstrapListBox(driver);
        return bootstrapListBox;
    }
    public DataListFilter goToDataListFilter() {
        Actions a = new Actions(driver);
        a.click(listBox).build().perform();
        a.click(listBox.findElements(By.tagName("a")).get(3)).build().perform();
        DataListFilter dataListFilter = new DataListFilter(driver);
        return dataListFilter;
    }
}
