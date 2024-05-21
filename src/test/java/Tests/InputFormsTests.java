package Tests;

import PageObjects.InputFormObjects.*;
import Resources.ExcelUtils;
import TestComponents.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;


public class InputFormsTests extends BaseTest {

    @Test(dataProvider = "getJsonData",priority = 1)
    public void simpleFormsTest(HashMap<String,String> input){
        //SIMPLE FORMS
        SimpleFormDemo simpleFormDemo = landingPage.goToSimpleFormDemo();
        simpleFormDemo.singleInputField(input.get("inputFieldText"));
        simpleFormDemo.twoInputField(Integer.parseInt(input.get("valueA")), Integer.parseInt(input.get("valueB")));
    }

    @Test(priority = 2)
    public void checkboxDemoTest(){
        //CHECKBOX DEMO
        CheckBoxDemo checkBoxDemo = landingPage.goToCheckboxDemo();
        checkBoxDemo.singleCheckBoxDemo();
        checkBoxDemo.multipleCheckBoxDemo();
    }

    @Test(priority = 3)
    public void radioButtonDemoTest(){
        //RADIO BUTTONS DEMO
        RadioButtonDemo radioButtonDemo = landingPage.goToRadioButtonsDemo();
        radioButtonDemo.radioButtonDemo();
        radioButtonDemo.groupRadioButtonsDemo();
    }

    @Test(priority = 4)
    public void selectDropdownsListTest(){
        //SELECT DROPDOWNS LIST
        SelectDropdownsList selectDropdownsList = landingPage.goToSelectDropdownList();
        selectDropdownsList.selectListDemo();
        selectDropdownsList.multiSelectListDemo();
    }

    @Test(dataProvider = "getJsonData", priority = 5)
    public void inputFormSubmitTest(HashMap<String,String> input){
        //INPUT FORM SUBMIT
        InputFormSubmit inputFormSubmit = landingPage.goToInputFormSubmit();
        inputFormSubmit.inputFormSubmit(input.get("firstName"), input.get("lastName"), input.get("email"),
                input.get("phoneNo"), input.get("address"), input.get("city"), input.get("zipCode"),
                input.get("website"), input.get("projectDescription"));
    }

    @Test(dataProvider = "getJsonData", priority = 6)
    public void ajaxFormSubmitTest(HashMap<String,String> input){
        //AJAX FORM SUBMIT
        AjaxFormSubmit ajaxFormSubmit = landingPage.goToAjaxFormSubmit();
        ajaxFormSubmit.ajaxFormSubmit(input.get("firstName"), input.get("lastName"), input.get("projectDescription"));
    }

    @Test(dataProvider = "getExcelData", priority = 7)
    public void jquerySelectDropdownTest(String searchCountry, String setCountry, String searchState1, String searchState2,
                                         String setState1, String setState2, String jqueryOption){
        //JQUERY SELECT DROPDOWN
        JquerySelectDropdown jquerySelectDropdown = landingPage.goToJquerySelectDropdown();
        jquerySelectDropdown.jquerySearchAndSelectCountry(searchCountry, setCountry);
        jquerySelectDropdown.jquerySelectMultipleValues(searchState1, searchState2, setState1, setState2);
        jquerySelectDropdown.jqueryDropdownWithDisabledValues(jqueryOption);
        jquerySelectDropdown.jqueryDropdownWithCategoryRelatedOptions();
    }

//    ----------------------------------------------------------------------------------------------------

    @DataProvider(name = "getJsonData")
    public Object[][] getJsonData() throws IOException {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "/src/test/java/Data/InputFormData.json");
        return new Object[][] {{data.get(0)}};
    }

    @DataProvider(name = "getExcelData")
    public Object[][] getExcelData(Method method) throws IOException {
        String sheetName=""; // No need to initialize

        // Determine the Excel sheet name based on the test method's name
        if (method.getName().equals("jquerySelectDropdownTest")) {
            sheetName = "jqueryData";
        }
//        else if (method.getName().equals("methodName")) {
//            sheetName = "sheetName";

//        }// Add more conditions for other test methods as needed
        return ExcelUtils.readExcel(System.getProperty("user.dir")
                + "/src/test/java/Data/InputFormData.json", sheetName);
    }

}
