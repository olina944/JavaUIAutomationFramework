package online.tekwillacademy;

import javafx.scene.control.Tab;
import online.tekwillacademy.managers.DriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;

public class TestRunner {
    public static void main(String[] args) throws InterruptedException {
        DriverManager manager = DriverManager.getInstance();
        WebDriver driver = manager.getDriver();

        String currentWindowName = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://github.com/olina944/JavaUIAutomationFramework");
        driver.close();

        driver.switchTo().window(currentWindowName);

        DriverManager.getInstance().getDriver().get("https://github.com/olina944/JavaUIAutomationFramework");
        Thread.sleep(5000);
        DriverManager.getInstance().getDriver().quit();
    }
}