package tests;

import cucumber.api.DataTable;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pages.JivoChat;
import pages.MainPage;
import pages.ProductPage;
import utility.Constants;
import utility.DriverClass;
import utility.DriverEnum;
import utility.Log;

import java.util.List;
import java.util.Map;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;


public class JivoChatTest {
    private WebDriver driver;
    private JivoChat jivoChat;
    private MainPage mainPage;
    private ProductPage productPage;
    private Logger log;

    @Before
    public void before(Scenario scenario) {
        Log.startScenario(scenario.getName());
        log = Logger.getLogger(this.getClass().getSimpleName());
    }

    @After
    public void after(Scenario scenario) {
        Log.finishScenario(scenario.getName(), scenario.getStatus());
        driver.close();
    }

    @Given("^User starts new browser session$")
    public void userStartsNewBrowserSession() throws Throwable {
        Log.startStep(new Object() { }.getClass().getEnclosingMethod().getName());
        driver = DriverClass.getDriver(DriverEnum.FIREFOX);
        jivoChat = new JivoChat(driver);
        mainPage = new MainPage(driver); //!!!
    }

    @Given("^User opens home page$")
    public void userOpensHomePage() throws Throwable {
        Log.startStep(new Object() { }.getClass().getEnclosingMethod().getName());
        driver.get("http://lucky-print.com.ua/");
        driver.manage().window().maximize();
    }

    @And("^JivoChat window is present and reduced$")
    public void jivochatWindowIsPresentAndReduced() throws Throwable {
        Log.startStep(new Object() { }.getClass().getEnclosingMethod().getName());
        jivoChat.waitFrameAndSwitchToIt();
        String textOfMessageOnReducedChat = jivoChat.getTextOfMessageOnReducedChat();
        assertEquals("Онлайн чат", textOfMessageOnReducedChat);
        log.info("JivoChat is closed");
    }

    ////********************* "Open Jivochat automatically and closed manually" scenario

    @When("^JivoChat is opened automatically with certain delay$")
    public void jivochatIsOpenedAutomaticallyWithCertainDelay() throws Throwable {
        log.info("********** Start \"Open Jivochat automatically and closed manually\" scenario");
        Log.startStep(new Object() { }.getClass().getEnclosingMethod().getName());
        jivoChat.getTextOperatorSayHelloLabel(Constants.JIVO_CHAT_WAITING_TIME);
        log.info("JivoChat is open");
    }

    @Then("^JivoChat window is opened automatically and contains the following:$")
    public void jivochatWindowIsOpenedAutomaticallyAndContainsTheFollowing(DataTable arg) throws Throwable {
        Log.startStep(new Object() { }.getClass().getEnclosingMethod().getName());
        List<Map<String, String>> dataTable = arg.asMaps(String.class, String.class);

        for (Map<String, String> map : dataTable) {
            String textAreaMessage = jivoChat.getTextOfPlaceholderAttributeOfTextArea();
            assertEquals(map.get("Textarea"), textAreaMessage);

            String textHelloMessage = jivoChat.getTextOperatorSayHelloLabel(0);
            assertThat(textHelloMessage, containsString(map.get("HelloMessage")));

            String operatorText = jivoChat.getTextOfOperatorLabel();
            assertThat(operatorText.toLowerCase(), containsString(map.get("Operator")));

            String consultantText = jivoChat.getTextOfConsultantLabel();
            assertEquals(map.get("Consultant"), consultantText);

            log.info("Check whether avatar is present. Variant with and without photo is possible");
            boolean imagePresent = jivoChat.isVisibleOperatorAvatarWithPhoto();
            boolean imageEmptyPresent = jivoChat.isVisibleOperatorAvatarWithOutPhoto();
            assertThat(true, anyOf(is(imagePresent), is(imageEmptyPresent)));

            log.info("Check whether CloseButton is present");
            mainPage.switchToDefaultContent();
            boolean closeButtonVisible = mainPage.isCloseButtonVisible();
            assertTrue(closeButtonVisible);
        }
    }

    @And("^User closes JivoChat$")
    public void user_closes_JivoChat() throws Throwable {
        Log.startStep(new Object() { }.getClass().getEnclosingMethod().getName());
        mainPage.switchToDefaultContent();
        mainPage.clickOnCloseButton();

        boolean isCloseButtonVisible = mainPage.isCloseButtonVisible();
        assertFalse(isCloseButtonVisible);
        driver.switchTo().frame("jivo_container");
    }

    ////********************* "Open and close JivoChat manually" scenario

    @When("^User opens JivoChat$")
    public void userOpensJivoChat() throws Throwable {
        log.info("Start \"Open and close JivoChat manually\" scenario");
        Log.startStep(new Object() { }.getClass().getEnclosingMethod().getName());
        jivoChat.clickOnMessageOnReducedChat();
    }

    @Then("^JivoChat window is opened manually and contains the following:$")
    public void jivochatWindowIsOpenedManuallyAndContainsTheFollowing(DataTable arg) throws Throwable {
        Log.startStep(new Object() { }.getClass().getEnclosingMethod().getName());
        List<Map<String, String>> elements = arg.asMaps(String.class, String.class);

        log.info("JivoChat window is opened manually and we check textarea and operator");
        for (Map<String, String> element : elements) {
            assertEquals(element.get("Textarea"), jivoChat.getTextOfPlaceholderAttributeOfTextArea());
            assertThat(jivoChat.getTextOfOperatorLabel(), either(containsString(element.get("Operator2"))).or(containsString(element.get("Operator"))));
        }
    }

    //******************************** Start "Jivochat present on all pages" scenario"
    @When("^User loads \"(.*)\"$")
    public void userLoadsPages(String url) throws Throwable {
        Log.startStep(new Object() { }.getClass().getEnclosingMethod().getName());
        driver.get(url);
        driver.manage().window().maximize();
    }

    //******************************** Scenario: Jivochat present on basket page

    @And("^User selects product from promo banner$")
    public void userSelectsProductFromPromoBanner() throws Throwable {
        Log.startStep(new Object() { }.getClass().getEnclosingMethod().getName());

        mainPage.clickOnPromotedFirstProduct();
        log.info("User click on first promoted product");
    }

    @And("^User adds product to basket$")
    public void userAddsProductToBasket() throws Throwable {
        productPage = new ProductPage(driver);
        productPage.clickOnBuyButton();
    }

    @When("^User selects basket$")
    public void userSelectsBasket() throws Throwable {
        mainPage.clickOnBasket();
        log.info("User click on basket");
    }
}
