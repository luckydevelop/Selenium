package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utility.Waits;

public class BeforeBasketPage {
    private final WebDriver driver;
    private final Waits waits;
    private final Logger log = Logger.getLogger(this.getClass().getSimpleName());

    private final By backToBuying = By.xpath(".//*[@id='basket_popup']/a");

    public BeforeBasketPage(WebDriver driver){
                this.driver=driver;
        waits = new Waits(driver);
    }

    public void clickOnBackToBuying(){
        log.info("METHOD - " + new Object(){}.getClass().getEnclosingMethod().getName());
        waits.explicitWaitVisibility(5, backToBuying).click();
        log.info("BackToBuying is clicked");
    }
}
