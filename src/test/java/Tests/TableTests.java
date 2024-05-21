package Tests;

import PageObjects.AlertsAndModalsObjects.BootstrapAlerts;
import PageObjects.AlertsAndModalsObjects.BootstrapModals;
import PageObjects.AlertsAndModalsObjects.WindowPopupModal;
import PageObjects.ListBoxObjects.BootstrapListBox;
import PageObjects.ListBoxObjects.DataListFilter;
import PageObjects.ProgressBarAndSlidersObjects.BootstrapProgressBar;
import PageObjects.TableDemoObjects.TableSortAndSearch;
import TestComponents.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;


public class TableTests extends BaseTest {

    @Test(dataProvider = "getData")
    public void tableTest(HashMap<String,String> input){
        //TABLE
        TableSortAndSearch tableSortAndSearch = landingPage.goToTableSortAndSearch();
        tableSortAndSearch.tableSortAndSearch(input.get("searchInput"));
    }

//    ----------------------------------------------------------------------------------------------------

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")
                + "/src/test/java/Data/TableDemoData.json");
        return new Object[][] {{data.get(0)}};
    }

}
