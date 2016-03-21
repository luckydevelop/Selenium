package utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Waits
{
    private Logger log = Logger.getLogger(new Object(){}.getClass().getName());
    WebDriver driver;

    public Waits(WebDriver driver)
    {
       this.driver = driver;
    }

    public WebElement explicitWaitVisibility(long timeout, By locator)
    {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        log.info("METHOD - " + methodName);

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        WebElement webElement = null;
        try
        {
            webElement = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            log.info("LOCATOR - " + locator.toString() + " "
                    + "\n TEXT OF ELEMENT - " + webElement.getText());
        } catch (Exception e)
        {
            log.error("*** LOCATOR " + locator + " did not find");
        }
        return webElement;
    }

    public boolean explicitWaitInvisibilityOfElementLocated(long timeout, By locator)
    {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        log.info("METHOD - " + methodName);
        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);
        boolean isInVisible = true;
        try
        {
            isInVisible = webDriverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
            log.info("LOCATOR - " + locator.toString() + " " + "is InVisible " + isInVisible );
        } catch (Exception e)
        {
            log.error("*** LOCATOR " + locator + " is NOT InVisible");

            isInVisible = false;
        }
        return isInVisible;
    }

    public boolean isVisibleWebElemnt(By locator)
    {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        log.info("METHOD - " + methodName);
        boolean res = explicitWaitInvisibilityOfElementLocated(3, locator);
        if (res) return false;
        else return true;
    }

    public void explicitWaitFrameToBeAvailableAndSwitchToIt(long timeout, By locator)
    {
        String methodName = new Object(){}.getClass().getEnclosingMethod().getName();
        log.info("METHOD - " + methodName);

        WebDriverWait webDriverWait = new WebDriverWait(driver, timeout);

        try {
            webDriverWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
            log.info("ExplicitWait success with next locator - " + locator.toString());
        } catch (Exception e) {
            log.error("*** LOCATOR " + locator + " did not find");
        }
    }

}
