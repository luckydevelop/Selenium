//package tests;
//
//import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.interactions.Actions;
//import utility.DriverClass;
//import utility.DriverEnum;
//import utility.Waits;
//
//import java.util.List;
//
//
//public class Test {
//   // DriverClass driverClass = new DriverClass().getDriver();
//
//
//    public static void main(String[] args) {
////        WebDriver driver = new FirefoxDriver();
////        driver.get("http://store.demoqa.com/products-page/product-category/");
////        WebElement productCategory = driver.findElement(By.xpath(".//*[@id='menu-item-33']/a"));
////        System.out.println(productCategory.getText());
////       // productCategory.click();
////        WebElement iPadsCategory = driver.findElement(By.xpath(".//*[@id='menu-item-36']/a"));
////        System.out.println("ХЗ" + iPadsCategory.getText());
////
////        Actions actions = new Actions(driver);
////        actions.moveToElement(productCategory).perform();
////        WebElement iPadsCategory2 = driver.findElement(By.xpath(".//*[@id='menu-item-36']/a"));
////        System.out.println("ХЗ" + iPadsCategory2.getText());
////
////      //  actions.moveToElement(productCategory).moveToElement(iPadsCategory).click().perform();
////       // actions.moveToElement(iPadsCategory).perform();
////        actions.moveToElement(iPadsCategory).click().perform();
////       // actions.click().perform();
////
////
////
////
////
////
////
//////        String w = "МФУ Epson WorkForce WF-7610DWF с СНПЧ Standart";
//////        boolean res = w.matches("^.*\\w$");
//////        System.out.println(res);
//
//       // WebDriver driver = DriverClass.getDriver(DriverEnum.FIREFOX);
//        WebDriver driver = new FirefoxDriver();
//        Waits waits = new Waits(driver);
//        driver.get("http://lucky-print.com.ua/");
//        driver.manage().window().maximize();
//
//        List<WebElement> showcaseTabs = driver.findElements(By.xpath(".//*[@id='content']/div/div[2]/div[1]/div[1]/ul/li"));
//
//        for (int i = 0; i < showcaseTabs.size(); i++) {
//            WebElement showcaseElement =  showcaseTabs.get(i);
//            System.out.println(showcaseElement);
//            showcaseElement.click();
//
//            System.out.println("Вкладка №" + (i+1) + " " + showcaseElement.getText());
//
//            List<WebElement> showcaseTabsProduct = driver.findElements(By.xpath(".//*[@id='tab"+(i+1)+"']/ul/li"));
//
//            for (int j = 0; j < showcaseTabsProduct.size(); j++) {
//               // .//*[@id='tab1']/ul/li[1]/a
//             //   WebElement product =  showcaseTabsProduct.get(j);
//                WebElement productName = driver.findElement(By.xpath(".//*[@id='tab"+(i+1)+"']/ul/li["+(j+1)+"]/a"));
//                WebElement productPrice = driver.findElement(By.xpath(".//*[@id='tab"+(i+1)+"']/ul/li["+(j+1)+"]/span[1]"));
//                WebElement productCurrency = driver.findElement(By.xpath(".//*[@id='tab"+(i+1)+"']/ul/li["+(j+1)+"]/span[2]"));
//                WebElement productDetails = driver.findElement(By.xpath(".//*[@id='tab"+(i+1)+"']/ul/li["+(j+1)+"]/div[2]/a"));
//                WebElement productImage;
//
//                if(!waits.explicitWaitInvisibilityOfElementLocated(3, By.xpath(".//*[@id='tab"+(i+1)+"']/ul/li["+(j+1)+"]/div[1]/a/img[2]"))) {
//                    productImage = driver.findElement(By.xpath(".//*[@id='tab" + (i + 1) + "']/ul/li[" + (j + 1) + "]/div[1]/a/img[2]"));
//                }
//                else{
//                    productImage = driver.findElement(By.xpath(".//*[@id='tab" + (i + 1) + "']/ul/li[" + (j + 1) + "]/div[1]/a/img[1]"));
//                }
//
//
//                Boolean imagePresent = (Boolean) ((JavascriptExecutor)driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", productImage);
//
//                System.out.println("Имя продукта - " + productName.getText() );
//                System.out.println("Цена продукта - " + productPrice.getText() );
//                System.out.println("Валюта цены - " + productCurrency.getText() );
//                System.out.println("Подробнее - " + productDetails.getText() );
//                System.out.println("Картинка видна - " + imagePresent );
//
//               // System.out.println(product.getText());
//
//            }
//        }
//
//
//
//    }
//}
