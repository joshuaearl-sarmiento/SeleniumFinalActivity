package Tests;

import PageObjects.InputFormObjects.*;
import TestComponents.BaseTest;
import TestComponents.Retry;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class ErrorValidationTest extends BaseTest {

    @Test(dataProvider = "getData", groups = {"ErrorHandling"}, retryAnalyzer = Retry.class)
    public void ajaxFormSubmitErrorTest(HashMap<String,String> input){
        //AJAX FORM SUBMIT
        try{
            AjaxFormSubmit ajaxFormSubmit = landingPage.goToAjaxFormSubmit();
            ajaxFormSubmit.ajaxFormSubmit(input.get("firstName"), input.get("lastName"), input.get("projectDescription"));
            String ajaxConfirm = ajaxFormSubmit.getAjaxConfirmText();
            Assert.assertEquals("Form submitted Successfully!", ajaxConfirm);
        }catch (AssertionError e){
            System.out.println("Error Received: " + e.getMessage());
            throw e;
        }
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "/src/test/java/Data/InputFormData.json");
        return new Object[][] {{data.get(0)}};
    }
}
