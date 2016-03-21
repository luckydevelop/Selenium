package pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.Waits;

import java.util.LinkedHashMap;
import java.util.List;

public class MainPage
{

    public static class Header
    {

    }

    public static class Footer
    {

    }

    public static class Center
    {

    }


    private WebDriver driver;
    private Waits waits;
    private Logger log = Logger.getLogger(this.getClass().getSimpleName());

    By closeButton = By.xpath(".//*[@id='jivo_close_button']");
    By promotedFirstProduct = By.xpath(".//*[@id='tab1']/ul/li[1]/div[1]");
    By basket = By.xpath(".//*[@id='scroll']/div/div[4]/a[2]/p[1]");

    //BannerTabs
    int i, j;
    By tabLists = By.xpath(".//*[@id='content']/div/div[2]/div[1]/div[1]/ul/li");
    By productsInTabLists = By.xpath(".//*[@id='tab" + (i + 1) + "']/ul/li");

    String productsNamesXPath = ".//*[@id='tab%s']/ul/li[%s]/a";
    String productsPricesXPath = ".//*[@id='tab%s']/ul/li[%s]/span[1]";
    String productsCurrenciesXPath = ".//*[@id='tab%s']/ul/li[%s]/span[2]";
    String productsDetailsXPath = ".//*[@id='tab%s']/ul/li[%s]/div[2]/a";
    String productsImagesFirst = ".//*[@id='tab%s']/ul/li[%s]/div[1]/a/img[1]";
    String productsImagesSecond = ".//*[@id='tab%s']/ul/li[%s]/div[1]/a/img[2]";

    public MainPage(WebDriver driver)
    {
        this.driver = driver;
        waits = new Waits(driver);
    }

    public LinkedHashMap<String, String> fullFillListFromBannerTabs()
    {
        LinkedHashMap<String, String> bannerTabsData = new LinkedHashMap<String, String>();
        List<WebElement> bannerTabs = driver.findElements(tabLists);
        int quantityOfBannerTabs = bannerTabs.size();
        log.info("Quantity of tab is " + (quantityOfBannerTabs));
        bannerTabsData.put("QuantityOfTabs", new Integer(quantityOfBannerTabs).toString());


        for (i = 0; i < quantityOfBannerTabs; i++)
        {
            WebElement currentTab = bannerTabs.get(i);
            currentTab.click();
            String nameOfCurrentTab = currentTab.getText();
            log.info("Name of Tab№ " + (i + 1) + " is " + nameOfCurrentTab);
            bannerTabsData.put("Tab№" + (i + 1), nameOfCurrentTab);

            List<WebElement> productsListInCurrentTab = driver.findElements(productsInTabLists);
            int productQuantity = productsListInCurrentTab.size();
            log.info("Quantity of pruducts is " + productQuantity);

            for (j = 0; j < productQuantity; j++)
            {
                WebElement productName = driver.findElement(By.xpath(String.format(productsNamesXPath, i + 1, j + 1)));
                String productNameText = productName.getText();
                bannerTabsData.put("Tab" + (i + 1) + "Product" + (j + 1) + "ProductName", productNameText);
                log.info("Tab" + (i + 1) + ", Product" + (j + 1) + " Name of current product is " + productNameText);

                WebElement productPrice = driver.findElement(By.xpath(String.format(productsPricesXPath, i + 1, j + 1)));
                String productPriceText = productPrice.getText();
                bannerTabsData.put("Tab" + (i + 1) + "Product" + (j + 1) + "ProductPrice", productPriceText);
                log.info("Tab" + (i + 1) + ", Product" + (j + 1) + " Price of current product is " + productPriceText);

                WebElement productCurrency = driver.findElement(By.xpath(String.format(productsCurrenciesXPath, i + 1, j + 1)));
                String productCurrencyText = productCurrency.getText();
                bannerTabsData.put("Tab" + (i + 1) + "Product" + (j + 1) + "ProductCurrency", productCurrencyText);
                log.info("Tab" + (i + 1) + ", Product" + (j + 1) + " Currency of current product is " + productCurrencyText);

                WebElement productDetails = driver.findElement(By.xpath(String.format(productsDetailsXPath, i + 1, j + 1)));
                String productDetailsText = productDetails.getText();
                bannerTabsData.put("Tab" + (i + 1) + "Product" + (j + 1) + "ProductDetail", productDetailsText);
                log.info("Tab" + (i + 1) + ", Product" + (j + 1) + " Text of productDetails label is " + productDetailsText);

                WebElement productImage;
                if (!waits.explicitWaitInvisibilityOfElementLocated(3, (By.xpath(String.format(productsImagesSecond, i + 1, j + 1)))))
                {
                    productImage = driver.findElement((By.xpath(String.format(productsImagesSecond, i + 1, j + 1))));
                } else
                {
                    productImage = driver.findElement((By.xpath(String.format(productsImagesFirst, i + 1, j + 1))));
                }

                Boolean isImagePresent = (Boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", productImage);
                bannerTabsData.put("Tab" + (i + 1) + "Product" + (j + 1) + "isImagePresent", isImagePresent.toString());
                log.info("Tab" + (i + 1) + ", Product" + (j + 1) + " Is Image present on the page - " + isImagePresent);

            }
        }

        return bannerTabsData;
    }

    public void switchToDefaultContent()
    {
        log.info("METHOD - " + new Object()
        {
        }.getClass().getEnclosingMethod().getName());
        driver.switchTo().defaultContent();
        log.info("Switch to default content successfully");
    }

    public void clickOnCloseButton()
    {
        log.info("METHOD - " + new Object()
        {
        }.getClass().getEnclosingMethod().getName());
        driver.findElement(closeButton).click();
        log.info("JivoChat is closed");
    }


    public boolean isCloseButtonVisible()
    {
        log.info("METHOD - " + new Object()
        {
        }.getClass().getEnclosingMethod().getName());
        return waits.isVisibleWebElemnt(closeButton);
    }

    public void clickOnPromotedFirstProduct()
    {
        log.info("METHOD - " + new Object()
        {
        }.getClass().getEnclosingMethod().getName());
        driver.findElement(promotedFirstProduct).click();
        log.info("PromotedFirstProduct is clicked");
    }

    public void clickOnBasket()
    {
        log.info("METHOD - " + new Object()
        {
        }.getClass().getEnclosingMethod().getName());
        driver.findElement(basket).click();
        log.info("Basket is clicked");
    }

}
