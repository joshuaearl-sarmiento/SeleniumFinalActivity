package SampleTests;

import Resources.ExcelUtils;
import TestComponents.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;


public class SampleInputFormCase extends BaseTest {

//    @Test(dataProvider = "testdata")
//    public void testInputForm(String firstName){
//        //INPUT FORM SUBMIT
//        InputFormSubmit inputFormSubmit = landingPage.goToInputFormSubmit();
//        inputFormSubmit.inputFormSubmit(firstName);
//    }

    @DataProvider(name = "testdata")
    public Object[][] testData(Method method) throws IOException {
        String sheetName=""; // No need to initialize

        // Determine the Excel sheet name based on the test method's name
        if (method.getName().equals("testInputForm")) {
            sheetName = "Sheet4";
        }
//        else if (method.getName().equals("methodName")) {
//            sheetName = "sheetName";
//        }// Add more conditions for other test methods as needed

        return ExcelUtils.readExcel("/Users/joshuaearlsarmiento/Documents/demodata.xlsx", sheetName);
    }
}
