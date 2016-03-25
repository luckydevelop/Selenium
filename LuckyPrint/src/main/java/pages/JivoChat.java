package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import utility.Waits;

public class JivoChat
{
    private final Logger log = Logger.getLogger(this.getClass().getSimpleName());
    private final WebDriver driver;
    private final Waits waits;

    private final By jivoChatFrameName = By.xpath("//*[@id='jivo_container']");
    private final By messageOnReducedChat = By.xpath(".//*[@id='jivo-label-text']");
    private final By operatorAvatarWithOutPhoto = By.xpath(".//*[@id='header-animate-container']/div[2]/div[1]/div");
    private final By operatorAvatarWithPhoto = By.xpath(".//*[@id='header-animate-container']/div[1]/div[1]/div/img[contains(@src, 's3-eu-west-1.amazonaws.com/jivo-userdata/avatars/')]");
    private final By operatorLabel = By.xpath(".//*[@id='header-animate-container']/div[2]/div[2]/div[1]");
    private final By consultantLabel = By.xpath(".//*[@id='header-animate-container']/div[2]/div[2]/div[2]");
    private final By operatorSayHello = By.xpath(".//*[@id='messages-div-inner']/div[1]/div[2]/div/div/div");
    private final By textArea = By.xpath(".//*[@id='input-field']");

    public JivoChat(WebDriver driver) {
        this.driver = driver;
        waits = new Waits(driver);
    }

    public void waitFrameAndSwitchToIt() {
        log.info("METHOD - " + new Object(){}.getClass().getEnclosingMethod().getName() +" " + jivoChatFrameName.toString());
        waits.explicitWaitFrameToBeAvailableAndSwitchToIt(10, jivoChatFrameName);
        log.info("SwitchTo next frame - " + jivoChatFrameName.toString());
    }

    private WebElement waitVisibilityOfWebElement(int seconds, By xPath) {
        log.info("METHOD - " + new Object(){}.getClass().getEnclosingMethod().getName() + " " + xPath.toString());
        return waits.explicitWaitVisibility(seconds, xPath);
    }

    public String getTextOfMessageOnReducedChat() {
        log.info("METHOD - " + new Object(){}.getClass().getEnclosingMethod().getName());
        String textOfMessageOnReducedChat = waitVisibilityOfWebElement(10, messageOnReducedChat).getText();
        log.info("textOfMessageOnReducedChat is " + textOfMessageOnReducedChat);
        return textOfMessageOnReducedChat;
    }

    private boolean isVisibleWebElemnt(By locator) {
        log.info("METHOD - " + new Object(){}.getClass().getEnclosingMethod().getName());
        boolean res = waits.explicitWaitInvisibilityOfElementLocated(5, locator);
        if(res){
            log.info("Locator - " + locator.toString() +" is NOT visible " + res);
            return false;
        }
        else {
            log.info("Locator - " + locator.toString() +" is visible");
            return true;
        }
    }

    public boolean isVisibleOperatorAvatarWithOutPhoto() {
        log.info("METHOD - " + new Object(){}.getClass().getEnclosingMethod().getName());
        boolean res = isVisibleWebElemnt(operatorAvatarWithOutPhoto);
        if (res) log.info("operatorAvatarWithOutPhoto is visible");
        else log.info("operatorAvatarWithOutPhoto is NOT visible");
        return res;
    }

    public boolean isVisibleOperatorAvatarWithPhoto() {
        log.info("METHOD - " + new Object(){}.getClass().getEnclosingMethod().getName());
        WebElement imageFile;
        Boolean imagePresent;
        try        {
            imageFile =driver.findElement(operatorAvatarWithPhoto);
            imagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", imageFile);

        } catch (Exception e)
        {
            log.info("operatorAvatarWithPhoto is NOT visible");
            return false;
        }
        if(imagePresent) {
           log.info("operatorAvatarWithPhoto is visible");
           return true;
        }
        else  {
            log.info("operatorAvatarWithPhoto is NOT visible");
            return false;
        }
    }

    public String getTextOfOperatorLabel()  {
        log.info("METHOD - " + new Object(){}.getClass().getEnclosingMethod().getName());
        String textOfOperatorLabel = waitVisibilityOfWebElement(3, operatorLabel).getText();
        log.info("textOfOperatorLabel is " + textOfOperatorLabel);
        return textOfOperatorLabel;
    }

    public String getTextOfConsultantLabel()  {
        log.info("METHOD - " + new Object(){}.getClass().getEnclosingMethod().getName());
        String textOfConsultantLabel= waitVisibilityOfWebElement(0, consultantLabel).getText();
        log.info("textOfConsultantLabel is " + textOfConsultantLabel);
        return textOfConsultantLabel;
    }

    public String getTextOperatorSayHelloLabel(int seconds)   {
        log.info("METHOD - " + new Object(){}.getClass().getEnclosingMethod().getName());
        String textOperatorSayHelloLabel= waitVisibilityOfWebElement(seconds, operatorSayHello).getText();
        log.info("textOperatorSayHelloLabel is " + textOperatorSayHelloLabel);
        return textOperatorSayHelloLabel;
    }

    public String getTextOfPlaceholderAttributeOfTextArea()  {
        log.info("METHOD - " + new Object(){}.getClass().getEnclosingMethod().getName());
        String textOfPlaceholderAttributeOfTextArea= waitVisibilityOfWebElement(5, textArea).getAttribute("placeholder");
        log.info("textOfPlaceholderAttributeOfTextArea is " + textOfPlaceholderAttributeOfTextArea);
        return textOfPlaceholderAttributeOfTextArea;
    }

    public void clickOnMessageOnReducedChat()  {
        log.info("METHOD - " + new Object(){}.getClass().getEnclosingMethod().getName());
        driver.findElement(messageOnReducedChat).click();
        log.info("Open JivoChat manually");
    }
}
