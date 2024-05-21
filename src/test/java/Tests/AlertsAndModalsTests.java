package Tests;

import PageObjects.AlertsAndModalsObjects.BootstrapAlerts;
import PageObjects.AlertsAndModalsObjects.BootstrapModals;
import PageObjects.AlertsAndModalsObjects.WindowPopupModal;
import PageObjects.ListBoxObjects.BootstrapListBox;
import PageObjects.ListBoxObjects.DataListFilter;
import TestComponents.BaseTest;
import org.testng.annotations.Test;


public class AlertsAndModalsTests extends BaseTest {

    @Test(priority = 1)
    public void bootstrapAlertsTest(){
        //BOOTSTRAP ALERTS
        BootstrapAlerts bootstrapAlerts = landingPage.goToBootstrapAlerts();
        bootstrapAlerts.bootstrapAlerts();
    }

    @Test(priority = 2)
    public void bootstrapModalsTest(){
        //BOOTSTRAP MODALS
        BootstrapModals bootstrapModals = landingPage.goToBootstrapModals();
        bootstrapModals.bootstrapModalsSingleModal();
        bootstrapModals.bootstrapModalsMultipleModal();
    }

    @Test(priority = 3)
    public void windowPopupModalTest() throws InterruptedException {
        //WINDOW POPUP MODAL
        WindowPopupModal windowPopupModal = landingPage.goToWindowPopupModal();
        windowPopupModal.windowPopupModal();
    }
}
