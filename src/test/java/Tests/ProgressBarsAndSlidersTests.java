package Tests;

import PageObjects.AlertsAndModalsObjects.BootstrapAlerts;
import PageObjects.AlertsAndModalsObjects.BootstrapModals;
import PageObjects.AlertsAndModalsObjects.WindowPopupModal;
import PageObjects.ListBoxObjects.BootstrapListBox;
import PageObjects.ListBoxObjects.DataListFilter;
import PageObjects.ProgressBarAndSlidersObjects.BootstrapProgressBar;
import TestComponents.BaseTest;
import org.testng.annotations.Test;


public class ProgressBarsAndSlidersTests extends BaseTest {

    @Test
    public void progressBarsAndSlidersTest(){
        //PROGRESS BARS AND SLIDERS
        BootstrapProgressBar bootstrapProgressBar = landingPage.goToBootstrapProgressBar();
        bootstrapProgressBar.bootstrapProgressBar();
    }

}
