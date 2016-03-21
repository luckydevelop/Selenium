//package tests.mainpage;
//
//
//import cucumber.api.Scenario;
//import cucumber.api.java.After;
//import cucumber.api.java.Before;
//import cucumber.api.java.en.Given;
//import cucumber.api.java.en.Then;
//import cucumber.api.java.en.When;
//import org.apache.log4j.Logger;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import pages.JivoChat;
//import pages.MainPage;
//import utility.DriverClass;
//import utility.DriverEnum;
//import utility.Log;
//
//import java.util.HashMap;
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//public class MainPageBannerTabs_Test {
//
//    Logger log;
//    WebDriver driver;
//    MainPage mainPage;
//
//    @Before
//    public void before(Scenario scenario) {
//        Log.startScenario(scenario.getName());
//        driver = DriverClass.getDriver(DriverEnum.FIREFOX);
//       // mainPage = new MainPage(driver);
//        mainPage = new MainPage(driver);
//        log = Logger.getLogger(this.getClass().getSimpleName());
//        Log.startStep(new Object() { }.getClass().getEnclosingMethod().getName());
//    }
//
//    @After
//    public void after(Scenario scenario) {
//        Log.finishScenario(scenario.getName(), scenario.getStatus());
//    }
//
//    @When("^User clicks on banner tabs one by one$")
//    public void user_clicks_on_banner_tabs_one_by_one() throws Throwable {
//        LinkedHashMap<String, String> listFromBannerTabs = mainPage.fullFillListFromBannerTabs();
//        for (Map.Entry<String, String> pair : listFromBannerTabs.entrySet()) {
//            String key = pair.getKey();
//            String value = pair.getValue();
//            System.out.println(String.format("key is %s, value is %s", key, value));
//        }
//    }
//
////    @Then("^All data of products should correspond next:$")
////    public void all_data_of_products_should_correspond_next() throws Throwable {
////
////    }
//}
