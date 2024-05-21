package PageObjects.ListBoxObjects;

import AbstractComponents.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class BootstrapListBox extends AbstractComponent {

    WebDriver driver;
    public BootstrapListBox(WebDriver driver){
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //BOOTSTRAP LIST BOX
    @FindBy(xpath = "(//ul[@class='list-group'])[1]/li")
    List<WebElement> leftList;
    @FindBy(xpath = "(//ul[@class='list-group'])[2]/li")
    List<WebElement> rightList;
    @FindBy(xpath = "(//a/i[contains(@class, 'glyphicon')])[1]")
    WebElement leftSelectAll;
    @FindBy(xpath = "(//a/i[contains(@class, 'glyphicon')])[2]")
    WebElement rightSelectAll;
    @FindBy(xpath = "//button[contains(@class, 'move-right')]")
    WebElement moveRightBtn;
    @FindBy(xpath = "//button[contains(@class, 'move-left')]")
    WebElement moveLeftBtn;

    //BOOTSTRAP LIST BOX
    public void bootstrapListBox(){
        try{
            Actions a = new Actions(driver);
            List<String> originalRightList = rightList.stream().map(s -> s.getText()).collect(Collectors.toList());

            //Select all items on the LEFT LIST
            for (WebElement webElement : leftList) {
                webElement.click();
            }
            a.click(moveRightBtn).build().perform(); //Move right

            //Select all items on the RIGHT LIST
            for (WebElement webElement : rightList) {
                webElement.click();
            }
            a.click(moveLeftBtn).build().perform(); //Move left
            a.click(leftSelectAll).build().perform(); //Select ALL on LEFT LIST
            a.click(moveRightBtn).build().perform(); //Move right
            a.click(rightSelectAll).build().perform(); //Select ALL on RIGHT LIST
            a.click(moveLeftBtn).build().perform(); //Move left
            List<String> currentLeftList = leftList.stream().map(s -> s.getText()).collect(Collectors.toList());

            //Check if all contents on the original list are on the new list
            for(int i=0; i<originalRightList.size(); i++){
                System.out.println(originalRightList.get(i));
                Assert.assertTrue(currentLeftList.contains(originalRightList.get(i)));
            }
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

}
