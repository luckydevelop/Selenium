package utility;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverClass{
    private static final Logger log = Logger.getLogger(new Object() { }.getClass().getEnclosingClass().getSimpleName());

    public static WebDriver getDriver(DriverEnum driverType)
    {
        WebDriver driver = null;

        switch (driverType)
        {
            case FIREFOX:
                driver = new FirefoxDriver();
                log.info("FIREFOX driver returned");
                break;

            case CHROME:
                String exePath = "E:\\Programming\\Programs\\Selenium\\chromedriver.exe";
                System.setProperty("webdriver.chrome.driver", exePath);
                driver = new ChromeDriver();
                log.info("CHROME driver returned");
        }
        return driver;
    }
}
