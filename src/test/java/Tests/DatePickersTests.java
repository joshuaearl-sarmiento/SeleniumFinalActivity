package Tests;

import PageObjects.AlertsAndModalsObjects.BootstrapAlerts;
import PageObjects.AlertsAndModalsObjects.BootstrapModals;
import PageObjects.AlertsAndModalsObjects.WindowPopupModal;
import PageObjects.DatePickersObjects.DatePickers;
import PageObjects.ListBoxObjects.BootstrapListBox;
import PageObjects.ListBoxObjects.DataListFilter;
import PageObjects.ProgressBarAndSlidersObjects.BootstrapProgressBar;
import PageObjects.TableDemoObjects.TableSortAndSearch;
import TestComponents.BaseTest;
import org.testng.annotations.Test;


public class DatePickersTests extends BaseTest {

    @Test
    public void datePickersTest(){
        //DATE PICKERS
        DatePickers datePickers = landingPage.goToDatePickersDemo();
        datePickers.bootstrapDateExample();
        datePickers.bootstrapDateRangeExample();
    }

}
