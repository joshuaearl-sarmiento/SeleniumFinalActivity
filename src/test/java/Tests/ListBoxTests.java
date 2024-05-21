package Tests;

import PageObjects.ListBoxObjects.BootstrapListBox;
import PageObjects.ListBoxObjects.DataListFilter;
import TestComponents.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class ListBoxTests extends BaseTest {

    @Test(priority = 1)
    public void bootstrapListBox(){
        //BOOTSTRAP LIST BOX
        BootstrapListBox bootstrapListBox = landingPage.goToBootstrapListBox();
        bootstrapListBox.bootstrapListBox();
    }

    @Test(dataProvider = "getData", priority = 2)
    public void dataListFilterTest(HashMap<String,String> input){
        //DATA LIST FILTER
        DataListFilter dataListFilter = landingPage.goToDataListFilter();
        dataListFilter.dataListFilter(input.get("searchInput"));
    }

//    ----------------------------------------------------------------------------------------------------

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "/src/test/java/Data/ListBoxData.json");
        return new Object[][] {{data.get(0)}};
    }

}
