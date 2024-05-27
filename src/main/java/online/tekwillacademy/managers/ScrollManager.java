package online.tekwillacademy.managers;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ScrollManager {
    public static void ScrollElement(WebElement webElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) DriverManager.getInstance().getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(false);", webElement);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);

        }


    }
}
