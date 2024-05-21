package PageObjects.AlertsAndModalsObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.Set;

public class BootstrapModals extends AbstractComponent {

    WebDriver driver;
    public BootstrapModals(WebDriver driver){
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //BOOTSTRAP MODALS
    @FindBy(xpath = "(//a[@data-toggle='modal'])[1]")
    WebElement singleModalLaunchModalBtn;
    @FindBy(xpath = "(//a[@data-toggle='modal'])[2]")
    WebElement multipleModalLaunchModalBtn1;
    @FindBy(xpath = "(//a[@data-toggle='modal'])[3]")
    WebElement multipleModalLaunchModalBtn2;
    //SAVE CHANGES BUTTONS
    @FindBy(xpath = "(//a[@onclick='history.go(0)'])[1]")
    WebElement modalTitleSaveChanges;
    @FindBy(xpath = "(//a[@onclick='history.go(0)'])[2]")
    WebElement firstModalSaveChanges;
    @FindBy(xpath = "(//a[@onclick='history.go(0)'])[3]")
    WebElement modal2SaveChanges;
    //CLOSE BUTTONS
    @FindBy(xpath = "(//a[@data-dismiss='modal'])[1]")
    WebElement modalTitleClose;
    @FindBy(xpath = "(//a[@data-dismiss='modal'])[2]")
    WebElement firstModalClose;
    @FindBy(xpath = "(//a[@data-dismiss='modal'])[3]")
    WebElement modal2Close;
    //MODAL HEADERS
    @FindBy(xpath = "(//h4[@class='modal-title'])[1]")
    WebElement modalTitleHeader;
    @FindBy(xpath = "(//h4[@class='modal-title'])[2]")
    WebElement firstModalHeader;
    @FindBy(xpath = "(//h4[@class='modal-title'])[3]")
    WebElement modal2Header;
    //MODAL BODY
    @FindBy(xpath = "(//div[@class='modal-body'])[1]")
    WebElement modalTitleBody;
    @FindBy(xpath = "(//div[@class='modal-body'])[2]")
    WebElement firstModalBody;
    @FindBy(xpath = "(//div[@class='modal-body'])[3]")
    WebElement modal2Body;

    //BOOTSTRAP MODALS
    public void bootstrapModalsSingleModal(){
        try{
            Actions a = new Actions(driver);
            //SINGLE MODAL EXAMPLE
            a.click(singleModalLaunchModalBtn).build().perform(); //LAUNCH MODAL
            waitForWebElementToAppear(modalTitleHeader);
            Assert.assertTrue(modalTitleBody.getText().contains("This is the place where the content for the modal dialog displays"));
            a.click(modalTitleClose).build().perform(); //CLOSE MODAL
            waitForWebElementToDisappear(modalTitleHeader);
            a.click(singleModalLaunchModalBtn).build().perform(); //LAUNCH MODAL
            waitForWebElementToAppear(modalTitleHeader);
            a.click(modalTitleSaveChanges).build().perform(); //SAVE CHANGES
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

    public void bootstrapModalsMultipleModal(){
        try{
            Actions a = new Actions(driver);
            //FIRST MODAL
            a.click(multipleModalLaunchModalBtn1).build().perform(); //LAUNCH MODAL
            waitForWebElementToAppear(firstModalHeader);
            Assert.assertTrue(firstModalBody.getText().contains("Click launch modal button to launch second modal"));
            a.click(firstModalClose).build().perform(); //CLOSE MODAL
            waitForWebElementToDisappear(firstModalHeader);
            a.click(multipleModalLaunchModalBtn1).build().perform(); //LAUNCH MODAL
            waitForWebElementToAppear(firstModalHeader);
            a.click(firstModalSaveChanges).build().perform(); //SAVE CHANGES

            //MODAL 2
            a.click(multipleModalLaunchModalBtn1).build().perform(); //LAUNCH MODAL
            waitForWebElementToAppear(firstModalHeader);
            a.click(multipleModalLaunchModalBtn2).build().perform(); //LAUNCH MODAL
            waitForWebElementToAppear(modal2Header);
            Assert.assertTrue(modal2Body.getText().contains("This is the place where the content for the modal dialog displays"));
            a.click(modal2Close).build().perform(); //CLOSE 2ND MODAL
            waitForWebElementToDisappear(modal2Header);
            a.click(firstModalClose).build().perform(); //CLOSE 1ST MODAL
            waitForWebElementToDisappear(firstModalHeader);
            a.click(multipleModalLaunchModalBtn1).build().perform(); //LAUNCH MODAL
            waitForWebElementToAppear(firstModalHeader);
            a.click(multipleModalLaunchModalBtn2).build().perform(); //LAUNCH MODAL
            waitForWebElementToAppear(modal2Header);
            a.click(modal2SaveChanges).build().perform(); //SAVE CHANGES
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

}
