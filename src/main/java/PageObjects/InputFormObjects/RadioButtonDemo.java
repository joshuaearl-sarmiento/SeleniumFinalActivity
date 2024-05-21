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

public class RadioButtonDemo extends AbstractComponent {

    WebDriver driver;

    public RadioButtonDemo(WebDriver driver) {
        super(driver);
        //Initialization
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //RADIO BUTTONS DEMO
    @FindBy(xpath = "(//input[@value='Male'])[1]")
    WebElement radioMale1; //Male Option 1
    @FindBy(xpath = "(//input[@value='Female'])[1]")
    WebElement radioFemale1; //Female Option 1
    @FindBy(id = "buttoncheck")
    WebElement radioBtnCheck1; //"Get Checked Value"
    @FindBy(css = "p[class='radiobutton']")
    WebElement radioDisplayText1; //Display Text after "Get Checked Value" button is clicked
    @FindBy(xpath = "(//input[@value='Male'])[2]")
    WebElement radioMale2; //Male Option 2
    @FindBy(xpath = "(//input[@value='Female'])[2]")
    WebElement radioFemale2; //Female Option 2
    @FindBy(xpath = "(//button[@type='button'])[3]")
    WebElement radioBtnCheck2; //"Get Values"
    @FindBy(xpath = "(//input[@name='ageGroup'])[1]")
    WebElement radioAge1; //Ages "0-5"
    @FindBy(xpath = "(//input[@name='ageGroup'])[2]")
    WebElement radioAge2; //Ages "5-15"
    @FindBy(xpath = "(//input[@name='ageGroup'])[3]")
    WebElement radioAge3; //Ages "15-50"
    @FindBy(css = "p[class='groupradiobutton']")
    WebElement radioDisplayText2; //Display Text after "Get Values" button is clicked

    //RADIO BUTTONS DEMO -------------------------------------------------------------------------------------------------
    public void radioButtonDemo() {
        try{
            Actions a = new Actions(driver);
            a.click(radioMale1).build().perform();
            a.click(radioBtnCheck1).build().perform();
            Assert.assertTrue(radioDisplayText1.getText().equalsIgnoreCase("Radio button 'Male' is checked"));
            a.click(radioFemale1).build().perform();
            a.click(radioBtnCheck1).build().perform();
            Assert.assertTrue(radioDisplayText1.getText().equalsIgnoreCase("Radio button 'Female' is checked"));
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

    public void groupRadioButtonsDemo() {
        try{
            Actions a = new Actions(driver);
            a.click(radioMale2).build().perform(); //Select Male
            a.click(radioAge1).build().perform(); //Select Age 0-5
            a.click(radioBtnCheck2).build().perform();
            Assert.assertTrue(radioDisplayText2.getText().contains(radioMale2.getText() + radioAge1.getText()));
            a.click(radioFemale2).build().perform(); //Select Female
            a.click(radioAge2).build().perform(); //Select Age 5-15
            a.click(radioBtnCheck2).build().perform();
            Assert.assertTrue(radioDisplayText2.getText().contains(radioFemale2.getText() + radioAge2.getText()));
            a.click(radioAge3).build().perform(); //Select Age 15-50
            a.click(radioBtnCheck2).build().perform();
            Assert.assertTrue(radioDisplayText2.getText().contains(radioFemale2.getText() + radioAge3.getText()));
        }catch (Exception e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

}
